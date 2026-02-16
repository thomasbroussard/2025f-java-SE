package fr.epita.bank.datamodel;



public class Stock {
    private String ticker;
    private Double price;

    public Stock() {
    }

    public Stock(String ticker, Double price) {
        this.ticker = ticker;
        this.price = price;
    }

    public String getTicker() {
        return this.ticker;
    }

    public void setTicker(String ticker) {
        if (ticker != null) {
            this.ticker = ticker;
        }
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
