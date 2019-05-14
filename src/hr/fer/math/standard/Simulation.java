package hr.fer.math.standard;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

	private static List<Circle> circles = new ArrayList<>();
	
	private Line startingLine;
	private double time;
	private int collCounter = 0;
	
	public Simulation(Point starting, Vector speed, double time) {
		initCircles();
		this.startingLine = new Line(speed, starting);
		this.time = time;
	}
	
	
	
	private void initCircles() {
		for (int x = -10; x <= 10; x++) {
			for (int y = -10; y <= 10; y++) {
				circles.add(new Circle(new Point(x, y)));
			}
		}
	}
	
	
	
	public Intersection findIntersection(Line line, Intersection last) {
		Point point = line.getStarting();
		double minDist = 1000.0;
		Point collPoint = null;
		Circle collCircle = null;
		for (Circle c : circles) {
			if (last != null && last.c == c) continue;
			Point[] tmp = c.intersectWithLine(line);
			for (Point p : tmp) {
				if (collPoint == null || Point.getDistance(point, p) < minDist) {
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
		
		double cosine = Vector.getCosine(normal, incident);
		//double sine = Math.sqrt(1.0 - cosine*cosine);		// ne treba nam
		
		boolean handness = Vector.crossProduct(normal, incident);
		//Vector tangent = normal.orthogonal(handness); 	// ne treba nam, dovoljno je oduzeti 2 puta projekciju na normalu
		
		Vector inNormal = normal.multiply(cosine*1);
		//Vector inTangent = tangent.multiply(sine*1);		// ne treba nam
		
		//Vector result = Vector.sum(inNormal.neg(), inTangent);
		//result.unitify();
		Vector result = Vector.sum(incident, inNormal.neg().multiply(2));
		
		return new Line(result, point);
	}
	
	
	
	public void simulate() {
		Intersection lastIs = null;
		Line line = startingLine;
		printCollision(line);
		
		while (true) {
			lastIs = findIntersection(line, lastIs);
			Line newLine = reflect(lastIs, line);
			double dist = Point.getDistance(line.getStarting(), newLine.getStarting());
			if (time - dist > 0) {
				printCollision(newLine);
				line = newLine;
				time -= dist;
			} else {
				Point result = line.getPoint(time);
				printResult(result);
				break;
			}
		}
	}
	
	
	
	
	
	private void printResult(Point result) {
		System.out.println("Point at t=20s: " + result);
	}



	private void printCollision(Line newLine) {
		System.out.println("Collison point " + collCounter + ": " + newLine.getStarting() + " (direction = " + newLine.getDirection() + ")");
		collCounter++;
	}
	
	
	
	
	
	
}
