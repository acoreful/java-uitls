package com.acoreful.utils.mathxp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MathNumber {
    private MathNumber() {
    }

    public static Pattern pattern = Pattern.compile(MathInterface.NUMBER_PATTERN);

    public static Matcher match(String string) {
        Matcher match = pattern.matcher(string);
        if (match.find()) {
            return match;
        }
        throw new RuntimeException(string + " is not a number.");
    }
}
