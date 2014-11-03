package com.acoreful.utils.mathxp.impl;

import java.util.regex.Pattern;

import com.acoreful.utils.mathxp.MathEvaluation;
import com.acoreful.utils.mathxp.MathInterface;

public class Bracket implements MathInterface {

	static String bracketPattern = BLANK + "[(]{1}[^(]*?[)]" + BLANK;
	static Pattern pattern = Pattern.compile(bracketPattern);

	@Override
	public Pattern getPattern() {
		return pattern;
	}

	@Override
	public int priority() {
		return Integer.MAX_VALUE;
	}

	@Override
	public String eval(String expression) {
		expression = expression.trim();
		return MathEvaluation.eval(expression.substring(1,
				expression.length() - 1));
	}

}
