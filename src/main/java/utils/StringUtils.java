package utils;

public class StringUtils {

    /**
     * If string is non-null, returns the string; else returns empty string ("").
     */
    public static String emptyIfNull(String string) {
        return string != null ? string : "";
    }

    /**
     * Truncates string if longer than maxLength
     */
    public static String truncate(String string, int maxLength) {
        if (string == null) {
            return null;
        } else if (maxLength < 0) {
            return string;
        } else if (maxLength >= string.length()) {
            return string;
        } else {
            return string.substring(0, maxLength);
        }
    }

    /**
     * Return save string for logging.
     */
    public static String saveString(String str) {
        String[] invalidChars = new String[]{"%0a", "%0A", "%0d", "%0D"};
        String encodeStr = str;
        // java.text.Normalizer.normalize(log, Normalizer.Form.NFKC);
        for (String invalidChar : invalidChars) {
            encodeStr = encodeStr.replace(invalidChar, "");
        }
        return encodeStr;
    }
}
