package cn.usmile365.utils.html;

import java.io.File;

public class PageMakerTest {

	public static void main(String[] args) {
//		File picFolder = new File("F:\\_sexy\\sex-��Ů��Ƭ\\2015.04.12 5009 ɳ̲Ů��");
		File picFolder = new File("C:\\Users\\Administrator\\Desktop\\�鲣��\\mm");
		File picFile = new File("F:\\_sexy\\sex-��Ů��Ƭ\\index151130.html");
		String path = "./2015.04.12 5009 ɳ̲Ů��/";
		// String path = "./girl151130/";
		PageMaker.parse(picFolder, picFile, path);
	}

}
