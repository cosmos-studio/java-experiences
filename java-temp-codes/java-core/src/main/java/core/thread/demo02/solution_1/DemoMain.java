package core.thread.demo02.solution_1;


import core.thread.demo02.biz.ChuJu;
import core.thread.demo02.biz.ShiCai;

public class DemoMain {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        cookprogress();
        long endTime = System.currentTimeMillis();
        System.out.println("Time : " + (endTime-startTime) + " ms.");
    }

    private static void cookprogress() throws InterruptedException {
        ShopChuju chujuThread = new ShopChuju();
        chujuThread.start();
        chujuThread.join();
        ChuJu chuju = chujuThread.getChuju();

        ShopShicai shicaiThread = new ShopShicai();
        shicaiThread.start();
        shicaiThread.join();
        ShiCai shicai = shicaiThread.getSchicai();

        chuju.cook(shicai);
    }
}