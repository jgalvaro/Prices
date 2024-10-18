package com.prices.domain;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class PricesTest {

    @Test
    public void testPricesConstructorAndGetters() {
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
        assertEquals(brandId, prices.getBrand_id());
        assertEquals(productId, prices.getProduct_id());
        assertEquals(startDate, prices.getStart_date());
        assertEquals(endDate, prices.getEnd_date());
        assertEquals(priceList, prices.getPrice_list());
        assertEquals(price, prices.getPrice());
        assertEquals(currency, prices.getCurr());
    }

    @Test
    public void testSetters() {
        // Instancia del objeto Prices
        Prices prices = new Prices(1, 35455, LocalDateTime.now(), LocalDateTime.now().plusDays(1), 1,1, 35.50, "EUR");

        // Nuevos datos de prueba
        Integer newId = 2;
        Integer newBrandId = 2;
        Integer newProductId = 12345;
        LocalDateTime newStartDate = LocalDateTime.of(2021, 1, 1, 0, 0);
        LocalDateTime newEndDate = LocalDateTime.of(2021, 6, 30, 23, 59);
        Integer newPriceList = 2;
        Integer priority = 1;
        double newPrice = 50.75;
        String newCurrency = "USD";

        // Cambiamos los valores usando los setters
        prices.setId(newId);
        prices.setBrand_id(newBrandId);
        prices.setProduct_id(newProductId);
        prices.setStart_date(newStartDate);
        prices.setEnd_date(newEndDate);
        prices.setPrice_list(newPriceList);
        prices.setPrice(newPrice);
        prices.setCurr(newCurrency);
        prices.setPriority(priority);

        // Validamos que los setters hayan actualizado los valores correctamente
        assertEquals(newBrandId, prices.getBrand_id());
        assertEquals(newProductId, prices.getProduct_id());
        assertEquals(newStartDate, prices.getStart_date());
        assertEquals(newEndDate, prices.getEnd_date());
        assertEquals(newPriceList, prices.getPrice_list());
        assertEquals(newPrice, prices.getPrice());
        assertEquals(newCurrency, prices.getCurr());
    }

    @Test
    public void testPriceEquality() {
        // Crear dos instancias con los mismos valores
        Prices price1 = new Prices(1, 35455, LocalDateTime.of(2020, 6, 14, 0, 0), LocalDateTime.of(2020, 12, 31, 23, 59), 1,1, 35.50, "EUR");
        Prices price2 = new Prices(1, 35455, LocalDateTime.of(2020, 6, 14, 0, 0), LocalDateTime.of(2020, 12, 31, 23, 59), 1,1, 35.50, "EUR");

        // Validamos que ambos objetos sean iguales basándonos en sus atributos
        assertEquals(price1.getProduct_id(), price2.getProduct_id());
        assertEquals(price1.getBrand_id(), price2.getBrand_id());
        assertEquals(price1.getPrice(), price2.getPrice());
        assertEquals(price1.getCurr(), price2.getCurr());
        assertEquals(price1.getPriority(), price2.getPriority());
        assertEquals(price1.getStart_date(), price2.getStart_date());
        assertEquals(price1.getEnd_date(), price2.getEnd_date());
    }
}
