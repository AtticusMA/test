package com.qiusheng.www.functionProgram.InterfaceExtend;

public class Test {
    public static void main(String[] args){
        Parent parent = new Parent() {
            @Override
            public void message(String s) {
                System.out.println("匿名类");
            }

            @Override
            public String getLastMessage() {
                return "匿名类";
            }
        };
        System.out.println("========默认方法=========");
        parent.welcome();
        System.out.println("======匿名类的实现方法=========");
        String s=parent.getLastMessage();
        System.out.println(s);
        System.out.println("======匿名类的实现方法========");
        parent.message("匿名类");
        System.out.println("如何实现静态方法");
        Test test = new Test();
        Parent.staticMethod();
        //接口的静态方法不能继承
        //默认方法应该可以传到子类以及实现类
        System.out.println("默认方法应该可以传到子类以及实现类");
        ParentImpl parent1 = new ParentImpl();
        parent1.welcome();
        Children children=new ChildrenImpl();
        children.welcome();
        //实现类不能执行类接口
        //实现两个接口有同样默认方法
        System.out.println("实现两个接口有同样默认方法");
        Other other = new Other();
        other.welcome();
        //使用匿名类调用默认方法
        System.out.println("使用匿名类调用默认方法");
        Parent parent2 = new Parent() {
            @Override
            public void message(String s) {
                System.out.println(s+this);
            }

            @Override
            public String getLastMessage() {
                return null;
            }
        };
        parent2.welcome();
    }

}
