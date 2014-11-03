package com.acoreful.utils.mathxp;


public class Main {

	public static void main(String[] args) {
		 String string = "1+2^(4/2)+5%2+2^3!";
		// String string = "3.2 * ( 5.3+3.4-5.5 / 4  )  +  9 -4 %(5-2) ";
//		String string = "12.11+23*2-2*(-3)*(4.4+3/4)";
//		String string = "12.11+23*2-2*-3*(4.4+3/4)";
//		double d = 12.11 + 23d * 2 - 2 * (-3) * (4.4 + 3 / 4d);
//		System.out.println(d);
		System.out.println("结果是 :" + MathEvaluation.eval(string));
	}
}
