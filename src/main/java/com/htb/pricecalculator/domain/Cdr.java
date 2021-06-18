package com.htb.pricecalculator.domain;


public class Cdr {
    private double meterStart;
    private double meterStop;
    private String timestampStart;
    private String timestampStop;

    public double getMeterStart() {
        return meterStart;
    }

    public void setMeterStart(double meterStart) {
        this.meterStart = meterStart;
    }

    public double getMeterStop() {
        return meterStop;
    }

    public void setMeterStop(double meterStop) {
        this.meterStop = meterStop;
    }

    public String getTimestampStart() {
        return timestampStart;
    }

    public void setTimestampStart(String timestampStart) {
        this.timestampStart = timestampStart;
    }

    public String getTimestampStop() {
        return timestampStop;
    }

    public void setTimestampStop(String timestampStop) {
        this.timestampStop = timestampStop;
    }
}
