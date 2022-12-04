package com.example.demo.service.Impl;

import com.example.demo.entity.annotation.BigDecimalConsumer;

import java.math.BigDecimal;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-04-04 17:46
 **/
public class BigDecimalSummaryStatistics implements BigDecimalConsumer {

    private BigDecimal sum;
    public BigDecimalSummaryStatistics() { }


    public BigDecimal combine(BigDecimalSummaryStatistics other) {
      return   sum = sum.add(other.sum)  ;
    }
    @Override
    public void accept(BigDecimal value) {
        if (null  == sum){
            sum =  value ;
        }else {
            // 计算
            sum  = sum.add(value);
        }

    }

    @Override
    public String toString() {
        return "BigDecimalSummaryStatistics{" +
                "sum=" + sum +
                '}';
    }

    public BigDecimal getSum() {
        return sum;
    }
}
