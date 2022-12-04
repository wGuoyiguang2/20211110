package com.example.demo.chain.config;


import com.example.demo.chain.ChainStep;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 更新认购责任链配置
 *
 * @author: fuhuichao
 * @date: 2021/8/23 6:58 下午
 */
@Component
public class UpdateOrderStep implements BaseStepConfig {

    @Override
    public List<ChainStep> getStepList() {
        List<ChainStep> result = new ArrayList<>();
        result.add(CommonStepEnum.FILL_ORDER);
        result.add(CommonStepEnum.CHECK_ORDER_EDIT);

        return result ;
    }

    @Override
    public OperateTypeEnum getType() {
        return OperateTypeEnum.UPDATE_ORDER;
    }

}
