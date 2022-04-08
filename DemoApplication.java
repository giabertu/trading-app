
import java.io.IOException;
import java.math.BigDecimal;

import model.StockWrapper;

import service.StockService;

import yahoofinance.YahooFinance;

public class DemoApplication {

	public static void main(String[] args) throws IOException {

		
		StockService stockService = new StockService();
		StockWrapper stock = stockService.findStock("AAPL");
		System.out.println(stock.getStock());
		BigDecimal stockPrice = stockService.findPrice(stock);
		System.out.println(stockPrice);
	}

}
