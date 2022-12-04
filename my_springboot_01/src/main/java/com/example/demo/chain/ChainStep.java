package com.example.demo.chain;


/**
 * 责任链执行步骤
 *
 * @author: fuhuichao
 * @date: 2021/8/21 10:20 下午
 */
public interface ChainStep {

    /**
     * 获取步骤名称
     */
    String name();

    /**
     * 获取步骤描述
     */
    String getDesc();

    /**
     * 是否忽略异常
     */
    default boolean ignoreException() {
        return false;
    }

    /**
     * 是否异步执行（异步执行默认忽略异常）
     */
    default boolean asyncExecute() {
        return false;
    }
}
