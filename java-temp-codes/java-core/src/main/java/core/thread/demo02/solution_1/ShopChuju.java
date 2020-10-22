package core.thread.demo02.solution_1;

import core.thread.demo02.biz.ChuJu;

import static core.thread.demo02.biz.BizMocker.mockStep;

public class ShopChuju extends Thread {

    private ChuJu chuju;

    public ChuJu getChuju() {
        return chuju;
    }

    @Override
    public void run() {
        String name = "shopping-chuju";
        Thread.currentThread().setName(name);
        mockStep(name, 1, "1. 下单");
        mockStep(name, 1, "2. 邮寄");
        mockStep(name, 1, "3. 收货");
        this.chuju = new ChuJu();
    }

}
