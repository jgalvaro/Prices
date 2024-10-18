package com.prices.application.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.prices.domain.Prices;

public interface PricesRepository {

    Prices findApplicablePrice(LocalDateTime date, Integer product_id, Integer brand_id);

    void saveAll(List<Prices> prices);
}
