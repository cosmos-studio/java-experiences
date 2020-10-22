package cn.usmile365.patterns.template;

import cn.usmile365.util.ReflectUtil;

public abstract class AbstractTemplate {
    public abstract void firstStep();

    public abstract void secondStep();

    public void doSthBy2Steps() {
        System.out.print("================= begin\n => ");
        ReflectUtil.printCurrentMethod();
        firstStep();
        secondStep();
        System.out.println("========== end");
    }
}
