package com.prices.infrastructure.out.persistence;

import com.prices.domain.Prices;
import com.prices.infrastructure.out.persistence.adapters.PricesJPAAdapter;
import com.prices.infrastructure.out.persistence.repository.PricesJPARepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:application-test.properties")
public class PricesJPAAdapterTest {

    @Autowired
    private PricesJPARepository pricesJPARepository;

    @Autowired
    private PricesJPAAdapter pricesJPAAdapter;

    @Test
    public void shouldSaveAndFindPrice() {
        LocalDateTime applicationDate = LocalDateTime.of(2024, 10, 17, 19, 0);
        Prices price = new Prices(1,1,applicationDate,applicationDate.plusDays(1),1,1001,50.75,"EUR");
        pricesJPARepository.save(price);

        Prices found = pricesJPARepository.findById(price.getId()).orElse(null);
        assertNotNull(found);
        assertEquals(50.75, found.getPrice());
    }

    @Test
    public void shouldFindApplicablePrice() {
        LocalDateTime applicationDate = LocalDateTime.of(2024, 10, 17, 19, 0);
        Prices price = new Prices(1,1,applicationDate,applicationDate.plusDays(1),1,1001,50.75,"EUR");
        pricesJPARepository.save(price);

        Prices found = pricesJPAAdapter.findApplicablePrice(applicationDate,1,1);
        assertNotNull(found);
        assertEquals(50.75, found.getPrice());
    }
}
