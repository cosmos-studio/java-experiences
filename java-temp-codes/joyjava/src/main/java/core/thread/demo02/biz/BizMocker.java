package core.thread.demo02.biz;

import core.thread.demo02.utils.ThreadUtil;

public class BizMocker {
    public static void mockStep(String who, int sec, String msg) {
        System.out.println(who + " -> " + msg);
        ThreadUtil.sleepSec(sec);
    }

}
