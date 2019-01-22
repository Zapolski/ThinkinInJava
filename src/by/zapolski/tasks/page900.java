package by.zapolski.tasks;


import java.util.ArrayList;
import java.util.concurrent.*;

class FibCall implements Callable<String> {

    private static int count = 0;
    private final int id = count++;
    private int n;

    public FibCall(int n) {
        this.n=n;
    }

    @Override
    public String call() {
        int sum=0;
        for (int i = 0; i < n; i++) {
            sum += getFib(i);
        }
        return "#"+id+"("+n+"): "+sum;
    }

    private int getFib(int k){
        if (k<2)return 1;
        return getFib(k-2)+getFib(k-1);
    }
}


public class page900 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new FibCall((int)(Math.random()*50+1))));
        }

        int n=0;
        while (true){
            if (results.size()==0) break;
            if (n == results.size()) n=0;
            if (results.get(n).isDone()){

                try {
                    System.out.println(results.get(n).get());//get() blocks until completion
                }catch (InterruptedException e){
                    System.out.println(e);
                    return;
                }catch (ExecutionException e){
                    System.out.println(e);
                }finally {
                    exec.shutdown();
                }
                results.remove(n);
                n--;

            }
            n++;
        }

        /*for (Future<String> fs: results){
            try {
                System.out.println(fs.get());//get() blocks until completion
            }catch (InterruptedException e){
                System.out.println(e);
                return;
            }catch (ExecutionException e){
                System.out.println(e);
            }finally {
                exec.shutdown();
            }
        }*/
    }
}
