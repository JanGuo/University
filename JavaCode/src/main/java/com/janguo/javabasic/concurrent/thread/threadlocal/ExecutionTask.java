package com.janguo.javabasic.concurrent.thread.threadlocal;

public class ExecutionTask implements Runnable {

    private QueryFromDBAction queryFromDBAction = new QueryFromDBAction();
    private QueryFromHttpAction queryFromHttpAction = new QueryFromHttpAction();

    @Override
    public void run() {
        queryFromDBAction.execute();
        queryFromHttpAction.execute();

        Context context = ActionContext.getActionContext().getContext();
        System.out.println("Execution: (name)" + context.getName()+"--(http)" + context.getHttp());
    }
}
