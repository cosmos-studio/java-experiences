package utils;

public class ReflectUtil {

    public static CodeLineInfo currentCodeLineInfo() {
        StackTraceElement[] stackTrace = new Exception().getStackTrace();
        return new CodeLineInfo(stackTrace[1]);
    }

}
