package core.jcf.map;

import java.util.HashMap;

public class HashMapTest {

    public static void testKeyNotExist() {
        HashMap<String, String> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put(null,"Null-Key-Value");
//        map.put(null,null);
        System.out.println(map);
        System.out.println(map.get("Key-not-exists"));
        System.out.println(map.get(null));
    }
}
