package core.jcf.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableJCF {


    public static void testImmutableList() {

        List<String> l = new ArrayList<String>();
        l.add("FULL");
        l.add("LOW");
        final List<String> unmodifiableList = Collections.unmodifiableList(l);

        System.out.println(unmodifiableList);

        //older JDK will not throws exception, which is a bug of JDK itself.
        try {
            unmodifiableList.add("NORMAL");
        } catch (Exception e) {
            System.out.printf("Exception: %s%n", e.getClass().getName());
        }
        System.out.println(unmodifiableList);
    }

    public static void main(String[] args) {
        testImmutableList();
    }
}
