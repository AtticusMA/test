package com.qiusheng.www.functionProgram.InterfaceExtend;

public interface Children extends Parent {

    //继承接口是可以重写默认方法的
//    @Override
//    default void welcome(){
//        message("children hi");
//    }
    //可以修改是否是抽象方法
    @Override
    void welcome();
}
