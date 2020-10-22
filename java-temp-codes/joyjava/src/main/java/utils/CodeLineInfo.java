package utils;

public class CodeLineInfo {
    private String className;
    private String methodName;
    private int lineNumber;

    public CodeLineInfo(StackTraceElement ste) {
        this.className = ste.getClassName();
        this.methodName = ste.getMethodName();
        this.lineNumber = ste.getLineNumber();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(this.className).append(".")
                .append(this.methodName).append(":")
                .append(this.lineNumber);
        return result.toString();
    }
}
