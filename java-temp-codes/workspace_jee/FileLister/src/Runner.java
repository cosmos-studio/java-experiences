import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Runner {

	private File rootPath;

	public Runner(String rootPath) {
		this.rootPath = new File(rootPath);
	}

	public void printList() {
		List<File> fileList = new LinkedList<File>();
		Stack<File> dirStack = new Stack<File>();

		dirStack.push(rootPath);

		while (dirStack.size() != 0) {
			File dir = dirStack.pop();
			File[] allFiles = dir.listFiles();
			for (File fileObj : allFiles) {
				if (fileObj.isDirectory()) {
					dirStack.push(fileObj);
				} else {
					fileList.add(fileObj);
				}
			}
		}

		int count = 0;

		try (PrintWriter pw = new PrintWriter("file.txt")) {
			for (File file : fileList) {
				String[] fileSep = file.getName().split("\\.");
				pw.print(++count + "\t");
				for (int i = fileSep.length - 1; i >= 0; i--) {
					pw.print(fileSep[i] + "\t");
				}
				pw.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
