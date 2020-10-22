package cn.usmile365.patterns.template;

import cn.usmile365.util.ReflectUtil;

public class ConcreteTemplate2 extends AbstractTemplate {

    @Override
    public void firstStep() {
        ReflectUtil.printCurrentMethod();
    }

    @Override
    public void secondStep() {
        ReflectUtil.printCurrentMethod();
    }

}
