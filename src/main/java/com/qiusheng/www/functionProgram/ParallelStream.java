package com.qiusheng.www.functionProgram;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.summingDouble;

public class ParallelStream {
    private static final int N = 100000000;
    public Map<Integer,Double> parallelDiceRolls(){
        double fraction=1.0/N;
        return IntStream.range(0,N).parallel().mapToObj(twoDiceThrows()).collect(Collectors.groupingBy(side->side,summingDouble(n->fraction)));
    }

    private IntFunction<Integer> twoDiceThrows() {
        return i->{
                ThreadLocalRandom random =ThreadLocalRandom.current();
                int first=random.nextInt(1,6);
                int second=random.nextInt(1,7);
                return first+second;
        };
    }


}
