package core.collections;

import java.util.HashMap;
import org.junit.Test;

public class MapTestCase {

    @Test
    public void hashmap_1() {
        HashMap<String, String> map = new HashMap<>();

        map.put("A", "a");
        map.put("B", null);
        System.out.println(map);

        map.put("A", "a2");
        System.out.println(map);

        map.put(null, null);
        System.out.println(map);

        map.put(null, "A-string");
        System.out.println(map);
    }
}
