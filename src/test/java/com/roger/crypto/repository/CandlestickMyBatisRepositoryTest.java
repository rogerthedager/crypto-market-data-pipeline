package com.roger.crypto.repository;

import com.roger.crypto.model.Candlestick;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CandlestickMyBatisRepositoryTest {

    @Autowired
    private CandlestickMyBatisRepository candleRepository;

    @Test
    public void test_findALL(){
        candleRepository.findAll();
    }

    @Test
    public void test_findBySymbol(){
        candleRepository.findData("BTCUSDT",1526578379999L,1526578619999L);
    }
    
    @Test
    public void test_insert(){
        Candlestick c = new Candlestick();
        c.setSymbol("symbol");
        c.setOpenTime(1L);
        c.setOpenPrice(2.0);
        c.setHighPrice(3.0);
        c.setLowPrice(4.0);
        c.setClosePrice(4.0);
        c.setVolume(4.0);
        c.setCloseTime(4L);
        c.setQuoteAssetVolume(4.0);
        c.setNumberOfTrades(4L);
        c.setTakerBuyBaseAssetVolume(5.0);
        c.setTakerBuyQuoteAssetVolume(5.0);
        candleRepository.insert(c);
    }
}
