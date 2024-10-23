package com.prices.infrastructure.out.persistence.adapters;

import com.prices.domain.Prices;
import com.prices.application.repository.PricesRepository;
import com.prices.infrastructure.out.persistence.repository.PricesJPARepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class PricesJPAAdapter implements PricesRepository {

    private final PricesJPARepository repository;

    public PricesJPAAdapter(PricesJPARepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveAll(List<Prices> prices){
        repository.saveAll(prices);
    }

    @Override
    public Prices findApplicablePrice(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        return repository.findApplicablePrice(applicationDate,productId,brandId);
    }

}
