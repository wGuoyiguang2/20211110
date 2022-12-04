package com.example.demo.chain.handler;


import com.example.demo.chain.ChainHandler;
import com.example.demo.chain.context.SaveOrderContext;
import lombok.extern.slf4j.Slf4j;
import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;


/**
 * 保存认购签约处理handler抽象类
 *
 */
@Slf4j
public abstract class AbstractBaseHandler implements ChainHandler {

    @Resource
    public ExecutorService tradeThreadPoolExecutor;

    /**
     * 每个节点的执行入口
     */
    public void execute(SaveOrderContext context) {
        try {
            long start = System.currentTimeMillis();
            if (support(context)) {
                doHandle(context);
            }
            log.warn("执行节点[{}]，耗时：{}ms", getStep().name(), System.currentTimeMillis() - start);
        } catch (Exception e) {
            log.error(e.getMessage() + " 忽略该异常");

            throw e;
        }
    }

    /**
     * 是否支持执行该节点
     */
    public abstract boolean support(SaveOrderContext context);

    /**
     * 执行该节点逻辑
     */
    public abstract void doHandle(SaveOrderContext context);
}
