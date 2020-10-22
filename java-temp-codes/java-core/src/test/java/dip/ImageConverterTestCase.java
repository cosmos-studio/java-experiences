package dip;

import org.junit.Test;

import java.io.File;
import java.util.Date;

public class ImageConverterTestCase {

    @Test
    public void testRgb2Gray() throws Exception {
        String resPath = "/Users/jacobzhao/jacob_space/workspace_java/joyjava/src/test/resources/dip/";
        String res = resPath + "syz.jpeg";
        String dest = resPath + "syz-gray.jpeg";
        ImageConverter.rgb2Gray(res, dest);
        System.out.println(new Date(new File(dest).lastModified()));
    }
}
