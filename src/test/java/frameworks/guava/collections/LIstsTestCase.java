package frameworks.guava.collections;

import java.util.List;
import java.util.Map;
import org.junit.Test;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class LIstsTestCase {

    @Test
    public void testTransform() {
        Map<String, String> map = Maps.newHashMap();
        map.put("1", "test1");
        map.put("2", "test2");
        Map<String, String> map2 = Maps.newHashMap();
        map2.put("1", "test3");
        map2.put("4", "test2");
        List<Map<String, String>> list2 = Lists.newArrayList();
        list2.add(map);
        list2.add(map2);
        List<String> list3 = Lists.transform(list2, s -> s.get("1"));
        list3.forEach(s -> System.out.println(s));
    }
}
