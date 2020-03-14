package core.lang;

import org.junit.Test;

public class TypeConverterTestCase {

    @Test
    public void convertFloatToInteger() {
//        System.out.println(new BigInteger("201.0").toString());
//        System.out.println(Integer.valueOf("201.0"));
        System.out.println(Double.valueOf("201.0").intValue() + "");
        System.out.println(Double.valueOf("201.1").intValue() + "");
        System.out.println(Double.valueOf("201.3").intValue() + "");
        System.out.println(Double.valueOf("201.5").intValue() + "");
        System.out.println(Double.valueOf("201.7").intValue() + "");
        System.out.println(Double.valueOf("201.9").intValue() + "");

        System.out.println(Double.valueOf("201.0").toString() + "");
        System.out.println(Double.valueOf("201.9").toString() + "");
    }
}
