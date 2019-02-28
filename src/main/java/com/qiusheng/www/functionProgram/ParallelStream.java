package com.qiusheng.www.functionProgram;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.summingDouble;

public class ParallelStream {
    //执行的次数
    private static final int N = 100000000;
    public Map<Integer,Double> parallelDiceRolls(){
        //这里的并行的用处是什么
        double fraction=1.0/N;
        return IntStream.range(0,N).parallel().mapToObj(twoDiceThrows()).collect(Collectors.groupingBy(side->side,summingDouble(n->fraction)));
    }

    public Map<Integer,Double> serialDiceRolls(){
        //这里的并行的用处是什么
        double fraction=1.0/N;
        return IntStream.range(0,N).mapToObj(twoDiceThrows()).collect(Collectors.groupingBy(side->side,summingDouble(n->fraction)));
    }

    private IntFunction<Integer> twoDiceThrows() {
        //掷两次骰子事件
        return i->{
                ThreadLocalRandom random =ThreadLocalRandom.current();
                int first=random.nextInt(1,7);
                ///ThreadLocalRandom一个当前进行的随机变量.nextInt(origin,bound) bound不包括在内
                int second=random.nextInt(1,7);
                return first+second;
        };
    }


}
