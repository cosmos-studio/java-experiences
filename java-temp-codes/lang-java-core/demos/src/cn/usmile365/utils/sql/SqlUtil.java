package cn.usmile365.utils.sql;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class SqlUtil {

	public static void updateByPks(File excelFile, File sqlFile,
			String tableName, boolean isNull) {
		Workbook book = null;
		String temp = null;
		PrintWriter pw = null;

		try {
			book = Workbook.getWorkbook(excelFile);
			pw = new PrintWriter(sqlFile);
			Sheet sheet = book.getSheet(0);

			int rowNum = sheet.getRows();
			int colNum = sheet.getColumns();

			// header
			String[] header = new String[colNum];
			for (int i = 0; i < colNum; i++) {
				temp = sheet.getCell(i, 0).getContents();
				header[i] = temp.trim().toUpperCase();
			}
			System.out.println(Arrays.toString(header));

			// keywords
			String[] keywords = new String[colNum];
			for (int i = 0; i < colNum; i++) {
				temp = sheet.getCell(i, 1).getContents().trim();
				keywords[i] = temp.toUpperCase();
			}
			System.out.println(Arrays.toString(keywords));

			String sqlHead = "update " + tableName;
			for (int r = 2; r < rowNum; r++) {
				String setSql = "";
				String pkSql = " where";
				int setCnt = 0;
				int pkCnt = 0;
				for (int c = 0; c < colNum; c++) {
					temp = sheet.getCell(c, r).getContents();
					if (temp.trim().length() == 0) {
						temp = isNull ? null : "''";
					} else {
						temp = "'" + temp + "'";
					}
					if ("SET".equalsIgnoreCase(keywords[c])) {
						setCnt++;
						setSql += (setCnt == 1) ? (" ") : (", ");
						setSql += header[c] + "=" + temp + "";
					} else if ("PK".equalsIgnoreCase(keywords[c])) {
						pkCnt++;
						pkSql += (pkCnt == 1) ? (" ") : (" and ");
						pkSql += header[c] + "=" + temp;
					}
				}
				String sql = sqlHead + setSql + pkSql + ";";
				pw.println(sql);
				System.out.println(sql);
			}
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			book.close();
			if (pw != null) {
				pw.close();
			}
		}
	}

	public static void deleteByPks(File excelFile, File sqlFile,
			String tableName, int[] pkIndexs) {
		Workbook book = null;
		String temp = null;
		PrintWriter pw = null;

		try {
			book = Workbook.getWorkbook(excelFile);
			pw = new PrintWriter(sqlFile);
			Sheet sheet = book.getSheet(0);
			int rowNum = sheet.getRows();
			int colNum = sheet.getColumns();
			String[] header = new String[colNum];
			for (int c : pkIndexs) {
				temp = sheet.getCell(c, 0).getContents().trim().toUpperCase();
				header[c] = temp;
			}
			String delTemplate = "delete from " + tableName + " where ";
			for (int r = 1; r < rowNum; r++) {
				String sql = delTemplate;
				int cnt = 0;
				for (int c : pkIndexs) {
					temp = sheet.getCell(c, r).getContents();
					if (cnt++ != 0) {
						sql += " and ";
					}
					sql += header[c] + "='" + temp + "'";
				}
				sql += ";";
				pw.println(sql);
				System.out.println(sql);
			}
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			book.close();
			if (pw != null) {
				pw.close();
			}
		}
	}

	public static void insertSQL(File excelFile, File sqlFile,
			String tableName, boolean isNull) {
		Workbook book = null;
		String temp = null;
		PrintWriter pw = null;
		try {
			book = Workbook.getWorkbook(excelFile);
			pw = new PrintWriter(sqlFile);
			Sheet sheet = book.getSheet(0);
			int rowNum = sheet.getRows();
			int colNum = sheet.getColumns();
			String insertTemplate = "insert into " + tableName + "(";
			for (int c = 0; c < colNum; c++) {
				temp = sheet.getCell(c, 0).getContents().trim().toUpperCase();
				if (c == 0) {
					insertTemplate += temp;
				} else {
					insertTemplate += ", " + temp;
				}
			}
			insertTemplate += ") values(";
			for (int r = 1; r < rowNum; r++) {
				String sql = insertTemplate;
				for (int c = 0; c < colNum; c++) {
					temp = sheet.getCell(c, r).getContents();
					if (temp.trim().length() == 0) {
						temp = isNull ? null : "''";
					} else {
						temp = "'" + temp + "'";
					}
					sql += (c == 0) ? temp : ", " + temp;
				}
				sql += ");";
				pw.println(sql);
				System.out.println(sql);
			}
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			book.close();
			if (pw != null) {
				pw.close();
			}
		}
	}
}
