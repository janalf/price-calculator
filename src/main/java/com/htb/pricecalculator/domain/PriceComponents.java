package com.htb.pricecalculator.domain;

public class PriceComponents {
    private double energy;
    private double time;
    private int transaction;

    public PriceComponents(double energy, double time, int transaction) {
        this.energy = energy;
        this.time = time;
        this.transaction = transaction;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public int getTransaction() {
        return transaction;
    }

    public void setTransaction(int transaction) {
        this.transaction = transaction;
    }
}
