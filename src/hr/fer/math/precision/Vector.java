package hr.fer.math.precision;

import java.math.BigDecimal;
import static hr.fer.math.precision.BD.*;

public class Vector {

	private BigDecimal x;
	private BigDecimal y;
	
	public Vector(BigDecimal x, BigDecimal y) {
		this.x = x;
		this.y = y;
		//unitify();
	}
	
	public Vector(Point a, Point b) {
		this(sub(a.getX(), b.getX()), sub(a.getY(), b.getY()));
	}
	
	
	public void unitify() {
		BigDecimal dist = norm();
		x = div(x, dist);
		y = div(y, dist);
	}
	
	public BigDecimal norm() {
		return sqrt(BD.sum(sqr(x), sqr(y)));
	}
	
	public Vector multiply(BigDecimal k) {
		return new Vector(prod(k, x), prod(k, y));
	}
	
	
	public BigDecimal getXComponent() {
		return x;
	}
	
	public BigDecimal getYComponent() {
		return y;
	}
	
	
	public static Vector sum(Vector a, Vector b) {
		return new Vector(BD.sum(a.x, b.x), BD.sum(a.y, b.y));
	}
	
	public Vector orthogonal(boolean handness) {
		if (handness)
			return new Vector(y.negate(), x);
		else
			return new Vector(y, x.negate());
	}
	
	
	public static BigDecimal getCosine(Vector a, Vector b) {
		BigDecimal prod = BD.sum(prod(a.x, b.x), prod(a.y, b.y));
		BigDecimal div = prod(a.norm(), b.norm());
		return div(prod, div);
	}
	
	
	public static boolean crossProduct(Vector a, Vector b) {
		return gtz(sub(prod(a.x, b.y), prod(a.y, b.x)));
	}

	public Vector neg() {
		return new Vector(x.negate(), y.negate());
	}
	
	@Override
	public String toString() {
		return x.doubleValue() + "i + " + y.doubleValue() + "j";
	}
	
	
}
