package com.roger.crypto.ServiceTest;


import com.roger.crypto.service.BinanceSourceServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BinanceSourceServiceImplTest {



    @Autowired
    private BinanceSourceServiceImpl service;

    @Test
    public void getData_test(){
        service.getData("BTCUSDT",1523577600000L,1523664000000L);
    }


}
