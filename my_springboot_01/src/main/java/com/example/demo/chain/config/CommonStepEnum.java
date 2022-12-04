package com.example.demo.chain.config;


import com.example.demo.chain.ChainStep;
import lombok.Getter;


@Getter
public enum CommonStepEnum implements ChainStep {

    // 初始化
    FILL_ORDER("填充认购单"),


    // 保存
    SAVE_ORDER("保存认购"),


    // 编辑
    CHECK_ORDER_EDIT("编辑认购")

    ;

    /**
     * 描述
     */
    private final String desc;

    CommonStepEnum(String desc) {
        this.desc = desc;
    }

}
