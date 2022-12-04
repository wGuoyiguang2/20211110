//package com.example.demo.chain.controller;
//
//
//import com.example.demo.chain.InitChainMapHandler;
//import com.example.demo.chain.OperateType;
//import com.example.demo.chain.config.BaseStepConfig;
//import com.example.demo.chain.config.OperateTypeEnum;
//import com.example.demo.chain.context.SaveOrderContext;
//import com.example.demo.chain.handler.AbstractBaseHandler;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.util.CollectionUtils;
//
//import javax.annotation.Resource;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.Future;
//
///**
// * 保存认购责任链
// */
//@Slf4j
//@Component
//public class SaveOrderChain implements InitializingBean {
//
//    @Resource
//    private InitChainMapHandler chainFactory;
//
//    /**
//     * 需要执行的节点处理类
//     */
//    private static Map<OperateType, List<AbstractBaseHandler>> handlerMap;
//
//
//    /**
//     * 保存认购-主入口
//     *
//     * @return 返回认购ID
//     */
//    @Transactional
//    public String saveOrderMain() {
//        SaveOrderContext context = new SaveOrderContext();
//        context.setOperateTypeEnum(OperateTypeEnum.SAVE_ORDER_MAIN);
//        execute(context);
//        return context.getRoomGUID();
//    }
//
//
//    /**
//     * 责任链入口
//     *
//     * @param context 上下文对象
//     */
//    private void execute(SaveOrderContext context) {
//        log.info("{}执行开始", context.getOperateTypeEnum().getDesc());
//        long start = System.currentTimeMillis();
//        for (AbstractBaseHandler handler : handlerMap.get(context.getOperateTypeEnum())) {
//            // 这儿也可以考虑 用反射
//            handler.execute(context);
//        }
//
//        // 处理异步节点
//        if (!CollectionUtils.isEmpty(context.getFutures())) {
//            for (Future<?> future : context.getFutures()) {
//                try {
//                    future.get();
//                } catch (Exception e) {
//                    log.error("异步节点执行失败，忽略，err：[{}：{}]", e.getClass().getName(), e.getMessage());
//                }
//            }
//        }
//        log.info("{}执行成功，耗时：{}ms", context.getOperateTypeEnum().getDesc(), System.currentTimeMillis() - start);
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        handlerMap = chainFactory.initHandlerMap(AbstractBaseHandler.class, BaseStepConfig.class);
//    }
//}
