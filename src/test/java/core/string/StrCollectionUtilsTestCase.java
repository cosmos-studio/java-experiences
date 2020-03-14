package core.string;

import org.junit.Assert;
import org.junit.Test;
import utils.StringUtils;

public class StrCollectionUtilsTestCase {

    @Test
    public void testTrancate() {
        String str = "1234567890";

        Assert.assertNull(StringUtils.truncate(null, 1));
        Assert.assertEquals(str, StringUtils.truncate(str, -1));

        Assert.assertEquals("", StringUtils.truncate(str, 0));

        Assert.assertEquals(str, StringUtils.truncate(str, 10));
        Assert.assertEquals(str, StringUtils.truncate(str, 11));

        Assert.assertEquals("12345", StringUtils.truncate(str, 5));
    }
}
