package core.jdk8.stream;

import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class T1 {

    public static void testFlatMap() {

        List<String> L1 = Arrays.asList("i-1", "i-2");
        List<String> L2 = Arrays.asList("j-1", "j-2");
        List<String> Lx = Arrays.asList("xyz");
        Map<String, List<String>> map = new HashMap<>();
        map.put("list-1", L1);
        map.put("list-2", L2);
        map.put("lsitx", Lx);
        map.values().stream().filter(L -> L.size()>1).flatMap(L -> L.stream()).forEach(System.out::println);

    }
}
