package hr.fer.math.precision;

import java.math.BigDecimal;
import static hr.fer.math.precision.BD.*;

public class Line {
	
	private Point startingPoint;
	private Vector direction;
	
	
	public Line(Vector vector, Point p) {
		this.startingPoint = p;
		this.direction = vector;
	}
	
	public boolean checkPointOnLine(Point p) {
		if (ltz(prod(sub(p.getX(), startingPoint.getX()), direction.getXComponent()))) return false;
		if (ltz(prod(sub(p.getY(), startingPoint.getY()), direction.getYComponent()))) return false;
		return true;
	}
	

	public Point getPoint(BigDecimal t) {
		return new Point(sum(prod(getXCoeff(), t), getX0()), sum(prod(getYCoeff(), t), getY0()));
	}
	
	public Vector getDirection() {
		return direction;
	}
	
	public Point getStarting() {
		return startingPoint;
	}
	

	public BigDecimal getXCoeff() {
		return direction.getXComponent();
	}
	
	public BigDecimal getX0() {
		return startingPoint.getX();
	}


	public BigDecimal getYCoeff() {
		return direction.getYComponent();
	}
	
	public BigDecimal getY0() {
		return startingPoint.getY();
	}


	
	
	
	
	
}
