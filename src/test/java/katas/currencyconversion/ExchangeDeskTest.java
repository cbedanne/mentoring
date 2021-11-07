package katas.currencyconversion;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExchangeDeskTest <F extends WorldCurrency, T extends WorldCurrency>{

	@ParameterizedTest(name="{index} - {0}")
	@MethodSource("getConversionTestCases")
	public  void testConverter (ConversionTestCase<F,T> conversionTestCase)  {

		ExchangeDesk<F,T>  exchangeDesk= new ExchangeDesk<>();

		exchangeDesk.addRate(conversionTestCase.convertFrom, conversionTestCase.convertTo, conversionTestCase.conversionRate);

		F currencyToConvert= getCurrencyToConvertFrom(conversionTestCase);

		T convertedCurrency = exchangeDesk.convert(currencyToConvert, conversionTestCase.convertTo);

		assertThat(convertedCurrency.value).isEqualTo(conversionTestCase.expectedResult);
	}

	private F getCurrencyToConvertFrom(ConversionTestCase<F, T> conversionTestCase) {
		F currencyToConvert =null;
		try {
			currencyToConvert = conversionTestCase.convertFrom.newInstance();
			currencyToConvert.setValue(conversionTestCase.amountToConvert);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return currencyToConvert;
	}

	private static Stream getConversionTestCases(){
		return Stream.of(new ConversionTestCase<>(INR.class,USD.class,1000D,2D,2000D),
						 new ConversionTestCase<>(EUR.class,USD.class,1000D,3D,3000D),
						 new ConversionTestCase<>(EUR.class,INR.class,2000D,0.5,1000D),
						 new ConversionTestCase<>(GBP.class,EUR.class,2000D,0.25,500D)
						 );
	}

	private static class ConversionTestCase <F extends WorldCurrency, T extends WorldCurrency>{
		Class<F> convertFrom;
		Class<T> convertTo;
		Double amountToConvert;
		Double conversionRate;
		Double expectedResult;

		public ConversionTestCase(Class<F> convertFromClass, Class<T> convertToClass,Double amountToConvert, Double conversionRate, Double expectedResult) {
			this.convertFrom = convertFromClass;
			this.convertTo = convertToClass;
			this.amountToConvert=amountToConvert;
			this.conversionRate = conversionRate;
			this.expectedResult = expectedResult;
		}

		@Override
		public String toString(){
			return ("Conversion of " +  this.amountToConvert  + " " + this.convertFrom.getSimpleName()  + " to " + this.convertTo.getSimpleName() + " with conversion rate of " + this.conversionRate);
		}

	}

}