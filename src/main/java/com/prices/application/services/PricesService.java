package com.prices.application.services;

import com.prices.domain.model.Prices;
import com.prices.domain.repository.PricesRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PricesService {

    private final PricesRepository pricesRepository;

    public PricesService(PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

    public Prices findApplicablePrice(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        return pricesRepository.findApplicablePrice(applicationDate,productId,brandId);
    }
}
