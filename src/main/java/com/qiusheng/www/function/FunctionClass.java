package com.qiusheng.www.function;

import java.util.function.Function;

public class FunctionClass {
    public int compute(int a, Function<Integer,Integer> function){
        int result=function.apply(a);
        return result;
    }
}
