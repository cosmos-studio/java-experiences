public class __Test__ {
    public static void main(String[] args) {
        String str = "CFIDHLEJO";
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i)-'A'+1);
            System.out.print(",");
        }
    }

}
