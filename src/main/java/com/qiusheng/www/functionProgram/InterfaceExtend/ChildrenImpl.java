package com.qiusheng.www.functionProgram.InterfaceExtend;


public class ChildrenImpl implements Children {

    @Override
    public void message(String s) {
        System.out.println(s);
    }

    @Override
    public String getLastMessage() {
        return "zilei";
    }
}
