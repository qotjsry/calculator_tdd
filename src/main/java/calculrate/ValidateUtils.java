package calculrate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtils {

    public String[] SplitValue(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] values = m.group(2).split(customDelimiter);
            return values;
        }
        return text.split(",|:");
    }

    public boolean checkNull(String value) {
        if (value == null || value.equals("")) {
            return true;
        }
        return false;
    }

}
