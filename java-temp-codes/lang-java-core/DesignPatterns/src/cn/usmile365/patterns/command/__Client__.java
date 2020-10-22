package cn.usmile365.patterns.command;

public class __Client__ {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker(command);
        invoker.action();
    }

}
