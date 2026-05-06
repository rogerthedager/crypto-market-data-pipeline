package com.roger.crypto.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Candlestick {
    private String symbol;

    private Long openTime;

    private Double openPrice;

    private Double highPrice;

    private Double lowPrice;

    private Double closePrice;

    private Double volume;

    private Long closeTime;

    private Double quoteAssetVolume;

    private Long numberOfTrades;

    private Double takerBuyBaseAssetVolume;

    private Double takerBuyQuoteAssetVolume;
}
