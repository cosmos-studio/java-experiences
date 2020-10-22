package cn.usmile365.app.exec001;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testLogs();
    }

    private void testLogs() {
        String tag = this.getClass().getName();
        Log.v(tag, "verbose");
        Log.d(tag, "debug");
        Log.i(tag, "info");
        Log.w(tag, "warn");
        Log.e(tag, "error");
        Log.wtf(tag, "assert");
        System.out.println("tag \t" + "sysout");
    }
}
