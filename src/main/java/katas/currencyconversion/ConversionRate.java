package katas.currencyconversion;

public class ConversionRate <CF extends WorldCurrency,CT extends WorldCurrency> {
	Class<CF> convertFrom;
	Class<CT> convertTo;
	Double conversionRate;

	public ConversionRate(Class<CF> from, Class<CT> to, double conversionRate) {
		this.convertFrom = from;
		this.convertTo = to;
		this.conversionRate = conversionRate;
	}
}
