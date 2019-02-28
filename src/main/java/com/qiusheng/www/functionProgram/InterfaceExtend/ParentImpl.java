package com.qiusheng.www.functionProgram.InterfaceExtend;

import com.qiusheng.www.functionProgram.InterfaceExtend.Parent;

public class ParentImpl implements Parent {
    @Override
    public void message(String s) {
        System.out.println(s);
    }

    @Override
    public String getLastMessage() {
        return "huoqu";
    }

    @Override
    public void welcome(){

    }
}
