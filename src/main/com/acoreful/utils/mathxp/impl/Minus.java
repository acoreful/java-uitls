package com.acoreful.utils.mathxp.impl;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.acoreful.utils.mathxp.MathInterface;
import com.acoreful.utils.mathxp.MathNumber;

public class Minus implements MathInterface {
	static String patternString = BLANK + "[-]{1}" + BLANK
			+ MathInterface.NUMBER_PATTERN + BLANK;
	static Pattern pattern = Pattern.compile(patternString);
	static Pattern minus = Pattern.compile(BLANK + "\\-");

	@Override
	public Pattern getPattern() {
		return pattern;
	}


	@Override
	public int priority() {
		return 0;
	}

	@Override
	public String eval(String expression) {
		Matcher p = minus.matcher(expression);
		if (p.find()) {
			expression = expression.substring(p.end());
		}
		Matcher b = MathNumber.pattern.matcher(expression);
		if (b.find()) {

		}
		return new BigDecimal(b.group()).multiply(new BigDecimal("-1"))
				.toString();
	}

}
