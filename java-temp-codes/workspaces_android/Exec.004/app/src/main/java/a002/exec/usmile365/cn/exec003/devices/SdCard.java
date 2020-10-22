package a002.exec.usmile365.cn.exec003.devices;

import android.os.Environment;

/**
 * Created by Administrator on 2018-02-03.
 */

public class SdCard {
    public static boolean hadSdCard() {
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }
}
