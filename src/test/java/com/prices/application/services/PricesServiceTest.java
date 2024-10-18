package com.prices.application.services;

import com.prices.application.repository.PricesRepository;
import com.prices.domain.Prices;
import com.prices.infrastructure.out.persistence.repository.PricesJPARepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PricesServiceTest {

    @Mock
    private PricesRepository pricesRepository; // Mock del repositorio

    @InjectMocks
    private PricesService pricesService;

    @Test
    public void shouldReturnPriceWhenFound() {
        LocalDateTime applicationDate = LocalDateTime.of(2024, 10, 17, 19, 0);
        Prices price = new Prices(1,1,applicationDate,applicationDate.plusDays(1),1,1001,50.75,"EUR");

        when(pricesRepository.findApplicablePrice(any(), any(), any())).thenReturn(price);

        Prices result = pricesService.findApplicablePrice(applicationDate, 1, 1);

        assertEquals(1, result.getProduct_id());
        assertEquals(1, result.getBrand_id());
        assertEquals(50.75, result.getPrice());
    }

    @Test
    public void shouldInitDatabase() {
        pricesService.initDatabase();
    }
}
