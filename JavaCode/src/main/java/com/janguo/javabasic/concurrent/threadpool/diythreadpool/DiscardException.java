package com.janguo.javabasic.concurrent.threadpool.diythreadpool;

public class DiscardException extends RuntimeException{

    public DiscardException(String message){
        super(message);
    }
}
