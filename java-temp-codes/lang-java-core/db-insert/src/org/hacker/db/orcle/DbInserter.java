package org.hacker.db.orcle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import au.com.bytecode.opencsv.CSVReader;

public class DbInserter {

	public static void main(String[] args) {
		csv2db();
	}

	public static void csv2db() {
		String sourceFile = "C:\\Users\\Administrator\\Desktop\\2000W\\最后50002.csv";
		String db_user = "test";
		String db_password = "test";
		String db_host = "localhost";
		String db_port = "1521";
		String db_SID = "ORCL";
		String tableName = "DB_hotel_2kw";
		insertWithCSVParse(sourceFile, db_user, db_password, db_host, db_port,
				db_SID, tableName);
	}

	private static void text2db() {
		// CSDN 泄密数据
		String sourceTextFile = "C:\\Users\\Administrator\\Desktop\\www.csdn.net.sql";
		String sep_reg = " # ";
		sep_reg = "\\s+#\\s+";
		String db_user = "test";
		String db_password = "test";
		String db_host = "localhost";
		String db_port = "1521";
		String db_SID = "ORCL";
		String preSQL = "insert into DB_CSDN_600W2(seq,user_id,user_pwd,email,YYYYMMDD)"
				+ " values(?,?,?,?,to_char(sysdate,'YYYYMMDD'))";
		insertWithTextParse(sourceTextFile, sep_reg, db_user, db_password,
				db_host, db_port, db_SID, preSQL);

		// 12306 泄密数据
		sourceTextFile = "C:\\Users\\Administrator\\Desktop\\12306 14M裤子.txt";
		sep_reg = "----";
		db_user = "test";
		db_password = "test";
		db_host = "localhost";
		db_port = "1521";
		db_SID = "ORCL";
		preSQL = "insert into DB_12306_14M2(seq,login_id,user_id,user_name,identity_no,user_pwd,tel,email_bak,YYYYMMDD)"
				+ " values(?,?,?,?,?,?,?,?,to_char(sysdate,'YYYYMMDD'))";
		insertWithTextParse(sourceTextFile, sep_reg, db_user, db_password,
				db_host, db_port, db_SID, preSQL);
	}

	private static void insertWithCSVParse(String sourceFile, String db_user,
			String db_password, String db_host, String db_port, String db_SID,
			String tableName) {
		FileReader fr = null;
		Connection conn = null;
		PreparedStatement pstat = null;
		try {
			fr = new FileReader(sourceFile);
			CSVReader reader = new CSVReader(fr);
			String[] lineArr = reader.readNext();
			int headerLen = lineArr.length;
			// get pre SQL
			String preSQL = "insert into " + tableName + "(seq, ";
			String preSQL4Pre = " values(?,";
			for (String str : lineArr) {
				preSQL += str + ", ";
				preSQL4Pre += "?, ";
			}
			preSQL += "YYYYMMDD)";
			preSQL4Pre += "to_char(sysdate,'YYYYMMDD'))";
			preSQL += preSQL4Pre;
			System.out.println(preSQL);
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			conn = DriverManager.getConnection("jdbc:oracle:thin:@" + db_host
					+ ":" + db_port + ":" + db_SID, db_user, db_password);
			conn.setAutoCommit(false);
			pstat = conn.prepareStatement(preSQL);

			// set pre SQL
			int seq = 1;
			while ((lineArr = reader.readNext()) != null) {
				if (lineArr.length == 0) {
					break;
				}
				pstat.setInt(1, seq++);
				for (int i = 2, j = 0; j < lineArr.length; i++, j++) {
					pstat.setString(i, lineArr[j]);
				}
				if (headerLen != lineArr.length) {
					for (int i = lineArr.length + 1; i <= headerLen; i++) {
						pstat.setString(i, null);
					}
				}
				pstat.addBatch();
				if (seq % 100 == 0) {
					pstat.executeBatch();
					conn.commit();
					System.out.println(seq);
				}
			}
			if (seq % 100 != 0) {
				pstat.executeBatch();
				conn.commit();
				System.out.println(seq + " : ok");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeReader(fr);
			closeDbObjects(conn, pstat, null);
		}
	}

	private static void insertWithTextParse(String sourceTextFile,
			String sep_reg, String db_user, String db_password, String db_host,
			String db_port, String db_SID, String preSQL) {
		BufferedReader br = null;
		Connection conn = null;
		PreparedStatement pstat = null;
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			conn = DriverManager.getConnection("jdbc:oracle:thin:@" + db_host
					+ ":" + db_port + ":" + db_SID, db_user, db_password);
			conn.setAutoCommit(false);
			pstat = conn.prepareStatement(preSQL);

			br = new BufferedReader(new FileReader(sourceTextFile));
			String line = null;
			int seq = 1;
			int i = -1;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(sep_reg);
				i = 1;
				pstat.setString(i++, String.valueOf(seq++));
				for (int j = 0; j < values.length; j++) {
					pstat.setString(i++, values[j]);
				}
				pstat.addBatch();
				if (seq % 100 == 0) {
					pstat.executeBatch();
					conn.commit();
					System.out.println(seq);
				}
			}
			if (seq % 100 != 0) {
				pstat.executeBatch();
				conn.commit();
				System.out.println(seq);
				System.out.println("ok");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeReader(br);
			closeDbObjects(conn, pstat, null);
		}
	}

	private static void closeReader(Reader br) {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void closeDbObjects(Connection conn, Statement stat,
			ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stat != null) {
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
