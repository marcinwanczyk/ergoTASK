package com.prime.prime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(PrimeController.class)
public class PrimeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PrimeService primeService;

    @Test
    @DisplayName("GET return index view")
    void testGetIndex() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    @DisplayName("GET return index view with primes")
    void testGetIndexWithPrimes() throws Exception {
        int bound = 11;
        List<Integer> mockPrimes = List.of(2, 3, 5, 7, 11);
        when(primeService.checkPrime(bound)).thenReturn(mockPrimes);

        mockMvc.perform(MockMvcRequestBuilders.get("/prime")
                .param("bound", String.valueOf(bound)))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attribute("primeNumbers", mockPrimes))
                .andExpect(model().attribute("bound", bound));
    }
}