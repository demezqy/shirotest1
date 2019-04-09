package com.java;

public class Demo1 {
    private static Test x;

    public void setX(Test x){

        Demo1.x=x;
        System.out.println(x);
    }
    public static void main(String arg[]){
        System.out.println(Demo1.x);
    }
}
