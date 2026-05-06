package com.roger.crypto.repository;




import com.roger.crypto.model.Candlestick;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CandlestickMyBatisRepository {
    @Select("select * from kline.candlestick")
    public List<Candlestick> findAll();


    @Insert("INSERT INTO kline.candlestick(symbol, open_time, open_price, high_price, low_price, close_price,volume, close_time, quote_asset_volume, number_of_trades, taker_buy_base_asset_volume,taker_buy_quote_asset_volume) " +
            " VALUES (#{symbol}, #{openTime}, #{openPrice}, #{highPrice}, #{lowPrice}, " +
            "#{closePrice}, #{volume}, #{closeTime}, #{quoteAssetVolume}, #{numberOfTrades}, " +
            "#{takerBuyBaseAssetVolume}, #{takerBuyQuoteAssetVolume}) ")
    public int insert(Candlestick candlestick);


    @Insert({
            "<script>",
            "insert into kline.candlestick(symbol, open_time, open_price, high_price, low_price, " +
                    "close_price,volume, close_time, quote_asset_volume, number_of_trades, " +
                    "taker_buy_base_asset_volume,taker_buy_quote_asset_volume)",
            "values ",
            "<foreach  collection='dmoList' item='dmo' separator=','>",
            "( #{dmo.symbol}, #{dmo.openTime}, #{dmo.openPrice}, #{dmo.highPrice}, #{dmo.lowPrice}," +
                    " #{dmo.closePrice}, #{dmo.volume}, #{dmo.closeTime}, "+"#{dmo.quoteAssetVolume}," +
                    " #{dmo.numberOfTrades}, #{dmo.takerBuyBaseAssetVolume}, #{dmo.takerBuyQuoteAssetVolume})",
            "</foreach>",
            "</script>"
    })
    int insertBatch(@Param("dmoList") List<Candlestick> dmoList);


    @Select("select * from kline.candlestick where symbol = #{symbol} AND open_time between #{startTime}  AND  #{endTime} ")
    List<Candlestick> findData(String symbol, Long startTime, Long endTime);
}
