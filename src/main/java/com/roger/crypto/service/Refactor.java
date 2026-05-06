package com.roger.crypto.service;

import com.roger.crypto.model.Candlestick;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class Refactor {

//    @Autowired
//    private CandlestickMyBatisRepository candleRepository;

    public List<Candlestick> intervalRefactor(List<Candlestick> data, Integer interval) {

        List<Candlestick> returnData = new ArrayList<>();


        int size = data.size() - 1;

        for (int j = 0; j < data.size(); j += interval) {
            Double volume = 0.0;
            Double quoteAssetVolume = 0.0;
            Long trade = 0L;
            Double takerBuyBaseAssetVolume= 0.0;
            Double takerBuyQuoteAssetVolume= 0.0;
            int end = Math.min(j + interval, size);;
            Double max = Double.MIN_VALUE;
            Double min = Double.MAX_VALUE;

            Candlestick combined = new Candlestick();
            Candlestick head = data.get(j);
            combined.setSymbol(head.getSymbol());
            combined.setOpenTime(head.getOpenTime());
            combined.setOpenPrice(head.getOpenPrice());

            for (int i = j; i < end  ; i++) {
                Candlestick body = data.get(i);
                max = Math.max(max, body.getHighPrice());

                min = Math.min(min, body.getLowPrice());

                volume += body.getVolume();

                quoteAssetVolume += body.getQuoteAssetVolume();

                trade += body.getNumberOfTrades();

                takerBuyBaseAssetVolume += body.getTakerBuyBaseAssetVolume();

                takerBuyQuoteAssetVolume += body.getTakerBuyQuoteAssetVolume();

            }
            combined.setHighPrice(max);
            combined.setLowPrice(min);
            combined.setClosePrice(data.get(end).getClosePrice());
            combined.setVolume(volume);
            combined.setCloseTime(data.get(end).getCloseTime());
            combined.setQuoteAssetVolume(quoteAssetVolume);
            combined.setNumberOfTrades(trade);
            combined.setTakerBuyBaseAssetVolume(takerBuyBaseAssetVolume);
            combined.setTakerBuyQuoteAssetVolume(takerBuyQuoteAssetVolume);

            returnData.add(combined);

        }


        return returnData;
    }
}
