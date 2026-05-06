package com.roger.crypto.modelTest;

import com.roger.crypto.model.Candlestick;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CandlestickTest {

    @Test
    public void test_SetVolume(){
        Candlestick c = new Candlestick();
        c.setVolume(8.0);
        assertEquals(c.getVolume(), 8.0);
    }


    @Test
    public void Test_load(){
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



        assertEquals(c.getSymbol(),"symbol");
        assertEquals(c.getOpenTime(),1L);
        assertEquals(c.getOpenPrice(),2.0);
        assertEquals(c.getHighPrice(),3.0);
        assertEquals(c.getLowPrice(),4.0);
        assertEquals(c.getClosePrice(),4.0);
        assertEquals(c.getVolume(),4.0);
        assertEquals(c.getCloseTime(),4L);
        assertEquals(c.getQuoteAssetVolume(),4.0);
        assertEquals(c.getNumberOfTrades(),4L);
        assertEquals(c.getTakerBuyBaseAssetVolume(),5.0);
        assertEquals(c.getTakerBuyQuoteAssetVolume(),5.0);


    }
}
