package core.thread.demo01;

public class T2 implements Runnable {

    private int sleepMillis;

    public T2(int sleepMillis) {
        this.sleepMillis = sleepMillis;
    }


    @Override
    public void run() {
        Thread currThread = Thread.currentThread();
        String currThrName = currThread.getName();
        System.out.println("Thread(" + currThrName + ") started.");
        try {
            Thread.currentThread().sleep(sleepMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread(" + currThrName + ") ended.");
    }
}
