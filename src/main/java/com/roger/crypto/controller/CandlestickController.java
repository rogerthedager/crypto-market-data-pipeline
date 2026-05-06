package com.roger.crypto.controller;

import com.roger.crypto.service.CandlestickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CandlestickController {


    @Autowired
    private CandlestickService service;
    @GetMapping("/load")
    public void load(@RequestParam String symbol, @RequestParam Long startTime, @RequestParam Long endTime){
        //service.load("BTCUSDT",1523577600000L,1523664000000L);
        // TODO input validation -> validation service
            service.load(symbol, startTime, endTime);



    }

}
