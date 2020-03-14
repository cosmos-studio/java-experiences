package frameworks.guava.collections;

import org.junit.Test;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TableTestCase {

    @Test
    public void test_01_commons() {

        Table<Integer, Integer, String> table = HashBasedTable.create();
        table.put(1, 1, "AA");
        table.put(1, 2, "AB");
        table.put(2, 1, "BA");
        table.put(2, 2, "BB");

        System.out.println(table);
        System.out.println(table.row(2));
        System.out.println(table.column(1));
    }

}
