package com.janguo.javabasic.concurrent.thread.threadlocal;

public class QueryFromDBAction {

    /**
     * 模拟从数据库中查询出name，并写到线程ThreadLocal封装的Context中
     */
    public void execute(){
        try {
            Thread.sleep(1000L);
        }catch (Exception e){
            e.printStackTrace();
        }
        String name = "JanGuo【name】----"+Thread.currentThread().getName();
        ActionContext.getActionContext().getContext().setName(name);
    }
}
