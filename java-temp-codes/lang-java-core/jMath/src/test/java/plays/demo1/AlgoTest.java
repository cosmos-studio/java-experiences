package plays.demo1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.testng.annotations.Test;

public class AlgoTest {

	@Test
	public void testGo() throws IOException {
		String dataFile = Algo.class.getResource("data.txt").getFile();
		BufferedReader br = new BufferedReader(new FileReader(dataFile));
		for (String line = br.readLine(); line != null; line = br.readLine()) {
			String[] item = line.split("\\s");
			System.out.println(Arrays.toString(item));
		}
	}

}
