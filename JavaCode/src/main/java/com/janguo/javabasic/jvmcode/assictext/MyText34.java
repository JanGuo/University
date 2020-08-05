package com.janguo.javabasic.jvmcode.assictext;

public class MyText34 {
    static class QQ{}
    static class A360 {}
    public static class Father{
        public void hardChoice(QQ arg){
            System.out.println("Father choose qq");
        }
        public void hardChoice(QQ qq,A360 arg){
            System.out.println("Father choose A360");
        }
    }
    public static class Son extends Father{
//        public void hardChoice(QQ arg){
//            System.out.println("Son choose qq");
//        }
        public void hardChoice(A360 arg){
            System.out.println("Son choose A360");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        father.hardChoice(new QQ(),new A360());
        son.hardChoice(new QQ());
    }
}
