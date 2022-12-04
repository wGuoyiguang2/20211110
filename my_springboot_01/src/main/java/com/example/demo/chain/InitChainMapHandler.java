//package com.example.demo.chain;
//
//
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.stereotype.Component;
//import org.springframework.util.CollectionUtils;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.Map;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//
//
//@Slf4j
//@Component
//public class InitChainMapHandler implements ApplicationContextAware {
//
//    private static ApplicationContext applicationContext;
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) {
//        InitChainMapHandler.applicationContext = applicationContext;
//    }
//
//    /**
//     * 获取操作类型对应的处理类handler列表
//     *
//     * @param handlerClass    处理类Class
//     * @param stepConfigClass 执行步骤配置Class
//     */
//    public <T extends ChainHandler, E extends StepConfig> Map<OperateType, List<T>> initHandlerMap(Class<T> handlerClass, Class<E> stepConfigClass) {
//        // 获取当前链下的所有step配置类
//        Collection<E> stepConfigBeans = applicationContext.getBeansOfType(stepConfigClass).values();
//        // 获取step配置类中每一个节点对应的处理类handler
//        return stepConfigBeans.stream().collect(Collectors.toMap(StepConfig::getType, o -> initHandlers(o.getStepList(), handlerClass)));
//    }
//
//    /**
//     * 初始化责任链handlers
//     *
//     * @param stepEnums 需要执行的节点
//     */
//    public <T extends ChainHandler> List<T> initHandlers(List<ChainStep> stepEnums, Class<T> handlerClass) {
//        log.info("[{}]初始化责任链节点处理类列表，开始...", handlerClass.getName());
//        if (CollectionUtils.isEmpty(stepEnums)) {
//            throw new RuntimeException("初始化的步骤列表为空！");
//        }
//
//
//        // 获取所有节点处理类handler
//        Collection<T> beans = applicationContext.getBeansOfType(handlerClass).values();
//
//        // 转换为map：<key：step步骤名，value：bean>
//        Map<String, T> beanStepMap = beans.stream().collect(Collectors.toMap(o -> o.getStep().name(), Function.identity(), (k1, k2) -> k2));
//        if (CollectionUtils.isEmpty(beanStepMap)) {
//            throw new RuntimeException("父类[{}]没有扫描到任何节点处理子类，请检查配置！");
//        }
//
//        // 根据传入的步骤列表，获取对应的处理类handler
//        List<T> handlerList = new ArrayList<>();
//        for (ChainStep step : stepEnums) {
//            T t = beanStepMap.get(step.name());
//            if (t == null) {
//                  throw new RuntimeException("步骤[{}]对应的处理类不存在，请检查配置！");
//            }
//            handlerList.add(t);
//        }
//
//        log.info("[{}]初始化责任链节点处理类列表，完成", handlerClass.getName());
//        return handlerList;
//    }
//}
