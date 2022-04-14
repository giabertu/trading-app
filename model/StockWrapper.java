package model;

import java.io.IOException;
import java.math.BigDecimal;
import service.StockService;
import yahoofinance.Stock;

public class StockWrapper{
    private final Stock stock;

    public StockWrapper(Stock stock){
        this.stock = stock;
    }

    public Stock getStock(){
        return stock;
    }

    public BigDecimal getPrice() throws IOException{
        return new StockService().findPrice(this);
    }

    public String getName() {
        return stock.getName();
    }
    
}
