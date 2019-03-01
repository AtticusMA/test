package com.qiusheng.www.functionProgram.InterfaceExtend;


public class ParentImpl implements Parent {
    @Override
    public void message(String s) {
        System.out.println("ParentImpl");
    }

    @Override
    public String getLastMessage() {
        return "ParentImpl";
    }

}
