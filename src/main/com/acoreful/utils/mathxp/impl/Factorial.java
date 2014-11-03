package com.acoreful.utils.mathxp.impl;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.acoreful.utils.mathxp.MathInterface;
import com.acoreful.utils.mathxp.MathNumber;

public class Factorial implements MathInterface {
	static String patternString = BLANK + MathInterface.NUMBER_PATTERN + "[\\!]{1}"
			+ BLANK;
	static Pattern pattern = Pattern.compile(patternString);
	static Pattern plus = Pattern.compile(BLANK + "\\+");

	@Override
	public Pattern getPattern() {
		return pattern;
	}

	@Override
	public int priority() {
		return 4;
	}

	@Override
	public String eval(String expression) {
		Matcher a = MathNumber.pattern.matcher(expression);
		if (a.find()) {
			expression = expression.substring(a.end());
		}

		return factorial(Long.parseLong(a.group())).toString();
	}

	private BigDecimal factorial(long number) {
		BigDecimal num = new BigDecimal(1);
		for (long i = 2; i <= number; i++) {
			num=num.multiply(new BigDecimal(i));
		}
		return num;
	}

}
