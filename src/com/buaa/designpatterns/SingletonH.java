package com.buaa.designpatterns;

public class SingletonH {
    private static SingletonH instance = new SingletonH();
    private SingletonH(){}

    public static SingletonH getInstance(){
        return instance;
    }
}
