package com.qiusheng.www.functionProgram.lambda;

class User{
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void printName(){
        System.out.println(this.name);
    }

    public User getUser(String s){
        return new User(name);
    }
}
