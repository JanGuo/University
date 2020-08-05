package com.janguo.javabasic.jvmcode;

public class TInterfaceDome {
    public static void main(String[] args) {
        TInterface<String> tInterface = new TInerfaceImpl<String>();
        tInterface.show("Hello");
    }


}
