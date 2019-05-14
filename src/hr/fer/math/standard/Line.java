package hr.fer.math.standard;

public class Line {
	
	private Point startingPoint;
	private Vector direction;
	
	
	public Line(Vector vector, Point p) {
		this.startingPoint = p;
		this.direction = vector;
	}
	
	public boolean checkPointOnLine(Point p) {
		if ((p.getX() - startingPoint.getX()) * direction.getXComponent() < 0) return false;
		if ((p.getY() - startingPoint.getY()) * direction.getYComponent() < 0) return false;
		return true;
	}
	

	public Point getPoint(double t) {
		return new Point(getXCoeff() * t + getX0(), getYCoeff() * t + getY0());
	}
	
	public Vector getDirection() {
		return direction;
	}
	
	public Point getStarting() {
		return startingPoint;
	}
	

	public double getXCoeff() {
		return direction.getXComponent();
	}
	
	public double getX0() {
		return startingPoint.getX();
	}


	public double getYCoeff() {
		return direction.getYComponent();
	}
	
	public double getY0() {
		return startingPoint.getY();
	}


	
	
	
	
	
}
