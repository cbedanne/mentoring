/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
***/


import java.math.BigDecimal;
import java.util.function.Function;

public class CalculateNAV {

  private Function<String, BigDecimal> priceFinder;

  public BigDecimal computeStockWorth(
    final String ticker, final int shares) {
    return priceFinder.apply(ticker).multiply(BigDecimal.valueOf(shares));
  }
  //... other methods that use the priceFinder ...



public CalculateNAV(final Function<String, BigDecimal> aPriceFinder) {
  priceFinder = aPriceFinder;
}

  public static void main(String[] args) {
    final CalculateNAV calculateNav = new CalculateNAV(YahooFinanceWebService::getPrice);
    
    System.out.println(String.format("100 shares of Google worth: $%.2f",
      calculateNav.computeStockWorth("GOOG", 100)));
  }
}
