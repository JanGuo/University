package com.janguo.javabasic.concurrent.thread.threadlocal;

public class QueryFromHttpAction {
    /**
     * 模拟从网络中,通过上下文中的name ->查询出http，并写到线程ThreadLocal封装的Context中
     */
    public void execute(){
        Context context  = ActionContext.getActionContext().getContext();
        String http = getHttpByName(context.getName());
        context.setHttp(http);
    }

    public String getHttpByName(String name){
        try {
            Thread.sleep(1000L);
        }catch (Exception e){
            e.printStackTrace();
        }

        return "Http:192.168.1.1 By--"+name;
    }
}
