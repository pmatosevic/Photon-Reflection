package hr.fer.math;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import hr.fer.math.precision.Circle;
import hr.fer.math.precision.Intersection;
import hr.fer.math.precision.Line;
import hr.fer.math.precision.Point;
import hr.fer.math.precision.Simulation;
import hr.fer.math.precision.Vector;

public class Main2 {
	
	public static int precision = 100;
	
	public static void main(String[] args) {
		
		
		Vector speed = new Vector(new BigDecimal("1").setScale(precision), new BigDecimal("0").setScale(precision));
		Point point = new Point(new BigDecimal("0.5").setScale(precision), new BigDecimal("0.26").setScale(precision));
		
		Simulation simulation = new Simulation(point, speed, 20.0, precision, true);
		
		Point result = simulation.simulate();
		
		
		
		//checkPrecisions();
		
	}
	
	public static void checkPrecisions() {
		for (int i=11; i<100; i++) {
			try {
				precision = i;
				Vector speed = new Vector(new BigDecimal("1").setScale(precision), new BigDecimal("0").setScale(precision));
				Point point = new Point(new BigDecimal("0.5").setScale(precision), new BigDecimal("0.26").setScale(precision));
				
				Simulation simulation = new Simulation(point, speed, 20.0, precision, false);
				Point result = simulation.simulate();
				
				System.out.println("precision: " + i + " -> result: " + result);
			} catch (Exception ex) {
				System.err.println("precision: " + i + " -> FAIL");
			}
		}
	}
	
	
	
}
