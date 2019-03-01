package com.qiusheng.www.functionProgram.InterfaceExtend;

public class Other implements Parent,OtherParent {
    @Override
    public void message(String s) {
        System.out.println(s);
    }

    @Override
    public String getLastMessage() {
        return null;
    }
    @Override
    public void welcome(){
        Parent.super.welcome();
    }
}
