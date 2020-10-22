package core.exceptions;

public class TestRunnableException {
    public void runRunnableException() {
        throw new RuntimeException("My Runnable Exception");
    }

    public static void main(String[] args) {
//        new TestRunnableException().runRunnableException();

        try {
            new TestRunnableException().runRunnableException();
        } catch (Exception e) {
            System.out.println("Runnable Exception Occoured. - Exception");
            System.out.println(e.getMessage());
        }

        try {
            new TestRunnableException().runRunnableException();
        } catch (RuntimeException e) {
            System.out.println("Runnable Exception Occoured. - RuntimeException");
            System.out.println(e.getMessage());
        }

    }
}
