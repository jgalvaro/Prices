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
class PricesJPAAdapterTest {

    @Autowired
    private PricesJPARepository pricesJPARepository;

    @Autowired
    private PricesJPAAdapter pricesJPAAdapter;

    @Test
    void shouldSaveAndFindPrice() {
        LocalDateTime startDate = LocalDateTime.of(2024, 10, 17, 19, 0);
        LocalDateTime endDate = LocalDateTime.of(2024, 10, 17, 19, 0);

        // Crear un objeto Prices con los valores de prueba
        Prices price = new Prices(1,1,startDate,endDate,1,1001,50.75,"EUR");
        pricesJPARepository.save(price);

        // Guardar el objeto Prices en el repositorio
        pricesJPARepository.save(price);

        // Recuperar el objeto Prices usando su ID
        Prices found = pricesJPARepository.findById(price.getId()).orElse(null);

        // Verificar que el objeto recuperado no es nulo
        assertNotNull(found, "El precio encontrado no debe ser nulo");

        // Verificar que los valores coinciden con los que se guardaron
        assertEquals(price.getProductId(), found.getProductId(), "El product_id debe coincidir");
        assertEquals(price.getBrandId(), found.getBrandId(), "El brand_id debe coincidir");
        assertEquals(price.getPriceList(), found.getPriceList(), "El price_list debe coincidir");
        assertEquals(startDate, found.getStartDate(), "La fecha de inicio debe coincidir");
        assertEquals(endDate, found.getEndDate(), "La fecha de fin debe coincidir");
        assertEquals(50.75, found.getPrice(), "El precio debe coincidir");
        assertEquals("EUR", found.getCurr(), "La moneda debe coincidir");
    }

    @Test
    void shouldFindApplicablePrice() {
        //Definimos fecha de aplicación para hacer la consulta, de inicio y de fin de precio.
        LocalDateTime applicationDate = LocalDateTime.of(2024, 10, 17, 19, 0);
        LocalDateTime startDate = LocalDateTime.of(2024, 10, 17, 19, 0);
        LocalDateTime endDate = LocalDateTime.of(2024, 10, 17, 19, 0);

        // Crear un objeto Prices con los valores de prueba
        Prices price = new Prices(1,1,startDate,endDate,1,1001,50.75,"EUR");
        // Guardar el objeto Prices en el repositorio
        pricesJPARepository.save(price);

        // Buscar el precio aplicable
        Prices found = pricesJPAAdapter.findApplicablePrice(applicationDate, 1, 1);

        // Verificar que el objeto encontrado no sea nulo
        assertNotNull(found, "El precio encontrado no debe ser nulo");

        // Verificar que los valores coinciden con los que se guardaron
        assertEquals(price.getProductId(), found.getProductId(), "El product_id debe coincidir");
        assertEquals(price.getBrandId(), found.getBrandId(), "El brand_id debe coincidir");
        assertEquals(price.getPriceList(), found.getPriceList(), "El price_list debe coincidir");
        assertEquals(startDate, found.getStartDate(), "La fecha de inicio debe coincidir");
        assertEquals(endDate, found.getEndDate(), "La fecha de fin debe coincidir");
        assertEquals(50.75, found.getPrice(), "El precio debe coincidir");
        assertEquals("EUR", found.getCurr(), "La moneda debe coincidir");
    }
}
