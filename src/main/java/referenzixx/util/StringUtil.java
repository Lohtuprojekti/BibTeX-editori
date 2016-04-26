package referenzixx.util;

import java.util.regex.Pattern;

public class StringUtil {
    public static boolean containsIgnoreCase(String s1, String s2) {
        return Pattern.compile(Pattern.quote(s2), Pattern.CASE_INSENSITIVE).matcher(s1).find();
    }
}
