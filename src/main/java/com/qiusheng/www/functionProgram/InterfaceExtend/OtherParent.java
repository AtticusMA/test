package com.qiusheng.www.functionProgram.InterfaceExtend;

public interface OtherParent {
    default void welcome(){
        System.out.println("s");
    }
}
