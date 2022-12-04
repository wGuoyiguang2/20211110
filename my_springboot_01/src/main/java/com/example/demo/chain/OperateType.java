package com.example.demo.chain;


/**
 * 操作类型，当责任链中存在多个操作类型共用同一套链节点的场景时使用
 *
 * @author: fuhuichao
 * @date: 2021/8/22 6:36 下午
 */
public interface OperateType {

    /**
     * 描述
     */
    String getDesc();

}
