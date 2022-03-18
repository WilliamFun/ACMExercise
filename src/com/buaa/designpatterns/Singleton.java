package com.buaa.designpatterns;

//懒汉式
public class Singleton {
    private static Singleton instance;
    private Singleton(){}

    public static Singleton getInstance(){
        if(instance==null){
            instance = new Singleton();
        }
        return instance;
    }
}
