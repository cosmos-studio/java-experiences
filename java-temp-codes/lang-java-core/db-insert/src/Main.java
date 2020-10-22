import java.util.Arrays;


public class Main {
	public static void main(String[] args) {
		System.out.println(Arrays.toString("chenlijunlan # 12345678  # chenlijunlan@126.com".split(" # ")));
		System.out.println(Arrays.toString("chenlijunlan # 12345678  # chenlijunlan@126.com".split("\\s+#\\s+")));
		
	}

}
