
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
public class AssetSharePair {

    private AssetWrapper asset;
    private BigDecimal sharesOwned;
    private BigDecimal totValue;

    public AssetSharePair(AssetWrapper asset, BigDecimal sharesOwned) throws IOException{
        this.asset = asset;
        this.sharesOwned = sharesOwned;
        calculateTotValue();
    }
    
    public void calculateTotValue() throws IOException{
        totValue = new AssetService().findPrice(this.asset).multiply(sharesOwned);
    }

    public void addShares(double amount) throws IOException{
        sharesOwned = sharesOwned.add(new BigDecimal(amount).divide(asset.getPrice(), 2, RoundingMode.HALF_UP));
        calculateTotValue();
    }

    public void removeShares(double amount) throws IOException{
        BigDecimal newTotValue = totValue.subtract(new BigDecimal(amount));
        BigDecimal newSharesOwned = newTotValue.divide(asset.getPrice(), 2, RoundingMode.HALF_UP);
        sharesOwned = newSharesOwned;
        calculateTotValue();
    }

    public BigDecimal getSharesOwned(){
        return sharesOwned;
    }

    public AssetWrapper getAsset(){
        return asset;
    }

    public BigDecimal getTotValue(){
        return totValue;
    }

    public boolean equals(Object obj){
        if (obj instanceof AssetSharePair){
            AssetSharePair stockGiven = (AssetSharePair) obj;
            if (stockGiven.getAsset().getName().equals(this.asset.getName()))
                return true;
        }
        return false;
    }
    
    public String toString(){
        return "" + asset.getName() + ", " + sharesOwned + " shares";
    }
}
