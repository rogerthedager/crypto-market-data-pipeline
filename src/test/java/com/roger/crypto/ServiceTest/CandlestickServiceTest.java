package com.roger.crypto.ServiceTest;

import com.roger.crypto.service.CandlestickService;
import com.roger.crypto.service.DataSourceService;
import com.roger.crypto.service.Refactor;
import com.roger.crypto.model.Candlestick;
import com.roger.crypto.repository.CandlestickMyBatisRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@ExtendWith(MockitoExtension.class)
public class CandlestickServiceTest {


    @Mock
    private CandlestickMyBatisRepository candleRepository;

    @Mock
    private Refactor refactor;

    @Autowired
    private DataSourceService<Candlestick> dataSourceService;
    @InjectMocks
    private CandlestickService service;

    @Test
    public void test_load(){
        service.load("BTCUSDT",1523577600000L,1523664000000L);
    }

    @Test
    public void test_get(){
        List<Candlestick> testC =  service.get("BTCUSDT",1523577600000L,1523664000000L,4);
        Mockito.verify(refactor).intervalRefactor(testC,4);
    }
}
//40be833c10a5401597780eb154ab2561