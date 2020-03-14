package beans;

public class Speaker {
    public String sayHello(String name) {
        return "hello " + name;
    }

    public String sayHello(Someone sb) {
        return "hello " + sb.getName();
    }
}
