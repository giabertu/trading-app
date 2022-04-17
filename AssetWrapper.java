import java.io.IOException;
import java.math.BigDecimal;

import yahoofinance.Stock;

public class AssetWrapper{
    private final Stock asset;

    public AssetWrapper(Stock asset){
        this.asset = asset;
    }

    public Stock getAsset(){
        return asset;
    }

    public BigDecimal getPrice() throws IOException{
        return new AssetService().findPrice(this);
    }

    public String getName() {
        return asset.getName();
    }
    
}
