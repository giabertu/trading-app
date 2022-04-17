import java.io.IOException;
import java.math.BigDecimal;

import yahoofinance.YahooFinance;


public class AssetService {
    
    public Cryptocurrency findCrypto(String ticker) throws IOException{
        return new Cryptocurrency(YahooFinance.get(ticker));
        
    }

    public Security findAsset(String ticker) throws IOException{
        return new Security(YahooFinance.get(ticker));
    }

    public BigDecimal findPrice(final AssetWrapper stock) throws IOException{
        return stock.getAsset().getQuote(true).getPrice();
    }

}
