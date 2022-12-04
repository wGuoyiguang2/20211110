package com.example.demo.chain.config;


import com.example.demo.chain.ChainStep;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;


@Component
public class SaveOrderMainStep implements BaseStepConfig {

    @Override
    public List<ChainStep> getStepList() {
        List<ChainStep> result = new ArrayList<>();
        result.add(CommonStepEnum.FILL_ORDER);
        result.add(CommonStepEnum.SAVE_ORDER);
        return result;
    }

    @Override
    public OperateTypeEnum getType() {
        return OperateTypeEnum.SAVE_ORDER_MAIN;
    }

}
