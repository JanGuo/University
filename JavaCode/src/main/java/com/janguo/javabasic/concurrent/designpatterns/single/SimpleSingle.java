package com.janguo.javabasic.concurrent.designpatterns.single;

public class SimpleSingle {
    private static final SimpleSingle simpleSingle = new SimpleSingle();

    private SimpleSingle(){
        // Empty
    }
    public SimpleSingle getInstance(){
        return simpleSingle;
    }
}
