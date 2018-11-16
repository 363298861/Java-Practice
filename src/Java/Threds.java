package Java;

import javafx.concurrent.Worker;

public class Threds implements Runnable {
    int workitem = 0;
    final static int work = 1000;
    final static int THREADS_NUM = 4;

    private void pretendToworkhard(int workitem) {
        try {
            Thread.sleep(5);
        }catch (InterruptedException i){
            i.printStackTrace();
        }
    }

    synchronized
    private int workitem(){
        return workitem++;
    }

    @Override
    public void run() {
        int a = 0;
        int b;
        while((b = workitem()) < work){
            pretendToworkhard(b);
            a++;
        }

        System.out.println(Thread.currentThread().getName() + " did " + a);
    }

    public static void main(String[] args) {
        Threds threds = new Threds();
        Thread[] threads = new Thread[4];
        for(int i = 0; i < 4; i++)
            threads[i] = new Thread(threds, "NO " + i);
        for(int i = 0; i < 4; i++)
             threads[i].start();
        try {
            for(int i = 0; i < 4; i++)
                threads[i].join();
        } catch (InterruptedException i){
            i.printStackTrace();
        }
        System.out.println("all done");
    }
}
