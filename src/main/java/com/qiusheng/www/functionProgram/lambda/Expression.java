package com.qiusheng.www.functionProgram.lambda;

public class Expression {
    public static void main(String[] args){
        //调用静态方法
        refClassMethod ref1=a->Expression.out(a);
        refClassMethod ref2=Expression::out;
        ref2.apply("给接口实现了方法体，之后就可以执行");
        //调用实例的方法
        System.out.println("调用实例方法");
        User user=new User("titit");
        refClassMethod ref3 =x->user.printName();
        //refClassMethod ref8 =user::printName;这种写法就不行
        ref3.apply("user的名字");
        refClassMethod ref4 =ref3::apply;
        System.out.println("======这个输出不了么======");
        ref4.apply("无论写什么字符串，输出的只是ref3实现方法");
        System.out.println("======这个输出不了么=======");
        //引用泛型,调用构造
        refClass<User> ref5 =User::new;
        User user1 = ref5.apply(user.getName());
        System.out.println("===没有重写就是内存的数据无法打印====");
        System.out.println(user1.toString());

    }
    public static void out(String s){
        System.out.println(s);
    }
}
@FunctionalInterface
interface refClassMethod{
    void apply(String s);
}

@FunctionalInterface
interface refClass<T>{
    T apply(String s);
}



