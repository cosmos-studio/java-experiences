package cn.usmile365.utils.sql;

import java.io.File;

public class SqlUtilTest {
	public static void main(String[] args) {
		String path = SqlUtil.class.getResource(".").getPath();
		File excelFile = new File(path, "data.xls");
		File sqlFile = new File(path, "data.sql");
		String tableName = "User".toUpperCase();
		int[] pks = new int[] { 0, 1 };

		// SqlUtil.insertSQL(excelFile, sqlFile, tableName, true);
		// SqlUtil.deleteByPks(excelFile, sqlFile, tableName, pks);
		SqlUtil.updateByPks(excelFile, sqlFile, tableName, true);
		System.out.println();
		SqlUtil.updateByPks(excelFile, sqlFile, tableName, false);
	}
}
