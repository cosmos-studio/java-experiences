package core.thread.demo02.solution_1;

import core.thread.demo02.biz.ShiCai;

import static core.thread.demo02.biz.BizMocker.mockStep;

public class ShopShicai extends Thread {

    private ShiCai shicai;

    public ShiCai getSchicai() {
        return shicai;
    }

    @Override
    public void run() {
        String name = "shopping-shicai";
        Thread.currentThread().setName(name);
        mockStep(name, 1, "1. 超市买食材");
        mockStep(name, 1, "2. 处理食材");
        this.shicai = new ShiCai();
    }


}