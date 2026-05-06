package com.roger.crypto.controllerTest;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class CandlestickControllerTest {


    @Autowired
    private MockMvc mvc;

    @SneakyThrows
    @Test
    public void get_Test(){
        mvc.perform(MockMvcRequestBuilders.get("/get")
                .param("symbol", "BTCUSDT")
                .param("startTime", String.valueOf(1526577600000L))
                .param("endTime", String.valueOf(1526578200000L))
                .param("interval",String.valueOf(2))
        ).andDo(print()).andExpect(status().isCreated());


    }
}
