package com.example.objectmapper;

import com.example.objectmapper.controllers.MessageController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = MessageController.class)
public class MessageControllerTest {


    @TestConfiguration
    public class Config {

        @Bean
        public SecurityConfig security() {
            return new SecurityConfig();
        }
    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHello() throws Exception {
        mockMvc.perform(get("/hello/aman/kumar")
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().json("{}", false));
    }


}
