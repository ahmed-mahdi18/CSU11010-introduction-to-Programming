public class Commodity extends MyAssets{

    public int totalShares;

    public Commodity(String citi, double v) {
        setSymbol(citi);
    }


    public int getTotalShares() {
        return totalShares;
    }

    public void setTotalShares(int totalShares) {
        this.totalShares = totalShares;
    }

    public double marketVal(){
        return getCurrentPrice() * totalShares;
    }

    public double profit(){
        return marketVal() - getTotalCost();
    }

    public void purchase(int shares, double priceShare){
        totalShares += shares;
        totalCost += shares * priceShare;

    }

    public String toString()
    {
        return symbol +  " (" + totalShares + " shares, $" + totalCost + " total cost)";
    }
}


