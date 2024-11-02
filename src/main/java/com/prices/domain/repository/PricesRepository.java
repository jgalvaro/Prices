package com.prices.domain.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.prices.domain.model.Prices;

public interface PricesRepository {

    Prices findApplicablePrice(LocalDateTime applicationDate, Integer productId, Integer brandId);

    void saveAll(List<Prices> prices);
}
