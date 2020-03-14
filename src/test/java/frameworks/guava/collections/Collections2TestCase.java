package frameworks.guava.collections;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;

public class Collections2TestCase {

    @Test
    public void testFilter() {
        List list = null;
        try {
            Collections2.filter(null, Predicates.notNull());
        } catch (NullPointerException npe) {
            Assert.assertEquals(NullPointerException.class, npe.getClass());
        }
    }

}
