package com.qiusheng.www.functionProgram.InterfaceExtend;

public interface Children extends Parent {

    @Override
    default void welcome(){
        message("children hi");
    }
}
