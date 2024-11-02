package com.prices.domain;

import com.prices.domain.model.Prices;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class PricesTest {

    @Test
    void testPricesConstructorAndGetters() {
        // Datos de prueba
        Integer brandId = 1;
        Integer productId = 35455;
        LocalDateTime startDate = LocalDateTime.of(2020, 6, 14, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2020, 12, 31, 23, 59);
        Integer priceList = 1;
        Integer priority = 1;
        double price = 35.50;
        String currency = "EUR";

        // Instancia del objeto Prices

        Prices prices = new Prices(productId, brandId, startDate, endDate, priceList,priority,price, currency);

        // Validamos que los getters devuelvan los valores correctos
        assertEquals(productId, prices.getProductId());
        assertEquals(brandId, prices.getBrandId());
        assertEquals(startDate, prices.getStartDate());
        assertEquals(endDate, prices.getEndDate());
        assertEquals(priceList, prices.getPriceList());
        assertEquals(priority, prices.getPriority());
        assertEquals(price, prices.getPrice());
        assertEquals(currency, prices.getCurr());
    }

    @Test
    void testSetters() {
        // Instancia del objeto Prices
        Prices prices = new Prices(1, 35455, LocalDateTime.now(), LocalDateTime.now().plusDays(1), 1,1, 35.50, "EUR");

        // Nuevos datos de prueba
        Integer newId = 2;
        Integer newBrandId = 2;
        Integer newProductId = 12345;
        LocalDateTime newStartDate = LocalDateTime.of(2021, 1, 1, 0, 0);
        LocalDateTime newEndDate = LocalDateTime.of(2021, 6, 30, 23, 59);
        Integer newPriceList = 2;
        Integer newPriority = 2;
        double newPrice = 50.75;
        String newCurrency = "USD";

        // Cambiamos los valores usando los setters
        prices.setId(newId);
        prices.setBrandId(newBrandId);
        prices.setProductId(newProductId);
        prices.setStartDate(newStartDate);
        prices.setEndDate(newEndDate);
        prices.setPriceList(newPriceList);
        prices.setPriority(newPriority);
        prices.setPrice(newPrice);
        prices.setCurr(newCurrency);

        // Validamos que los setters hayan actualizado los valores correctamente
        assertEquals(newId, prices.getId());
        assertEquals(newBrandId, prices.getBrandId());
        assertEquals(newProductId, prices.getProductId());
        assertEquals(newStartDate, prices.getStartDate());
        assertEquals(newEndDate, prices.getEndDate());
        assertEquals(newPriceList, prices.getPriceList());
        assertEquals(newPriority, prices.getPriority());
        assertEquals(newPrice, prices.getPrice());
        assertEquals(newCurrency, prices.getCurr());
    }

    @Test
    void testPriceEquality() {
        // Crear dos instancias con los mismos valores
        Prices price1 = new Prices(1, 35455, LocalDateTime.of(2020, 6, 14, 0, 0), LocalDateTime.of(2020, 12, 31, 23, 59), 1,1, 35.50, "EUR");
        Prices price2 = new Prices(1, 35455, LocalDateTime.of(2020, 6, 14, 0, 0), LocalDateTime.of(2020, 12, 31, 23, 59), 1,1, 35.50, "EUR");

        // Validamos que ambos objetos sean iguales basándonos en sus atributos
        assertEquals(price1.getProductId(), price2.getProductId());
        assertEquals(price1.getBrandId(), price2.getBrandId());
        assertEquals(price1.getStartDate(), price2.getStartDate());
        assertEquals(price1.getEndDate(), price2.getEndDate());
        assertEquals(price1.getPriceList(), price2.getPriceList());
        assertEquals(price1.getPriority(), price2.getPriority());
        assertEquals(price1.getPrice(), price2.getPrice());
        assertEquals(price1.getCurr(), price2.getCurr());
    }
}
