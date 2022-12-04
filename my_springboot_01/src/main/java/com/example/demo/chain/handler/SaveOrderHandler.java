package com.example.demo.chain.handler;

import com.example.demo.chain.ChainStep;
import com.example.demo.chain.config.CommonStepEnum;
import com.example.demo.chain.context.SaveOrderContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
/**
 * 保存认购单
 */
@Slf4j
@Component
public class SaveOrderHandler extends AbstractBaseHandler {



    @Override
    public ChainStep getStep() {
        return CommonStepEnum.SAVE_ORDER;
    }

    @Override
    public boolean support(SaveOrderContext context) {
        return true;
    }

    @Override
    public void doHandle(SaveOrderContext context) {
        doInsertOrder();
    }

    /**
     * 认购表插入数据
     */
    private void  doInsertOrder() {
       // 入库操作 ......
        System.out.println("insert order 成功 ");
    }
}
