package hr.fer.math.precision;

import java.math.BigDecimal;
import java.math.RoundingMode;

import hr.fer.math.Main2;

public class BD {

	public static BigDecimal sum(BigDecimal a, BigDecimal b) {
		return a.add(b);
	}
	
	public static BigDecimal sub(BigDecimal a, BigDecimal b) {
		return a.subtract(b);
	}
	
	public static BigDecimal prod(BigDecimal a, BigDecimal b) {
		return a.multiply(b);
	}
	
	public static BigDecimal div(BigDecimal a, BigDecimal b) {
		return a.divide(b, Main2.precision, RoundingMode.HALF_UP);
	}
	
	public static BigDecimal sqr(BigDecimal a) {
		return a.multiply(a);
	}
	
	public static boolean ltz(BigDecimal a) {
		return (a.compareTo(BigDecimal.ZERO) < 0);
	}
	
	public static boolean gtz(BigDecimal a) {
		return (a.compareTo(BigDecimal.ZERO) > 0);
	}
	
	public static final BigDecimal BD_1 = new BigDecimal(1);
	public static final BigDecimal BD_2 = new BigDecimal(2);
	public static final BigDecimal BD_3 = new BigDecimal(3);
	public static final BigDecimal BD_4 = new BigDecimal(4);
	
	
	
	private static final BigDecimal SQRT_DIG = new BigDecimal(150);
	private static final BigDecimal SQRT_PRE = new BigDecimal(10).pow(SQRT_DIG.intValue());

	/**
	 * Private utility method used to compute the square root of a BigDecimal.
	 * 
	 * @author Luciano Culacciatti 
	 * @url http://www.codeproject.com/Tips/257031/Implementing-SqrtRoot-in-BigDecimal
	 */
	private static BigDecimal sqrtNewtonRaphson  (BigDecimal c, BigDecimal xn, BigDecimal precision){
	    BigDecimal fx = xn.pow(2).add(c.negate());
	    BigDecimal fpx = xn.multiply(new BigDecimal(2));
	    BigDecimal xn1 = fx.divide(fpx,2*SQRT_DIG.intValue(),RoundingMode.HALF_DOWN);
	    xn1 = xn.add(xn1.negate());
	    BigDecimal currentSquare = xn1.pow(2);
	    BigDecimal currentPrecision = currentSquare.subtract(c);
	    currentPrecision = currentPrecision.abs();
	    if (currentPrecision.compareTo(precision) <= -1){
	        return xn1;
	    }
	    return sqrtNewtonRaphson(c, xn1, precision);
	}

	/**
	 * Uses Newton Raphson to compute the square root of a BigDecimal.
	 * 
	 * @author Luciano Culacciatti 
	 * @url http://www.codeproject.com/Tips/257031/Implementing-SqrtRoot-in-BigDecimal
	 */
	public static BigDecimal sqrt(BigDecimal c){
	    return sqrtNewtonRaphson(c,new BigDecimal(1),new BigDecimal(1).divide(SQRT_PRE));
	}
	
	
	
	
}
