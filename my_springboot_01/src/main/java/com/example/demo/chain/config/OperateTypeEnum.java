package com.example.demo.chain.config;



import com.example.demo.chain.OperateType;
import lombok.Getter;

@Getter
public enum OperateTypeEnum implements OperateType {

    SAVE_ORDER_MAIN("保存认购-主入口", true),
    UPDATE_ORDER("更新认购", false),
    ;

    private final String desc;
    private final boolean isSave;

    OperateTypeEnum(String desc, boolean isSave) {
        this.desc = desc;
        this.isSave = isSave;
    }
}
