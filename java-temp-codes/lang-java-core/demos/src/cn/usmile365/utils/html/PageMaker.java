package cn.usmile365.utils.html;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class PageMaker {

	public static void parse(File picFolder, File picFile, String path) {
		File[] picList = picFolder.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				String suffix = name.substring(name.lastIndexOf('.'));
				suffix = suffix.toLowerCase();
				Set<String> suffixSet = new HashSet<String>();
				suffixSet.add(".jpg");
				if (suffixSet.contains(suffix)) {
					return true;
				}
				return false;
			}
		});
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(picFile);
			pw.println("<html>");
			pw.println("<head>");
			pw.println("<title>√¿≈Æ£®20151130£©</title>");
			pw.println("</head>");
			for (File pic : picList) {
				pw.print("<image src=\"");
				pw.print(path);
				pw.print(pic.getName());
				pw.println("\" /><br/>");
				System.out.println("'mm/"+pic.getName()+"',");
			}
			pw.println("</html>");
			pw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}
}
