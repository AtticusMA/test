package com.qiusheng.www.functionProgram;

import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class StringCollector implements Collector<String,StringCombinerTest,String> {

    private static final Set<Characteristics> characteristics = Collections.emptySet();

    //为什么delim 不能被初始化;final必须加初始化，或者加入含参构造函数
    private final  String delim;

    private final String prefix;

    private final String postfix;

    public StringCollector(String delim, String prefix, String postfix) {
        this.delim = delim;
        this.prefix = prefix;
        this.postfix = postfix;
    }

    @Override
    public Supplier<StringCombinerTest> supplier() {
        return ()->new StringCombinerTest(delim,prefix,postfix);
    }

    @Override
    public BiConsumer<StringCombinerTest, String> accumulator() {
        return StringCombinerTest::add;
    }

    @Override
    public BinaryOperator<StringCombinerTest> combiner() {
        return StringCombinerTest::meger;
    }

    @Override
    public Function<StringCombinerTest, String> finisher() {
        return StringCombinerTest::toString;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return characteristics;
    }
}
