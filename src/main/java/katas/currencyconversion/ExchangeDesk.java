package katas.currencyconversion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExchangeDesk <CF extends WorldCurrency,CT extends WorldCurrency>{

	List<ConversionRate> conversionsRates=new ArrayList<>();

	public void addRate(Class<CF> from, Class<CT> to, double conversionRate) {
		conversionsRates.add(new ConversionRate(from,to,conversionRate));
		conversionsRates.add(new ConversionRate(to,from,1/conversionRate));
	}

	public CT convert(CF from, Class<CT> toClass) {
		CT convertedCurrency=null;
		try {
			convertedCurrency=toClass.newInstance();
			convertedCurrency.setValue(from.value * getConversionRate(from, toClass));
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return convertedCurrency;
	}

	private Double getConversionRate(CF from, Class<CT> toClass) {
		Double conversionRate = conversionsRates.stream()
				.filter(cr -> from.getClass().equals(cr.convertFrom))
				.filter(cr -> cr.convertTo.equals(toClass))
				.map(cr -> cr.conversionRate)
				.reduce((a, b) -> {
					throw new IllegalStateException("Get two conversion rates for conversion of "
													+ from.getClass().getName() + " to " + toClass.getClass().getName());
				})
				.orElseThrow(() -> new IllegalStateException(" No conversion rates for conversion of "
															 + from.getClass().getName() + " to " + toClass));
		return conversionRate;
	}

}
