package com.roger.crypto.service;

import com.roger.crypto.model.Candlestick;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BinanceSourceServiceImpl implements DataSourceService<Candlestick> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Value("${Klinelink}")
    private String uikLineUrl;

    @Override
    public List<Candlestick> getData(String symbol, Long startTime, Long endTime) {
        String uikLinesUrl = String.format(uikLineUrl, symbol, startTime, endTime, 500);
        logger.info(uikLinesUrl);
        ResponseEntity<String[][]> response = restTemplate.getForEntity(uikLinesUrl, String[][].class);
        String[][] body = response.getBody();
        assert body != null;

        //logger.info(String.valueOf(body.length));

        return Stream.of(body)
                .parallel()
                .map(data -> convert(data, symbol))
                .collect(Collectors.toUnmodifiableList());


    }
    private Candlestick convert(String[] data, String symbol){
        Candlestick stick = new Candlestick();
        stick.setSymbol(symbol);
        stick.setOpenTime(Long.parseLong(data[0]));
        stick.setOpenPrice(Double.parseDouble(data[1]));
        stick.setHighPrice(Double.parseDouble(data[2]));
        stick.setLowPrice(Double.parseDouble(data[3]));
        stick.setClosePrice(Double.parseDouble(data[4]));
        stick.setVolume(Double.parseDouble(data[5]));
        stick.setCloseTime(Long.parseLong(data[6]));
        stick.setQuoteAssetVolume(Double.parseDouble(data[7]));
        stick.setNumberOfTrades(Long.parseLong(data[8]));
        stick.setTakerBuyBaseAssetVolume(Double.parseDouble(data[9]));
        stick.setTakerBuyQuoteAssetVolume(Double.parseDouble(data[10]));
        return stick;
    }



}
