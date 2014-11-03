package com.acoreful.utils.mathxp.impl;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.acoreful.utils.mathxp.MathInterface;
import com.acoreful.utils.mathxp.MathNumber;

public class Power implements MathInterface {
	public static int ROUND_MODE = BigDecimal.ROUND_HALF_UP;
	public static int SCALE = 2;
	static String powerPattern = BLANK + MathInterface.NUMBER_PATTERN + BLANK
			+ "[\\^]{1}" + BLANK + MathInterface.NUMBER_PATTERN + BLANK;
	static Pattern pattern = Pattern.compile(powerPattern);
	static Pattern power = Pattern.compile(BLANK + "[\\^]{1}");

	@Override
	public Pattern getPattern() {
		return pattern;
	}

	@Override
	public int priority() {
		return 3;
	}

	@Override
	public String eval(String expression) {
		Matcher a = MathNumber.pattern.matcher(expression);
		if (a.find()) {
		}
		Matcher p = power.matcher(expression);
		if (p.find()) {
			expression = expression.substring(p.end());
		}
		Matcher b = MathNumber.pattern.matcher(expression);
		if (b.find()) {

		}
		return new BigDecimal(a.group()).pow(
				(int) Double.parseDouble(b.group())).toString();
	}

}
