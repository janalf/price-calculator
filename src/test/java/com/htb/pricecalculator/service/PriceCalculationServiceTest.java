package com.htb.pricecalculator.service;

import com.htb.pricecalculator.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PriceCalculationServiceTest {
    private final PriceCalculationService priceCalculationService = new PriceCalculationService();
    private ChargingProcess chargingProcess;

    @BeforeEach
    void setUp() {
        chargingProcess = new ChargingProcess();
        Rate rate = new Rate();
        rate.setTime(2);
        rate.setEnergy(0.3);
        rate.setTransaction(1);
        Cdr cdr = new Cdr();
        cdr.setMeterStart(1204307);
        cdr.setMeterStop(1215230);
        cdr.setTimestampStart("2021-04-05T10:04:00Z");
        cdr.setTimestampStop("2021-04-05T11:27:00Z");
        chargingProcess.setCdr(cdr);
        chargingProcess.setRate(rate);
    }

    @Test
    void calculatePrice() {
        PriceComponents expectedPriceComponents = new PriceComponents(3.277, 2.767, 1);
        Price expectedPrice = new Price(7.04, expectedPriceComponents);
        assertEquals(expectedPrice.getOverall(), priceCalculationService.calculatePrice(chargingProcess).getOverall());
    }
}