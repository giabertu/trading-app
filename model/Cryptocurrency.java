package model;

public abstract class Cryptocurrency extends Asset {

    private final String name;
    private final double exchangeRate;

    public Cryptocurrency(String name, double exchangeRate){
        super("Intangible");
        this.name = name;
        this.exchangeRate = exchangeRate;
    }

    public String getName(){
        return name;
    }

    public double getExchangeRate(){
        return exchangeRate;
    }
}

