package control;
import java.io.IOException;
import java.math.BigDecimal;

import model.StockWrapper;
import service.StockService;

public class StockSharePair {

    private StockWrapper stock;
    private BigDecimal sharesOwned;
    private BigDecimal totValue;

    public StockSharePair(StockWrapper stock, BigDecimal sharesOwned) throws IOException{
        this.stock = stock;
        this.sharesOwned = sharesOwned;
        calculateTotValue();
    }
    
    public void calculateTotValue() throws IOException{
        totValue = new StockService().findPrice(this.stock).multiply(sharesOwned);
    }

    public void addShares(double amount) throws IOException{
        sharesOwned = sharesOwned.add(new BigDecimal(amount).divide(stock.getPrice()));
    }

    public BigDecimal getSharesOwned(){
        return sharesOwned;
    }

    public StockWrapper getStock(){
        return stock;
    }

    public BigDecimal getTotValue(){
        return totValue;
    }
}
