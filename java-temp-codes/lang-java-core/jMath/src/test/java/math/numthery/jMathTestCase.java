package math.numthery;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

public class jMathTestCase {

	@Test
	public void testIsDevidedBy3(){
		boolean result = false;
		boolean expectResult = false;
		int counter = 1;
		LocalTime startTime = LocalTime.now();
		System.out.println("start time:\t" + startTime);
		for (long i = -100; i < 100; i++) {
			if (++counter == 3) {
				counter = 0;
				expectResult = true;
			} else {
				expectResult = false;
			}
			result = JMath.isDevidedBy3(new BigInteger(i + ""));
			Assert.assertEquals(result, expectResult, i + " -> " + result);
		}
		LocalTime entTime = LocalTime.now();
		System.out.println("end time:\t" + entTime);
		System.out.println(startTime.until(entTime, ChronoUnit.SECONDS));
	}

}
