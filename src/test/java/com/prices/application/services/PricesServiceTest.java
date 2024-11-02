package com.prices.application.services;

import com.prices.domain.repository.PricesRepository;
import com.prices.domain.model.Prices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PricesServiceTest {

    @Mock
    private PricesRepository pricesRepository; // Mock del repositorio

    @InjectMocks
    private PricesService pricesService;

    @Test
    void shouldReturnPriceWhenFound() {
        LocalDateTime applicationDate = LocalDateTime.of(2024, 10, 17, 19, 0);
        Prices price = new Prices(1,1,applicationDate,applicationDate.plusDays(1),1,1001,50.75,"EUR");

        when(pricesRepository.findApplicablePrice(any(), any(), any())).thenReturn(price);

        Prices result = pricesService.findApplicablePrice(applicationDate, 1, 1);

        assertEquals(1, result.getProductId());
        assertEquals(1, result.getBrandId());
        assertEquals(50.75, result.getPrice());
    }

}
