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
    public Prices findApplicablePrice(LocalDateTime application_date, Integer product_id, Integer brand_id) {
        return repository.findApplicablePrice(application_date,product_id,brand_id);
    }

}
