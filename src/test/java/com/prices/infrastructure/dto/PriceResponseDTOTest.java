package com.prices.infrastructure.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceResponseDTOTest {

    @Test
    public void testPricesConstructorAndGetters() {
        // Datos de prueba
        Integer brandId = 1;
        Integer productId = 35455;
        LocalDateTime startDate = LocalDateTime.of(2020, 6, 14, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2020, 12, 31, 23, 59);
        Integer priceList = 1;
        double price = 35.50;
        String currency = "EUR";

        // Instancia del objeto Prices

        PriceResponseDTO priceDTO = new PriceResponseDTO(productId, brandId, priceList,endDate,price);

        // Validamos que los getters devuelvan los valores correctos
        assertEquals(brandId, priceDTO.getBrand_id());
        assertEquals(productId, priceDTO.getProduct_id());
        assertEquals(priceList, priceDTO.getPrice_list());
        assertEquals(price, priceDTO.getPrice());
    }

    @Test
    public void testSetters() {
        // Instancia del objeto Prices
        PriceResponseDTO priceDTO = new PriceResponseDTO(1, 1, 1,LocalDateTime.now(),5);

        // Nuevos datos de prueba
        Integer newId = 2;
        Integer newBrandId = 2;
        Integer newProductId = 12345;
        LocalDateTime newApplicationDate = LocalDateTime.of(2021, 6, 30, 23, 59);
        Integer newPriceList = 2;
        Integer priority = 1;
        double newPrice = 50.75;
        String newCurrency = "USD";

        // Cambiamos los valores usando los setters
        priceDTO.setBrand_id(newBrandId);
        priceDTO.setProduct_id(newProductId);
        priceDTO.setPrice_list(newPriceList);
        priceDTO.setPrice(newPrice);
        priceDTO.setApplication_date(newApplicationDate);
        // Validamos que los setters hayan actualizado los valores correctamente
        assertEquals(newBrandId, priceDTO.getBrand_id());
        assertEquals(newProductId, priceDTO.getProduct_id());
        assertEquals(newApplicationDate, priceDTO.getApplication_date());
        assertEquals(newPriceList, priceDTO.getPrice_list());
        assertEquals(newPrice, priceDTO.getPrice());
    }

    @Test
    public void testPriceEquality() {
        // Crear dos instancias con los mismos valores
        PriceResponseDTO priceDTO1 = new PriceResponseDTO(1, 1, 1,LocalDateTime.now(),5);
        PriceResponseDTO priceDTO2 = new PriceResponseDTO(1, 1, 1,LocalDateTime.now(),5);

        // Validamos que ambos objetos sean iguales basándonos en sus atributos
        assertEquals(priceDTO1.getProduct_id(), priceDTO2.getProduct_id());
        assertEquals(priceDTO1.getBrand_id(), priceDTO2.getBrand_id());
        assertEquals(priceDTO1.getPrice(), priceDTO2.getPrice());
        assertEquals(priceDTO1.getApplication_date(), priceDTO2.getApplication_date());
        assertEquals(priceDTO1.getPrice_list(), priceDTO2.getPrice_list());
    }

}
