import java.math.BigDecimal;
import yahoofinance.Stock;
import yahoofinance.quotes.stock.StockDividend;

public class Security extends AssetWrapper {

    private StockDividend dividend;
    
    public Security(Stock stock){
        super(stock);
        this.dividend = stock.getDividend();
    }

    public StockDividend getDividend(){
        return dividend;
    }

}
