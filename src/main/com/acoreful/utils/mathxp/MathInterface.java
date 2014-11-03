package com.acoreful.utils.mathxp;

import java.util.regex.Pattern;

/**
 * 表达式接口
 * 
 * @author WallenHeng
 * 
 */
public interface MathInterface {
    String NUMBER_PATTERN = "[-]?[0-9]+([.][0-9]*)?";
	String BLANK = "\\s*";// 空格的常量

	Pattern getPattern();// 返回正则表达式

	int priority();// 返回优先级

	/**
	 * 计算结果
	 * 
	 * @param expression
	 * @return
	 */
	String eval(String expression);// 执行表达式
}
