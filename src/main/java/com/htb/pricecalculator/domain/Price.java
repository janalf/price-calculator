package com.htb.pricecalculator.domain;

public class Price {
    private double overall;
    private PriceComponents priceComponents;

    public Price(double overall, PriceComponents priceComponents) {
        this.overall = overall;
        this.priceComponents = priceComponents;
    }

    public double getOverall() {
        return overall;
    }

    public void setOverall(double overall) {
        this.overall = overall;
    }

    public PriceComponents getPriceComponents() {
        return priceComponents;
    }

    public void setPriceComponents(PriceComponents priceComponents) {
        this.priceComponents = priceComponents;
    }
}
