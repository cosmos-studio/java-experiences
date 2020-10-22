package cn.usmile365.patterns.template;

public class __Client__ {

    public static void main(String[] args) {
        AbstractTemplate template = null;
        System.out.println("Case 1");
        template = new ConcreteTemplate();
        template.doSthBy2Steps();

        System.out.println("Case 2");
        template = new ConcreteTemplate2();
        template.doSthBy2Steps();
    }

}
