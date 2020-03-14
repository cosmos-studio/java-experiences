package core.string;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Properties;
import org.junit.Test;

public class PropertiesTestCase {

    @Test
    public void test01() throws Exception {

        Properties props = new Properties();
        String fileStr = this.getClass().getResource("/core/strings/hello.properties").getFile();
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(fileStr), "UTF-8");
            props.load(reader);
            for (Map.Entry<Object, Object> entry : props.entrySet()) {
                System.out.println(entry.getKey() + "=[" + entry.getValue() + "]");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}
