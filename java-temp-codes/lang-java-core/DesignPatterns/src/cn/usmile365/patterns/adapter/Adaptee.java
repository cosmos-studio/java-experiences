package cn.usmile365.patterns.adapter;

import cn.usmile365.util.ReflectUtil;

public class Adaptee {
    public void doOper1(){
        ReflectUtil.printCurrentMethod();
    }
}
