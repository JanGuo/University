package com.janguo.javabasic.concurrent.threadpool.diythreadpool;

/**
 *    丢弃策略
 */
public interface DiscardPolicy {

    void discard() throws DiscardException;

}
