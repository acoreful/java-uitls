package com.acoreful.utils.mathxp;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;

import com.acoreful.utils.mathxp.impl.Add;
import com.acoreful.utils.mathxp.impl.Bracket;
import com.acoreful.utils.mathxp.impl.Devide;
import com.acoreful.utils.mathxp.impl.Factorial;
import com.acoreful.utils.mathxp.impl.Minus;
import com.acoreful.utils.mathxp.impl.Multiply;
import com.acoreful.utils.mathxp.impl.Power;
import com.acoreful.utils.mathxp.impl.Remainder;
import com.acoreful.utils.mathxp.impl.Subtract;

public final class MathEvaluation {
	private MathEvaluation() {
	}

	static List<MathInterface> mathList = new ArrayList<MathInterface>();
	static {
		addMathExpression(new Add());
		addMathExpression(new Subtract());
		addMathExpression(new Multiply());
		addMathExpression(new Devide());
		addMathExpression(new Minus());
		addMathExpression(new Factorial());
		addMathExpression(new Remainder());
		addMathExpression(new Bracket());
		addMathExpression(new Power());
		Collections.sort(mathList, new MathComparator());
	}

	/**
	 * 用于动态增加新的表达式支持能力
	 * 
	 * @param math
	 */
	public static void addMathExpression(MathInterface math) {
		mathList.add(math);
	}

	/**
	 * 判定是否是一个完整的数字
	 * 
	 * @param string
	 * @return
	 */
	static boolean isSingleNumber(String string) {
		Matcher macher = MathNumber.pattern.matcher(string);
		if (macher.find()) {
			return macher.group().toString().equals(string);
		} else {
			return false;
		}
	}

	/**
	 * 计算结果
	 * 
	 * @param string
	 * @return
	 */
	public static String eval(String string) {
		string = string.trim();
		while (!isSingleNumber(string)) {// 同一优先级的哪个先找到算哪个
			System.out.println("求解算式：" + string);
			boolean found = false;
			for (MathInterface math : mathList) {
				Matcher matcher = math.getPattern().matcher(string);
				if (matcher.find()) {
					String exp = matcher.group();
					String sig = "";
					if (exp.charAt(0) == '-' && matcher.start() != 0) {// 如果不是第一个数字，-号只能当运算符
						sig = "+";
					}
					System.out.println("发现算式：" + exp);
					String evalResult = math.eval(exp);
					evalResult = trimLastZeroAfterDot(evalResult);
					string = string.substring(0, matcher.start()) + sig
							+ evalResult + string.substring(matcher.end());
					System.out.println(exp + "计算结果为：" + evalResult + ",代回原式");
					found = true;
					break;
				}
			}
			if (!found) {
				throw new RuntimeException(string + " 不是合法的数学表达式");
			}
		}
		return string;
	}

	/**
	 * 去掉小数点后面数字最后面的0
	 * 
	 * @param evalResult
	 * @return
	 */
	private static String trimLastZeroAfterDot(String evalResult) {
		if (evalResult.indexOf(".") > 0) {
			int c = evalResult.length();
			for (int i = evalResult.length() - 1; i >= 0; i--) {
				if (evalResult.charAt(i) == '0') {
					c--;
				} else {
					break;
				}
			}
			evalResult = evalResult.substring(0, c);
		}
		return evalResult;
	}
}
