package com.roger.crypto.ServiceTest;


import com.roger.crypto.service.Refactor;
import com.roger.crypto.model.Candlestick;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class RefactorTest {

    @InjectMocks
    private Refactor refactor;



    @Test
    public void refactor_test(){



        List<Candlestick> data = new ArrayList<>();
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

        data.add(c);

        Candlestick d = new Candlestick();
        d.setSymbol("symbol");
        d.setOpenTime(1L);
        d.setOpenPrice(2.0);
        d.setHighPrice(3.0);
        d.setLowPrice(4.0);
        d.setClosePrice(4.0);
        d.setVolume(4.0);
        d.setCloseTime(4L);
        d.setQuoteAssetVolume(4.0);
        d.setNumberOfTrades(4L);
        d.setTakerBuyBaseAssetVolume(5.0);
        d.setTakerBuyQuoteAssetVolume(5.0);

        data.add(d);

        Candlestick e = new Candlestick();
        e.setSymbol("symbol");
        e.setOpenTime(1L);
        e.setOpenPrice(2.0);
        e.setHighPrice(3.0);
        e.setLowPrice(4.0);
        e.setClosePrice(4.0);
        e.setVolume(4.0);
        e.setCloseTime(4L);
        e.setQuoteAssetVolume(4.0);
        e.setNumberOfTrades(4L);
        e.setTakerBuyBaseAssetVolume(5.0);
        e.setTakerBuyQuoteAssetVolume(5.0);

        data.add(e);

        Candlestick f = new Candlestick();
        f.setSymbol("symbol");
        f.setOpenTime(1L);
        f.setOpenPrice(2.0);
        f.setHighPrice(3.0);
        f.setLowPrice(4.0);
        f.setClosePrice(4.0);
        f.setVolume(4.0);
        f.setCloseTime(4L);
        f.setQuoteAssetVolume(4.0);
        f.setNumberOfTrades(4L);
        f.setTakerBuyBaseAssetVolume(5.0);
        f.setTakerBuyQuoteAssetVolume(5.0);

        data.add(f);


        Candlestick g = new Candlestick();
        g.setSymbol("symbol");
        g.setOpenTime(1L);
        g.setOpenPrice(2.0);
        g.setHighPrice(3.0);
        g.setLowPrice(4.0);
        g.setClosePrice(4.0);
        g.setVolume(12.0);
        g.setCloseTime(4L);
        g.setQuoteAssetVolume(12.0);
        g.setNumberOfTrades(12L);
        g.setTakerBuyBaseAssetVolume(15.0);
        g.setTakerBuyQuoteAssetVolume(15.0);
        List<Candlestick> data1 = new ArrayList<>();
        data1.add(g);

        data = refactor.intervalRefactor(data,4);
        data.get(0);
        Assertions.assertEquals(data.get(0),g);
    }
}
