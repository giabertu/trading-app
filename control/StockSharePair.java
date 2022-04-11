package control;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

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
        sharesOwned = sharesOwned.add(new BigDecimal(amount).divide(stock.getPrice(), 2, RoundingMode.HALF_UP));
        calculateTotValue();
    }

    public void removeShares(double amount) throws IOException{
        BigDecimal newTotValue = totValue.subtract(new BigDecimal(amount));
        BigDecimal newSharesOwned = newTotValue.divide(stock.getPrice(), 2, RoundingMode.HALF_UP);
        sharesOwned = newSharesOwned;
        calculateTotValue();
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
