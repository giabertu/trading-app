
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;



public class RefreshService {

    private final Map<StockWrapper, Boolean> stocksToRefresh;

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    private static final Duration refreshPeriod = Duration.ofSeconds(15);
    public RefreshService(){
        stocksToRefresh = new HashMap<>();  
        setRefresh15Minutes();
    }
    private void setRefresh15Minutes(){

        scheduler.scheduleAtFixedRate(() ->
            stocksToRefresh.forEach((stock, value) -> {

                if (stock.getLastAccessed().isBefore(LocalDateTime.now().minus(refreshPeriod))){
                    System.out.println("Setting should refresh " + stock.getStock().getSymbol());
                    stocksToRefresh.remove(stock);
                    //stocksToRefresh.put(stock.withLastAccessed(LocalDateTime.now()), true);
                }
            }), 0, 15, TimeUnit.SECONDS);
    }

    public boolean shoulRefresh(final StockWrapper stock){

        if (!stocksToRefresh.containsKey(stock)){
            stocksToRefresh.put(stock, true);
            return false;
        }
        return stocksToRefresh.get(stock);
    }
}
