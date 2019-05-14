package hr.fer.math.precision;

import java.math.BigDecimal;
import static hr.fer.math.precision.BD.*;

public class Point {

	
	private BigDecimal x;
	private BigDecimal y;
	
	public Point(BigDecimal x, BigDecimal y) {
		this.x = x;
		this.y = y;
	}

	public BigDecimal getX() {
		return x;
	}

	public BigDecimal getY() {
		return y;
	}
	
	public static BigDecimal getDistance(Point a, Point b) {
		BigDecimal dx = sub(a.getX(), b.getX());
		BigDecimal dy = sub(a.getY(), b.getY());
		return sqrt(sum(sqr(dx), sqr(dy)));
	}
	
	@Override
	public String toString() {
		return "(" + x.doubleValue() + ", " + y.doubleValue() + ")";
	}
	
	
	
}
