package com.roger.crypto.service;

import com.roger.crypto.model.Candlestick;
import com.roger.crypto.repository.CandlestickMyBatisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.LongStream;


@Service
public class CandlestickService {


    @Autowired
    private CandlestickMyBatisRepository candleRepository;

    @Autowired
    private DataSourceService<Candlestick> service;

    @Autowired
    private Refactor factor;

    public void load(String symbol, Long startTime, Long endTime) {
        Integer limit = 500;
        Long limitMs = limit * 60 * 1000L;

        LongStream.range(startTime, endTime - 1)
                .parallel()
                .filter(i -> (i - startTime) % limitMs == 0)
                .forEach(i -> {
                    Long endTimeStamp = ((i + limitMs) > endTime) ? endTime : i + limitMs;
                    List<Candlestick> data = service.getData(symbol, i, endTimeStamp);
                    candleRepository.insertBatch(data);
                });



    }

    public List<Candlestick> get(String symbol, Long startTime, Long endTime, Integer interval) {

        List<Candlestick> data = candleRepository.findData(symbol, startTime, endTime);

        return factor.intervalRefactor(data,interval);

    }


}
/*
    every time is a interval loop
    openTime - the first instance time;
    openPrice - the first instance openPrice;
    High Price - the highest price for a interval
    Low Price - the lowest price for a interval
    ClosePrice - the last instance ClosePrice
    volume - sum of the volume
    CloseTime - the last instance CloseTime
    getQuoteAssetVolume - sum of the getQuoteAssetVolume
    NumberOfTrades - sum of the NumberOfTrades
    getQuoteAssetVolume - sum of the getQuoteAssetVolume
    TakerBuyBaseAssetVolume - sum of the TakerBuyBaseAssetVolume
    TakerBuyQuoteAssetVolume - sum of the TakerBuyQuoteAssetVolume
 */
