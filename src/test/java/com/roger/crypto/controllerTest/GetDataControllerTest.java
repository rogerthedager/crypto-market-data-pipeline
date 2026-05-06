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
public class GetDataControllerTest {

    @Autowired
    private MockMvc mvc;

    @SneakyThrows
    @Test
    public void get_Test(){
        mvc.perform(MockMvcRequestBuilders.get("/load")
                .param("symbol", "BTCUSDT")
                .param("startTime", String.valueOf(1826577600000L))
                .param("endTime", String.valueOf(1826578200000L))
        ).andDo(print()).andExpect(status().isCreated());


    }

}
