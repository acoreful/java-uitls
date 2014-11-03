package com.acoreful.utils.mathxp.impl;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.acoreful.utils.mathxp.MathInterface;
import com.acoreful.utils.mathxp.MathNumber;

public class Multiply implements MathInterface {
	static String multiplyPattern = BLANK + MathInterface.NUMBER_PATTERN + BLANK
			+ "[*]{1}" + BLANK + MathInterface.NUMBER_PATTERN + BLANK;
	static Pattern pattern = Pattern.compile(multiplyPattern);
	static Pattern multiply = Pattern.compile(BLANK + "[*]{1}");

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
		Matcher p = multiply.matcher(expression);
		if (p.find()) {
			expression = expression.substring(p.end());
		}
		Matcher b = MathNumber.pattern.matcher(expression);
		if (b.find()) {

		}
		return new BigDecimal(a.group()).multiply(new BigDecimal(b.group()))
				.toString();
	}

}
