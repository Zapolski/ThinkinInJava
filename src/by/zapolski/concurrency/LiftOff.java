package by.zapolski.concurrency;

public class LiftOff implements Runnable{
    protected int countDown = 10;//default
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff(){}
    public LiftOff(int countDown) {this.countDown=countDown;}
    public String status(){
        return "#"+id+"("+(countDown>0?countDown:"Liftoff!")+"), ";
    }

    @Override
    public void run() {
        while (countDown-- >0){
            System.out.print(status());
            for (int i = 0; i < 50_000_000; i++) {}
            Thread.yield();
        }
    }
}
