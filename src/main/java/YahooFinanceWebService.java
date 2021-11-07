/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
***/

import java.math.BigDecimal;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class YahooFinanceWebService {
  public static BigDecimal getPrice(final String ticker) {
    Map<String,BigDecimal> stockList=new HashMap<String,BigDecimal>();
    stockList.put("Goo", BigDecimal.valueOf(200));
    stockList.put("Yahoo", BigDecimal.valueOf(500));

    return stockList.get(ticker);
  }
}
