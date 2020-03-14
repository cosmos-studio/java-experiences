package frameworks.guava.collections;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;
import com.google.common.collect.Sets;

public class SetsTestCase {

    @Test
    public void difference() {
        Set<Integer> set1 = IntStream.rangeClosed(10, 20).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = IntStream.rangeClosed(15, 25).boxed().collect(Collectors.toSet());
        Set<Integer> set3 = Sets.newHashSet(set1);
        System.out.println(set1);
        System.out.println(set2);
        System.out.println(Sets.difference(set1, set2));
        System.out.println(Sets.difference(set2, set1));
        System.out.println(Sets.difference(set1, set3));
        System.out.println(Sets.difference(set1, set3).isEmpty());
    }
}
