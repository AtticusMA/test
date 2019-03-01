package com.qiusheng.www.functionProgram.InterfaceExtend;

import com.qiusheng.www.functionProgram.InterfaceExtend.ParentImpl;

public class ParentOverride extends ParentImpl {
    @Override
    public void welcome(){
        message("ParentOverride");
    }
}
