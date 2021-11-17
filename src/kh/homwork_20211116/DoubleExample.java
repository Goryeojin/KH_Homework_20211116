package kh.homwork_20211116;

import java.math.BigDecimal;
import java.math.MathContext;

public class DoubleExample {
	
	public static void main(String[] args) {
		
		double num1 = 13.44;
		double num2 = 2.44;
		
		System.out.println(num1 + num2);	// 15.879999999999999
		System.out.println(num1 - num2);	// 11.0
		System.out.println(num1 * num2);	// 32.7936
		System.out.println(num1 / num2);	// 5.508196721311475
		
		BigDecimal big1 = new BigDecimal(String.valueOf(num1));
		BigDecimal big2 = new BigDecimal(String.valueOf(num2));
		
		System.out.println(big1.add(big2));	// 15.88
		System.out.println(big1.subtract(big2));	// 11.00
		System.out.println(big1.multiply(big2));	// 32.7936
		System.out.println(big1.divide(big2, MathContext.DECIMAL32));
		// 5.505197
		
	}

}
