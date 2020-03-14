package frameworks.guava;

import java.util.concurrent.TimeUnit;
import com.google.common.base.Stopwatch;

public class StopwatchTestCase {


    public static void main(String[] args) throws Exception {
        Stopwatch stopwatch = new Stopwatch().start();
        Thread.sleep(2000);
        System.out.println(stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));
        stopwatch.start();
        Thread.sleep(2000);
        System.out.println(stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));
        stopwatch.reset().start();
        Thread.sleep(2000);
        System.out.println(stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));
    }

}
