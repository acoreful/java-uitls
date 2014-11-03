package com.acoreful.utils.mathxp.impl;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.acoreful.utils.mathxp.MathInterface;
import com.acoreful.utils.mathxp.MathNumber;

public class Devide implements MathInterface {
	public static int ROUND_MODE = BigDecimal.ROUND_HALF_UP;
	public static int SCALE = 6;
	static String plusPattern = BLANK + MathInterface.NUMBER_PATTERN + BLANK
			+ "[/]{1}" + BLANK + MathInterface.NUMBER_PATTERN + BLANK;
	static Pattern pattern = Pattern.compile(plusPattern);
	static Pattern plus = Pattern.compile(BLANK + "[/]{1}");

	@Override
	public Pattern getPattern() {
		return pattern;
	}

	@Override
	public int priority() {
		return 2;
	}

	@Override
	public String eval(String expression) {
		Matcher a = MathNumber.pattern.matcher(expression);
		if (a.find()) {
			expression = expression.substring(a.end());
		}
		Matcher p = plus.matcher(expression);
		if (p.find()) {
			expression = expression.substring(p.end());
		}
		Matcher b = MathNumber.pattern.matcher(expression);
		if (b.find()) {

		}
		String result = new BigDecimal(a.group()).divide(
				new BigDecimal(b.group()), SCALE, ROUND_MODE).toString();

		return result;
	}

}
