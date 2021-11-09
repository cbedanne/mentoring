package katas.lambdas;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import katas.lambdas.Lambdas.FinancialCalculationDelegate;

class LambdasTest {

	@Test
	public void testCreatingADelegate(){
		FinancialCalculationDelegate financialCalculation=new FinancialCalculationDelegate(input->new BigDecimal("6.01"));

		BigDecimal result=new BigDecimal("6010.00");

		assertThat(financialCalculation.computeStockWorth("GOOGLE",1000)).isEqualTo(result);

	}

}