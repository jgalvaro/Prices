package com.prices.application.services;

import com.prices.domain.Prices;
import com.prices.application.repository.PricesRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Arrays;

@Service
public class PricesService {

    private final PricesRepository pricesRepository;

    public PricesService(PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

    public Prices findApplicablePrice(LocalDateTime application_date, Integer product_id, Integer brand_id) {
        return pricesRepository.findApplicablePrice(application_date,product_id,brand_id);
    }

    @PostConstruct
    public void initDatabase() {
        Prices price1 = new Prices(1, 1, LocalDateTime.parse("2020-06-14T00:00:00"),
                LocalDateTime.parse("2020-12-31T23:59:59"), 35455, 0, 35.50, "EUR");
        Prices price2 = new Prices(1, 1, LocalDateTime.parse("2020-06-14T15:00:00"),
                LocalDateTime.parse("2020-06-14T18:30:00"), 35455, 1, 25.45, "EUR");
        Prices price3 = new Prices(1, 1, LocalDateTime.parse("2020-06-15T00:00:00"),
                LocalDateTime.parse("2020-06-15T11:00:00"), 35455, 1, 30.50, "EUR");
        Prices price4 = new Prices(1, 1, LocalDateTime.parse("2020-06-15T16:00:00"),
                LocalDateTime.parse("2020-12-31T23:59:59"), 35455, 1, 38.95, "EUR");

        pricesRepository.saveAll(Arrays.asList(price1, price2, price3, price4));
    }
}
