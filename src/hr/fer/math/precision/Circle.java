package hr.fer.math.precision;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static hr.fer.math.precision.BD.*;

public class Circle {

	public static final BigDecimal RADIUS = BD_1.divide(BD_3, 100, RoundingMode.HALF_UP);
	
	private Point center;
	
	public Circle(Point center) {
		this.center = center;
	}
	
	
	public Point[] intersectWithLine(Line line) {
		BigDecimal a = sum(sqr(line.getXCoeff()), sqr(line.getYCoeff()));
		BigDecimal xp = sub(line.getX0(), center.getX());
		BigDecimal yq = sub(line.getY0(), center.getY());
		BigDecimal b = prod(sum(prod(line.getXCoeff(), xp), prod(line.getYCoeff(), yq)), BD_2);
		BigDecimal c = sub(sum(sqr(xp), sqr(yq)), sqr(RADIUS));
		BigDecimal[] ts = EquationSolver.quadraticSolver(a, b, c);
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
	


	public Point getCenter() {
		return center;
	}
	
}
