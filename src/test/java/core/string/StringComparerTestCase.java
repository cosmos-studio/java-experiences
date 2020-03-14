package core.string;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class StringComparerTestCase {

    @Test
    public void test1_split_strings() {
        String url = "http://aui-or-ssui-domain/agencyName";
        String[] expSegs = new String[]{"http:", "aui-or-ssui-domain", "agencyName"};

        String[] segs = StringUtils.split(url, '/');
        for (int i = 0; i < segs.length; i++) {
            System.out.printf("%d -> %s%n", i, segs[i]);
        }

        assertNotNull(segs);
        assertEquals(3, segs.length);
        assertArrayEquals(expSegs, segs);
    }

    @Test
    public void test01_isNotBlank() {
        // not empty string
        assertTrue(org.apache.commons.lang3.StringUtils.isNotBlank("abc"));

        // string length = 0
        assertFalse(org.apache.commons.lang3.StringUtils.isNotBlank(""));

        // string only invisible characters
        assertFalse(org.apache.commons.lang3.StringUtils.isNotBlank("      "));
        assertFalse(org.apache.commons.lang3.StringUtils.isNotBlank("\t"));
        assertFalse(org.apache.commons.lang3.StringUtils.isNotBlank("\t\t"));

        // null
        assertFalse(org.apache.commons.lang3.StringUtils.isNotBlank(null));
    }

}