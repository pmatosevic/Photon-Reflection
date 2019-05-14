package hr.fer.math.standard;

public class Circle {

	public static final double RADIUS = 1.0/3.0;
	
	private Point center;
	
	public Circle(Point center) {
		this.center = center;
	}
	
	
	public Point[] intersectWithLine(Line line) {
		double a = square(line.getXCoeff()) + square(line.getYCoeff());
		double b = 2.0 * (line.getXCoeff() * (line.getX0()-center.getX()) 
				+ line.getYCoeff() * (line.getY0() - center.getY()));
		double c = square(line.getX0() - center.getX()) 
				+ square(line.getY0() - center.getY()) - square(RADIUS);
		double[] ts = EquationSolver.quadraticSolver(a, b, c);
		if (ts.length == 0) {
			return new Point[0];
		}
		Point p1 = line.getPoint(ts[0]);
		Point p2 = line.getPoint(ts[1]);
		if (!line.checkPointOnLine(p1)) {
			return new Point[0];
		}
		return new Point[] {p1, p2};
	}
	
	/*public Point[] intersectWithLine1(Line line) {
		double a = 1.0 + square(line.getA()/line.getB());
		double tmp = center.getY() - line.getC() / line.getB();
		double b = 2.0 * (-center.getX() + line.getA()* tmp / line.getB());
		double c = square(center.getX()) + square(tmp) - square(RADIUS);
		double[] sols = EquationSolver.quadraticSolver(a, b, c);
		if (sols.length == 0) {
			return new Point[0];
		}
		Point p1 = new Point(sols[0], line.calculateY(sols[0]));
		Point p2 = new Point(sols[1], line.calculateY(sols[1]));
		if (!line.checkPointOnLine(p1)) {
			return new Point[0];
		}
		return new Point[] {p1, p2};
	}
	
	
	public Point[] intersectWithLine2(Line line) {
		double a = 1.0 + square(line.getB()/line.getA());
		double tmp = center.getX() - line.getC() / line.getA();
		double b = 2.0 * (-center.getY() + line.getB()* tmp / line.getA());
		double c = square(center.getY()) + square(tmp) - square(RADIUS);
		double[] sols = EquationSolver.quadraticSolver(a, b, c);
		if (sols.length == 0) {
			return new Point[0];
		}
		Point p1 = new Point(line.calculateX(sols[0]), sols[0]);
		Point p2 = new Point(line.calculateX(sols[1]), sols[1]);
		if (!line.checkPointOnLine(p1)) {
			return new Point[0];
		}
		return new Point[] {p1, p2};
	}*/
	
	
	private double square(double x) {
		return x*x;
	}


	public Point getCenter() {
		return center;
	}
	
}
