package by.zapolski.concurrency.tasks;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Fib implements Runnable{

    private static int count = 0;
    private final int id = count++;

    private int n;
    public Fib(int n) {
        this.n=n;
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            System.out.print("#"+id+":"+getFib(i)+", ");
        }
    }

    private int getFib(int k){
        if (k<2)return 1;
        return getFib(k-2)+getFib(k-1);
    }
}


public class page896 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 15; i++) {
            exec.execute(new Fib(15));
            //new Thread(new Fib(15)).start();
        }
        exec.shutdown();
    }
}
