package cn.usmile365.patterns.adapter;

import cn.usmile365.util.ReflectUtil;

public class Adapter extends Adaptee implements Target {

    @Override
    public void doOper2() {
        ReflectUtil.printCurrentMethod();
    }

}
