
import java.io.IOException;
import java.math.BigDecimal;

import yahoofinance.Stock;

public class Cryptocurrency extends AssetWrapper {

   private BigDecimal exchangeRate;

   public Cryptocurrency(Stock crypto) throws IOException{
        super(crypto);
        exchangeRate = super.getPrice();
   }

   public BigDecimal getExchangeRate() throws IOException{
      exchangeRate = super.getPrice();
      return exchangeRate;
   }

}

