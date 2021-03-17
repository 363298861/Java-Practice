package practice;

public class threadDemo {

    public static class myThread extends Thread{
        public void run(){
            System.out.println("My thread running");
        }
    }

    public static class myRunnable implements Runnable{
        public void run(){
            System.out.println("runnable thread");
        }
    }
    public static void main(String[] args) {
        myThread mt = new myThread();
        mt.start();
        Thread thread = new Thread(){
            public void run(){
                System.out.println("Another thread");
            }
        };
        thread.start();
        myRunnable mr = new myRunnable();
        Thread runnablet = new Thread(mr);
        runnablet.start();
    }
}
