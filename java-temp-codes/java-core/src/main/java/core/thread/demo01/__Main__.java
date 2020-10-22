package core.thread.demo01;

public class __Main__ {
    public static void main(String[] args) {
        T1 t1 = new T1(2000);
        Thread t2 = new Thread(new T2(1986));
        Runnable r3 = () -> {
            Thread t = Thread.currentThread();
            String tname = "lambda-thread";
            t.setName(tname);
            System.out.println("thread (" + tname + ") started.");
            try {
                t.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread (" + tname + ") ended.");
        };
        Thread t3 = new Thread(r3);
        t1.start();
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        t3.start();

        Throwable t;
        Exception e;
    }
}
