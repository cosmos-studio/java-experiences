package cn.usmile365.patterns.command;

import cn.usmile365.util.ReflectUtil;

public class Receiver {
    public Receiver(){
    }
    
    public void action(){
        ReflectUtil.printCurrentMethod();
    }
}
