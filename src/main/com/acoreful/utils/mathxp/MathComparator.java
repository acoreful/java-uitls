package com.acoreful.utils.mathxp;

import java.util.Comparator;

/**
 * 用于对表达式进行排序
 * 
 * @author luoguo
 * 
 */
public class MathComparator implements Comparator<MathInterface> {

	@Override
	public int compare(MathInterface o1, MathInterface o2) {
		// 用了-1相乘是为了进行倒序排列
		return -1 * Double.compare(o1.priority(), o2.priority());
	}

}
