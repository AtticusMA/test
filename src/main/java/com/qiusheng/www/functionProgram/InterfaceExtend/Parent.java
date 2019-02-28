package com.qiusheng.www.functionProgram.InterfaceExtend;

public interface Parent {
     //主要测试的目的，是检测java8的新特性，类方法不可以被继承，默认方法可以继承，接口不可以被实例化，但是可以使用匿名类，执行类方法
     void message(String s);
     //默认方法不需要子类实现，直接使用接口方法输出内容，默认
     default void welcome(){
          message("怎么输出");
     }

     static void staticMethod(){
         System.out.println("这个是来自静态方法");
     }
     String getLastMessage();
}
