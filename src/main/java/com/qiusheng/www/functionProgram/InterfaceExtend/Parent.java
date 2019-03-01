package com.qiusheng.www.functionProgram.InterfaceExtend;

public interface Parent {
     //主要测试的目的，是检测java8的新特性，类方法不可以被继承，默认方法可以继承，接口不可以被实例化，但是可以使用匿名类，执行类方法
     String s="sdsdsd";
     //接口的变量一定是静态的，并且必须初始化；
     void message(String s);
     //默认方法不需要子类实现，直接使用接口方法输出内容，默认
     default void welcome(){
          //也可以调用本接口的抽象方法
          message("作为参数，通过子类实现的message方法输出");
          //也可以使用this代表调用的对象
          this.message("这个是调用对象中实现message方法");
     }

     static void staticMethod(){
         System.out.println("这个是来自静态方法");
     }
     String getLastMessage();
}
