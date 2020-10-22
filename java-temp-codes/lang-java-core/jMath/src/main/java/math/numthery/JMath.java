package math.numthery;

import java.math.BigInteger;

public class JMath {

	public static boolean isDevidedBy3(BigInteger num) {
		BigInteger intZero = new BigInteger("0");
		BigInteger intThree = new BigInteger("3");

		if (num.compareTo(intZero) < 0) {
			num = num.negate();
		}

		boolean is = false;

		char[] numChars = null;
		do {
			BigInteger numTemp = intZero;
			numChars = num.toString().toCharArray();
			for (char c : numChars) {
				numTemp = numTemp.add(new BigInteger("" + c));
			}
			num = numTemp;
		} while (numChars.length > 1);
		is = num.mod(intThree).equals(intZero);

		return is;
	}

}
