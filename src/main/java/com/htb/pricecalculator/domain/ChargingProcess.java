package com.htb.pricecalculator.domain;

public class ChargingProcess {
    private Rate rate;
    private Cdr cdr;

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public Cdr getCdr() {
        return cdr;
    }

    public void setCdr(Cdr cdr) {
        this.cdr = cdr;
    }
}
