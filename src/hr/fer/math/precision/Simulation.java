package hr.fer.math.precision;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static hr.fer.math.precision.BD.*;



public class Simulation {

	private List<Circle> circles = new ArrayList<>();
	
	private Line startingLine;
	private BigDecimal time;
	private int collCounter = 0;
	private int precision;
	private boolean print;
	
	public Simulation(Point starting, Vector speed, double time, int precision, boolean print) {
		this.precision = precision;
		initCircles();
		this.startingLine = new Line(speed, starting);
		this.time = new BigDecimal(time).setScale(precision);
		this.print = print;
	}
	
	
	
	private void initCircles() {
		/*for (int x = 0; x <= 1; x++) {
			for (int y = 0; y <= 1; y++) {
				circles.add(new Circle(new Point(x, y)));
			}
		}*/
		for (int x = -10; x <= 10; x++) {
			for (int y = -10; y <= 10; y++) {
				BigDecimal bdx = new BigDecimal(x).setScale(precision);
				BigDecimal bdy = new BigDecimal(y).setScale(precision);
				circles.add(new Circle(new Point(bdx, bdy)));
			}
		}
	}
	
	
	public Point simulate() {
		Intersection lastIs = null;
		Line line = startingLine;
		printCollision(line);
		
		while (true) {
			lastIs = findIntersection(line, lastIs);
			Line newLine = reflect(lastIs, line);
			BigDecimal dist = Point.getDistance(line.getStarting(), newLine.getStarting());
			if (gtz(sub(time, dist))) {
				printCollision(newLine);
				line = newLine;
				time = sub(time, dist);
			} else {
				Point result = line.getPoint(time);
				printResult(result);
				return result;
			}
		}
	}
	
	
	
	
	
	private void printResult(Point result) {
		if (!print) return;
		System.out.println("Point at t=20s: " + result);
	}



	private void printCollision(Line newLine) {
		if (!print) return;
		System.out.println("Collison point " + collCounter + ": " + newLine.getStarting() + " (direction = " + newLine.getDirection() + ")");
		collCounter++;
	}



	public Intersection findIntersection(Line line, Intersection last) {
		Point point = line.getStarting();
		BigDecimal minDist = new BigDecimal(1000);
		Point collPoint = null;
		Circle collCircle = null;
		for (Circle c : circles) {
			if (last != null && last.c == c) continue;
			Point[] tmp = c.intersectWithLine(line);
			for (Point p : tmp) {
				if (collPoint == null || ltz(sub(Point.getDistance(point, p), minDist))) {
					minDist = Point.getDistance(point, p);
					collPoint = p;
					collCircle = c;
				}
			}
		}
		//System.err.println("Intersection at circle: " + collCircle.getCenter().getX() + " " + collCircle.getCenter().getY());
		//System.err.println("Intersection at point: " + collPoint.getX() + " " + collPoint.getY());
		return new Intersection(collPoint, collCircle);
	}
	
	
	
	public Line reflect(Intersection intersection, Line prevLine) {
		Circle circle = intersection.c;
		Point point = intersection.p;
				
		Vector normal = new Vector(point, circle.getCenter());
		normal.unitify();
		Vector incident = prevLine.getDirection();
		
		BigDecimal cosine = Vector.getCosine(normal, incident);
		//BigDecimal sine = Math.sqrt(1.0 - cosine*cosine);
		
		boolean handness = Vector.crossProduct(normal, incident);
		Vector tangent = normal.orthogonal(handness);
		
		Vector inNormal = normal.multiply(cosine);
		//Vector inTangent = tangent.multiply(sine);
		
		//Vector result = Vector.sum(inNormal.neg(), inTangent);
		//result.unitify();
		Vector result = Vector.sum(incident, inNormal.neg().multiply(BD_2));
		
		return new Line(result, point);
	}
	
	
	
	
	
	
}
