public class Currency implements Portfolio {
    private final double amount;

    public Currency(double currency) {
        this.amount = currency;
    }

    @Override
    public double marketVal() {
        return amount;
    }

    @Override
    public double profit() {
        return 0;
    }

}


