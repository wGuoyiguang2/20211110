package com.example.demo.utils;

import com.example.demo.entity.annotation.ToBigDecimalFunction;
import com.example.demo.service.Impl.BigDecimalSummaryStatistics;
import java.util.Collections;
import java.util.Set;
import java.util.function.*;
import java.util.stream.Collector;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-04-04 16:20
 **/
public class CollectorsUtil {
    static final Set<Collector.Characteristics> CH_NOID = Collections.emptySet();

    private CollectorsUtil() {
    }

    @SuppressWarnings("unchecked")
    private static <I, R> Function<I, R> castingIdentity() {
        return i -> (R) i;
    }

    static class CollectorImpl<T, A, R> implements Collector<T, A, R> {
        private final Supplier<A> supplier;
        private final BiConsumer<A, T> accumulator;
        private final BinaryOperator<A> combiner;
        private final Function<A, R> finisher;
        private final Set<Characteristics> characteristics;

        CollectorImpl(Supplier<A> supplier, BiConsumer<A, T> accumulator, BinaryOperator<A> combiner,
                      Function<A, R> finisher, Set<Characteristics> characteristics) {
            this.supplier = supplier;
            this.accumulator = accumulator;
            this.combiner = combiner;
            this.finisher = finisher;
            this.characteristics = characteristics;
        }


        // 模仿int写的
        CollectorImpl(Supplier<A> supplier, BiConsumer<A, T> accumulator, BinaryOperator<A> combiner,
                      Set<Characteristics> characteristics) {
            this(supplier, accumulator, combiner, castingIdentity(), characteristics);
        }

        @Override
        public BiConsumer<A, T> accumulator() {
            return accumulator;
        }

        @Override
        public Supplier<A> supplier() {
            return supplier;
        }

        @Override
        public BinaryOperator<A> combiner() {
            return combiner;
        }

        @Override
        public Function<A, R> finisher() {
            return finisher;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return characteristics;
        }
    }


    //  CollectorImpl(Supplier<A> supplier,
    //                      BiConsumer<A, T> accumulator,
    //                      BinaryOperator<A> combiner,
    //                      Set<Characteristics> characteristics)
    public static <T>
    Collector<T, BigDecimalSummaryStatistics, BigDecimalSummaryStatistics> summarizingBigDecimal(ToBigDecimalFunction<? super T>  mapper) {
        return new CollectorImpl<T, BigDecimalSummaryStatistics, BigDecimalSummaryStatistics>(
                BigDecimalSummaryStatistics::new  ,
                // 上一行 new 出来的 BigDecimalSummaryStatistics 对象作为 BiConsumer 的第一个参数
                (r, t) -> r.accept(mapper.applyAsBigDecimal(t)),
                // 上一行 new 出来的 BigDecimalSummaryStatistics 对象作为 BinaryOperator 的第二个参数
                (l, r) -> { l.combine(r); return l; }, CH_NOID);
    }

}
