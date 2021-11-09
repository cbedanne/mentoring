package katas.lambdas;

import java.math.BigDecimal;
import java.util.function.Function;

public class Lambdas {

	static class FinancialCalculationDelegate {

		private final Function<String, BigDecimal> priceFinder;

		public FinancialCalculationDelegate(final Function<String, BigDecimal> apriceFinder) {
			this.priceFinder =apriceFinder;
		}

		public BigDecimal computeStockWorth(final String ticker, final int shares) {
			return priceFinder.apply(ticker).multiply(BigDecimal.valueOf(shares));
		}

	}


	public static void calculate(Object o) {
	}
}
