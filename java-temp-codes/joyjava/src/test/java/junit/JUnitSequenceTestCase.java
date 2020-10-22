package junit;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import utils.CodeLineInfo;
import utils.ReflectUtil;

@FixMethodOrder(MethodSorters.DEFAULT)
public class JUnitSequenceTestCase {

    @Test
    public void test1X() {
        CodeLineInfo info = ReflectUtil.currentCodeLineInfo();
        System.out.println(info);
    }

    @Test
    public void test2A() {
        System.out.println(ReflectUtil.currentCodeLineInfo());
    }
}
