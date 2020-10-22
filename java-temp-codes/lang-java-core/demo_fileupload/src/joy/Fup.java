package joy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

//openCSV 2.3
import au.com.bytecode.opencsv.CSVReader;

public class Fup extends HttpServlet {

	public Fup() {
		super();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		System.out.println("=======");

		String ftype = "";
		InputStream fis = null;

		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest(req);
			FileItem item = null;
			Iterator<FileItem> itr = items.iterator();
			while (itr.hasNext()) {
				item = (FileItem) itr.next();
				if (!item.isFormField()) {
					ftype = item.getName();
					ftype = ftype.length() <= 0 ? "" : ftype.substring(
							ftype.lastIndexOf(".")).toUpperCase();
					fis = item.getInputStream();
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		if (".XLS".equalsIgnoreCase(ftype)) {
			System.out.println("excel 2003-2007");
			Workbook rwb = null;
			Cell cell = null;
			try {
				rwb = Workbook.getWorkbook(fis);
				Sheet sheet = rwb.getSheet(0);
				for (int i = 0; i < sheet.getRows(); i++) {
					String[] str = new String[sheet.getColumns()];
					for (int j = 0; j < sheet.getColumns(); j++) {
						cell = sheet.getCell(j, i);
						str[j] = cell.getContents();
					}
					System.out.println("#" + (i + 1) + "\t"
							+ Arrays.toString(str));
				}
			} catch (BiffException e) {
				e.printStackTrace();
			}
		} else if (".CSV".equalsIgnoreCase(ftype)) {
			System.out.println("CSV file");
			CSVReader reader = new CSVReader(new InputStreamReader(fis));
			List<String[]> lines = reader.readAll();
			int cnt = 1;
			for (String[] line : lines) {
				System.out.print("#" + cnt + "\t");
				System.out.println(Arrays.toString(line));
			}
		} else if (".txt".equalsIgnoreCase(ftype)) {
			System.out.println("Text file");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String line = null;
			int cnt = 1;
			while ((line = br.readLine()) != null) {
				System.out.print("#" + cnt + "\t");
				String[] item = line.split("\\s");
				for (int i = 0; i < item.length; i++) {
					System.out.print(item[i] + "\t");
				}
				System.out.println();
				cnt++;
			}
		} else {
			System.out.println("other type :" + ftype);
		}

		// forward
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

}
