package hr.fer.math.standard;

public class EquationSolver {

	
	public static double[] quadraticSolver(double a, double b, double c) {
		double D = b*b - 4*a*c;
		if (D<0) return new double[0];
		double x1 = (-b + Math.sqrt(D)) / (2*a);
		double x2 = (-b - Math.sqrt(D)) / (2*a);
		return new double[] {x1, x2};
	}
	
	
	
}
