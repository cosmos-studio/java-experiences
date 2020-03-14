package frameworks.guava.collections;

import org.junit.Test;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MultimapTestCase {

    @Test
    public void test1_commons() {
        Multimap<Integer, Character> mmap = ArrayListMultimap.create();
        mmap.put(1, 'A');
        mmap.put(2, 'B');
        mmap.put(1, 'A');
        System.out.println(mmap);

        assertTrue(mmap.get(1).contains('A'));
        assertFalse(mmap.get(1).contains("A"));
        assertEquals(2, mmap.get(1).size());
    }
}
