package hr.fer.math.precision;

import java.math.BigDecimal;
import static hr.fer.math.precision.BD.*;

public class EquationSolver {

	
	public static BigDecimal[] quadraticSolver(BigDecimal a, BigDecimal b, BigDecimal c) {
		BigDecimal D = sub(sqr(b), prod(prod(a, c), BD_4));
		if (ltz(D)) return new BigDecimal[0];
		BigDecimal x1 = div(sum(b.negate(), sqrt(D)), prod(a, BD_2));
		BigDecimal x2 = div(sub(b.negate(), sqrt(D)), prod(a, BD_2));
		return new BigDecimal[] {x1, x2};
	}
	
	
	
}
