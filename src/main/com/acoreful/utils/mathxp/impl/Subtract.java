package com.acoreful.utils.mathxp.impl;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.acoreful.utils.mathxp.MathInterface;
import com.acoreful.utils.mathxp.MathNumber;

public class Subtract implements MathInterface {
	static String plusPattern = BLANK + MathInterface.NUMBER_PATTERN + BLANK
			+ "[-]{1}" + BLANK + MathInterface.NUMBER_PATTERN + BLANK;
	static Pattern pattern = Pattern.compile(plusPattern);
	static Pattern plus = Pattern.compile(BLANK + "\\-");

	@Override
	public Pattern getPattern() {
		return pattern;
	}

	@Override
	public int priority() {
		return 1;
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
		return new BigDecimal(a.group()).subtract(new BigDecimal(b.group()))
				.toString();
	}

}
