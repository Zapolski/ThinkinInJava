package by.zapolski.concurrency;

import java.util.concurrent.Callable;

public class TaskWithResult implements Callable<String>{
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    public String call(){
        return "result of TaskWtihResult "+id;
    }
}
