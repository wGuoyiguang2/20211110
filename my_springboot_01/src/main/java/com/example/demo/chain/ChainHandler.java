package com.example.demo.chain;


/**
 * 责任链节点处理handler
 *
 * @author: fuhuichao
 * @date: 2021/8/21 7:16 下午
 */
public interface ChainHandler {

    /**
     * 获取执行步骤
     */
    ChainStep getStep();

}
