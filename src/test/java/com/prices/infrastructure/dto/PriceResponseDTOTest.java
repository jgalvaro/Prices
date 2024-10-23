package com.prices.infrastructure.dto;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceResponseDTOTest {

    @Test
    void testPricesConstructorAndGetters() {
        // Datos de prueba
        Integer brandId = 1;
        Integer productId = 35455;
        LocalDateTime applicationDate = LocalDateTime.of(2020, 12, 31, 23, 59);
        Integer priceList = 1;
        double price = 35.50;

        // Instancia del objeto Prices
        PriceResponseDTO priceDTO = new PriceResponseDTO(productId, brandId, priceList,applicationDate,price);

        // Validamos que los getters devuelvan los valores correctos
        assertEquals(brandId, priceDTO.getBrandId());
        assertEquals(productId, priceDTO.getProductId());
        assertEquals(priceList, priceDTO.getPriceList());
        assertEquals(applicationDate, priceDTO.getApplicationDate());
        assertEquals(price, priceDTO.getPrice());
    }

    @Test
    void testSetters() {
        // Instancia del objeto Prices
        PriceResponseDTO priceDTO = new PriceResponseDTO(1, 1, 1,LocalDateTime.now(),5);

        // Nuevos datos de prueba
        Integer newBrandId = 2;
        Integer newProductId = 12345;
        LocalDateTime newApplicationDate = LocalDateTime.of(2021, 6, 30, 23, 59);
        Integer newPriceList = 2;
        double newPrice = 50.75;

        // Cambiamos los valores usando los setters
        priceDTO.setBrandId(newBrandId);
        priceDTO.setProductId(newProductId);
        priceDTO.setApplicationDate(newApplicationDate);
        priceDTO.setPriceList(newPriceList);
        priceDTO.setPrice(newPrice);
        // Validamos que los setters hayan actualizado los valores correctamente
        assertEquals(newBrandId, priceDTO.getBrandId());
        assertEquals(newProductId, priceDTO.getProductId());
        assertEquals(newApplicationDate, priceDTO.getApplicationDate());
        assertEquals(newPriceList, priceDTO.getPriceList());
        assertEquals(newPrice, priceDTO.getPrice());
    }

    @Test
    void testPriceEquality() {
        // Creamos una fecha igual
        LocalDateTime applicationDate = LocalDateTime.now();
        // Crear dos instancias con los mismos valores
        PriceResponseDTO priceDTO1 = new PriceResponseDTO(1, 1, 1,applicationDate,5);
        PriceResponseDTO priceDTO2 = new PriceResponseDTO(1, 1, 1,applicationDate,5);

        // Validamos que ambos objetos sean iguales basándonos en sus atributos
        assertEquals(priceDTO1.getProductId(), priceDTO2.getProductId());
        assertEquals(priceDTO1.getBrandId(), priceDTO2.getBrandId());
        assertEquals(priceDTO1.getPrice(), priceDTO2.getPrice());
        assertEquals(priceDTO1.getApplicationDate(), priceDTO2.getApplicationDate());
        assertEquals(priceDTO1.getPriceList(), priceDTO2.getPriceList());
    }

}
