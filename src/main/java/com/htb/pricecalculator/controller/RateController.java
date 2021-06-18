package com.htb.pricecalculator.controller;

import com.htb.pricecalculator.domain.ChargingProcess;
import com.htb.pricecalculator.domain.Price;
import com.htb.pricecalculator.service.PriceCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateController {

    @Autowired
    PriceCalculationService priceCalculationService;

    @PostMapping("/rate")
    public ResponseEntity<Price> applyRate(@RequestBody ChargingProcess chargingProcess)
    {
        return new ResponseEntity<>(priceCalculationService.calculatePrice(chargingProcess), HttpStatus.CREATED);
    }

}
