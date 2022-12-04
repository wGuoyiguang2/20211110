package com.example.demo.chain;

import java.util.List;


/**
 * 节点配置，当责任链中存在多个操作类型共用同一套链节点的场景时使用
 */
public interface StepConfig {

    /**
     * 执行节点列表
     */
    List<ChainStep> getStepList();

    /**
     * 操作类型
     */
    OperateType getType();

}
