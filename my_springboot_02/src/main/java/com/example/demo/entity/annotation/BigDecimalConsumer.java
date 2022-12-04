package com.example.demo.entity.annotation;

import java.math.BigDecimal;

@FunctionalInterface
public interface BigDecimalConsumer {

    /**
     * Performs this operation on the given argument.
     *
     * @param value the input argument
     */
    void accept(BigDecimal value);
}
