package core.collections;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class ListTestCase {

    @Test
    public void test01_add_to_asList() {
        String[] array = {"1", "2", "3"};

        List<String> list = Arrays.asList(array);

        System.out.println(list);

        try {
            list.add("other");
        } catch (UnsupportedOperationException e) {
            System.out.println("add error");
        }

        System.out.println(list);
    }

}
