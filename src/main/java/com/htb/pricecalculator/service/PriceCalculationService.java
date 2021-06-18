package com.htb.pricecalculator.service;

import com.htb.pricecalculator.domain.*;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Date;

@Service
public class PriceCalculationService {
    public Price calculatePrice(ChargingProcess chargingProcess) {
        Rate rate = chargingProcess.getRate();
        Cdr cdr = chargingProcess.getCdr();
        Date startTime = Date.from(ZonedDateTime.parse(cdr.getTimestampStart()).toInstant());
        Date stopTime = Date.from(ZonedDateTime.parse(cdr.getTimestampStop()).toInstant());
        double priceForTime = calculatePriceForTime(rate.getTime(), calculateTimeDiffInHours(startTime, stopTime));
        double priceForEnergy = calculatePriceForEnergy(rate.getEnergy(), (cdr.getMeterStop() - cdr.getMeterStart()) / 1000);
        return createPrice(priceForEnergy, priceForTime, rate.getTransaction());
    }

    private double calculateTimeDiffInHours(Date startTime, Date stopTime) {
        return (double) (stopTime.getTime() - startTime.getTime()) / 3600000;
    }

    private double calculatePriceForTime(double ratePerHour, double duration) {
        double priceForTime = ratePerHour * duration;
        return (double) Math.round(priceForTime * 1000) / 1000;
    }

    private double calculatePriceForEnergy(double energyRate, double consumedEnergy) {
        double priceForEnergy = energyRate * consumedEnergy;
        return (double) Math.round(priceForEnergy * 1000) / 1000;
    }

    private Price createPrice(double priceForEnergy, double priceForTime, int transactionFee) {
        PriceComponents priceComponents = new PriceComponents(priceForEnergy, priceForTime, transactionFee);
        double overallPrice = Math.round((priceForEnergy + priceForTime + transactionFee) * 100.0) / 100.0;
        return new Price(overallPrice, priceComponents);
    }
}
