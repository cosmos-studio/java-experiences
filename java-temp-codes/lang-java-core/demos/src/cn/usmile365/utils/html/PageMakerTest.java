package cn.usmile365.utils.html;

import java.io.File;

public class PageMakerTest {

	public static void main(String[] args) {
//		File picFolder = new File("F:\\_sexy\\sex-美女照片\\2015.04.12 5009 沙滩女神");
		File picFolder = new File("C:\\Users\\Administrator\\Desktop\\碎玻璃\\mm");
		File picFile = new File("F:\\_sexy\\sex-美女照片\\index151130.html");
		String path = "./2015.04.12 5009 沙滩女神/";
		// String path = "./girl151130/";
		PageMaker.parse(picFolder, picFile, path);
	}

}
