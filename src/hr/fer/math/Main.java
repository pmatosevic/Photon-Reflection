package hr.fer.math;

import java.util.ArrayList;
import java.util.List;

import hr.fer.math.standard.Circle;
import hr.fer.math.standard.Intersection;
import hr.fer.math.standard.Line;
import hr.fer.math.standard.Point;
import hr.fer.math.standard.Simulation;
import hr.fer.math.standard.Vector;

public class Main {
	
	
	public static void main(String[] args) {
		
		Vector speed = new Vector(1, 0);
		Point point = new Point(0.5, 0.26);
		
		Simulation simulation = new Simulation(point, speed, 20.0);
		
		simulation.simulate();
		
		
		
		
		
		
		
		/*Line line = new Line(speed, point);
		Intersection is = simulation.findIntersection(line, null);
		//System.out.println(collPoint.getX() + " " + collPoint.getY());
		
		line = simulation.reflect(is, line);
		System.out.println(line.getX0() + " " + line.getY0());
		System.out.println(line.getXCoeff() + " " + line.getYCoeff());
		System.out.println();
		
		for (int i=0; i<15; i++) {
			is = simulation.findIntersection(line, is);
			line = simulation.reflect(is, line);
			System.out.println("iteration: " + (i+3));
			System.out.println("Point: " + line.getX0() + " " + line.getY0());
			System.out.println("Vector: " + line.getXCoeff() + " " + line.getYCoeff());
			System.out.println();
		}*/
		
		
		
	}
	
	
	
}
