package com.qiusheng.www.functionProgram;

public class StringCombinerTest {
    private String delim;
    private String prefix;
    private String postfix;
    private StringBuilder stringBuilder;

    public StringCombinerTest(){
        super();
    }

    //构造函数中不需要使用StringBuilder
    public StringCombinerTest(String delim, String prefix, String postfix){
        this.delim = delim;
        this.prefix = prefix;
        this.postfix = postfix;
        this.stringBuilder = new StringBuilder();
    }

    public StringCombinerTest add(String element){
        if(this.stringBuilder.length()>0){
            stringBuilder.append(delim);
        }
        stringBuilder.append(element);
        return this;
    }

    public StringCombinerTest meger(StringCombinerTest other){
        if(!this.equals(other)){
            if(this.stringBuilder.length() !=0 && other.stringBuilder.length()!=0 ){
                other.stringBuilder.insert(0,delim);
            }
            this.stringBuilder.append(other.stringBuilder);
        }
        return this;
    }

    @Override
    public String toString() {
        return prefix+this.stringBuilder.toString()+postfix;
    }
}
