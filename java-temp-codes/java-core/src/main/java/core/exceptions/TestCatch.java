package core.exceptions;

public class TestCatch {

    public void testError() {
        throw new Error("My error message.");
    }

    public static void main(String[] args) {
//        new TestCatch().testError();

//        try {
//            new TestCatch().testError();
//        } catch (Exception e) {
//            System.out.println("Error occoured. - Exception");
//        }

        try {
            new TestCatch().testError();
        } catch (Error e) {
            System.out.println("Error occoured. - Error.");
            System.out.println(e.getMessage());
        }

        try {
            new TestCatch().testError();
        } catch (Throwable t) {
            System.out.println("Error occoured. - Throwable.");
            System.out.println(t.getMessage());
        }
    }
}
