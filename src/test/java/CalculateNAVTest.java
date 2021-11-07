import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class CalculateNAVTest {

    @Test
    void computeStockWorthTestWithMock() {
        CalculateNAV calc=new CalculateNAV(stockCode->new BigDecimal(100));
        assertThat(calc.computeStockWorth("Goo",50)).isEqualTo(new BigDecimal(5000));
        assertThat(calc.computeStockWorth("Yahoo",20)).isEqualTo(new BigDecimal(2000));

    }
    @Test
    void computeStockWorthTestWithWebService() {
        CalculateNAV calc=new CalculateNAV(YahooFinanceWebService::getPrice);
        assertThat(calc.computeStockWorth("Goo",50)).isEqualTo(new BigDecimal(10000));
        assertThat(calc.computeStockWorth("Yahoo",50)).isEqualTo(new BigDecimal(25000));
    }
}