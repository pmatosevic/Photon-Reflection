package hr.fer.math.standard;

public class Vector {

	private double x;
	private double y;
	
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
		//unitify();
	}
	
	public Vector(Point a, Point b) {
		this(a.getX() - b.getX(), a.getY() - b.getY());
	}
	
	
	public void unitify() {
		double dist = norm();
		x = x/dist;
		y = y/dist;
	}
	
	public double norm() {
		return Math.sqrt(x*x + y*y);
	}
	
	public Vector multiply(double k) {
		return new Vector(k*x, k*y);
	}
	
	
	public double getXComponent() {
		return x;
	}
	
	public double getYComponent() {
		return y;
	}
	
	
	public static Vector sum(Vector a, Vector b) {
		return new Vector(a.x+b.x, a.y+b.y);
	}
	
	public Vector orthogonal(boolean handness) {
		if (handness)
			return new Vector(-y, x);
		else
			return new Vector(y, -x);
	}
	
	
	public static double getCosine(Vector a, Vector b) {
		double prod = a.x * b.x + a.y * b.y;
		double div = a.norm() * b.norm();
		return prod / div;
	}
	
	
	public static boolean crossProduct(Vector a, Vector b) {
		return (a.x*b.y - a.y*b.x) > 0;
	}

	public Vector neg() {
		return new Vector(-x, -y);
	}
	
	@Override
	public String toString() {
		return x + "i + " + y + "j";
	}
	
	
}
