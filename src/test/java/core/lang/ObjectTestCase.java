package core.lang;

import java.util.Objects;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ObjectTestCase {

    @Test
    public void test01_nullable_1() {
        assertTrue(Objects.isNull(null));
        assertFalse(Objects.isNull(new Object()));
    }

}
