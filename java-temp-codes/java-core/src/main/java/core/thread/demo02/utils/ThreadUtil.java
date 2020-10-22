package core.thread.demo02.utils;

public class ThreadUtil {

    public static void sleepSec(int sec) {
        try {
            Thread.currentThread().sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

