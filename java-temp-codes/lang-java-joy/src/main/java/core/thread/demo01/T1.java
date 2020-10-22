package core.thread.demo01;

public class T1 extends Thread {

    private int sleepMillis;

    public T1(int sleepMillis) {
        this.sleepMillis = sleepMillis;
    }

    @Override
    public void run() {
        System.out.println("thread(" + getName() + ") started.");
        try {
            this.currentThread().sleep(sleepMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread("+getName() + ") ended.");
        super.run();
    }

}
