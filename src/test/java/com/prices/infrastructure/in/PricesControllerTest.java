package com.prices.infrastructure.in;

import com.prices.application.services.PricesService;
import com.prices.domain.Prices;
import com.prices.infrastructure.in.controller.PricesController;
import com.prices.infrastructure.out.persistence.repository.PricesJPARepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;


import java.time.LocalDateTime;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PricesController.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class PricesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EntityManager entityManager;

    @MockBean
    private PricesJPARepository pricesJPARepository;

    @MockBean
    private PricesService pricesService;


    @Test
    public void shouldReturnPricesForValidRequest() throws Exception {
        //doNothing().when(pricesService).initDatabase();

        Prices mockPrice = new Prices(1,1,
                                        LocalDateTime.of(2024, 10, 17, 19, 0),
                                        LocalDateTime.of(2024, 10, 18, 19, 0),
                                1001,1,50.75,"EUR");

        when(pricesService.findApplicablePrice(any(), any(), any())).thenReturn(mockPrice);

        // Realizar la solicitud GET simulada
        mockMvc.perform(get("/prices/getPrices")
                        .param("application_date", "2024-10-17T19:00:00")
                        .param("product_id", "1")
                        .param("brand_id", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(50.75))
                .andExpect(jsonPath("$.product_id").value(1));
    }

    @Test
    public void testGetPrice1() throws Exception {
        // Datos simulados de respuesta
        Prices mockPrice = new Prices(1, 1, LocalDateTime.parse("2020-06-14T00:00:00"),
                LocalDateTime.parse("2020-12-31T23:59:59"), 35455, 0, 35.50, "EUR");

        when(pricesService.findApplicablePrice(any(), any(), any())).thenReturn(mockPrice);

        // Realizar la petición GET simulada
        mockMvc.perform(get("/prices/getPrices")
                        .param("application_date", "2020-06-14T10:00:00")
                        .param("product_id", "1")
                        .param("brand_id", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(35.50))
                .andExpect(jsonPath("$.product_id").value(1))
                .andExpect(jsonPath("$.brand_id").value(1))
                .andExpect(jsonPath("$.price_list").value(35455))
                .andExpect(jsonPath("$.application_date").value("2020-06-14T10:00:00"));
    }

    @Test
    public void testGetPrice2() throws Exception {
        // Datos simulados de respuesta
        Prices mockPrice = new Prices(1, 1, LocalDateTime.parse("2020-06-14T00:00:00"),
                LocalDateTime.parse("2020-12-31T23:59:59"), 35455, 0, 25.45, "EUR");

        when(pricesService.findApplicablePrice(any(), any(), any())).thenReturn(mockPrice);

        // Realizar la petición GET simulada
        mockMvc.perform(get("/prices/getPrices")
                        .param("application_date", "2020-06-14T16:00:00")
                        .param("product_id", "1")
                        .param("brand_id", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(25.45))
                .andExpect(jsonPath("$.product_id").value(1))
                .andExpect(jsonPath("$.brand_id").value(1))
                .andExpect(jsonPath("$.price_list").value(35455))
                .andExpect(jsonPath("$.application_date").value("2020-06-14T16:00:00"));
    }

    @Test
    public void testGetPrice3() throws Exception {
        // Datos simulados de respuesta
        Prices mockPrice = new Prices(1, 1, LocalDateTime.parse("2020-06-14T00:00:00"),
                LocalDateTime.parse("2020-12-31T23:59:59"), 35455, 0, 35.50, "EUR");

        when(pricesService.findApplicablePrice(any(), any(), any())).thenReturn(mockPrice);

        // Realizar la petición GET simulada
        mockMvc.perform(get("/prices/getPrices")
                        .param("application_date", "2020-06-14T21:00:00")
                        .param("product_id", "1")
                        .param("brand_id", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(35.50))
                .andExpect(jsonPath("$.product_id").value(1))
                .andExpect(jsonPath("$.brand_id").value(1))
                .andExpect(jsonPath("$.price_list").value(35455))
                .andExpect(jsonPath("$.application_date").value("2020-06-14T21:00:00"));
    }

    @Test
    public void testGetPrice4() throws Exception {
        // Datos simulados de respuesta
        Prices mockPrice = new Prices(1, 1, LocalDateTime.parse("2020-06-14T00:00:00"),
                LocalDateTime.parse("2020-12-31T23:59:59"), 35455, 0, 30.5, "EUR");

        when(pricesService.findApplicablePrice(any(), any(), any())).thenReturn(mockPrice);

        // Realizar la petición GET simulada
        mockMvc.perform(get("/prices/getPrices")
                        .param("application_date", "2020-06-15T10:00:00")
                        .param("product_id", "1")
                        .param("brand_id", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(30.5))
                .andExpect(jsonPath("$.product_id").value(1))
                .andExpect(jsonPath("$.brand_id").value(1))
                .andExpect(jsonPath("$.price_list").value(35455))
                .andExpect(jsonPath("$.application_date").value("2020-06-15T10:00:00"));
    }

    @Test
    public void testGetPrice5() throws Exception {
        // Datos simulados de respuesta
        Prices mockPrice = new Prices(1, 1, LocalDateTime.parse("2020-06-14T00:00:00"),
                LocalDateTime.parse("2020-12-31T23:59:59"), 35455, 0, 38.95, "EUR");

        when(pricesService.findApplicablePrice(any(), any(), any())).thenReturn(mockPrice);

        // Realizar la petición GET simulada
        mockMvc.perform(get("/prices/getPrices")
                        .param("application_date", "2020-06-16T21:00:00")
                        .param("product_id", "1")
                        .param("brand_id", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(38.95))
                .andExpect(jsonPath("$.product_id").value(1))
                .andExpect(jsonPath("$.brand_id").value(1))
                .andExpect(jsonPath("$.price_list").value(35455))
                .andExpect(jsonPath("$.application_date").value("2020-06-16T21:00:00"));
    }

    @Test
    public void testOtherException() throws Exception {
        // Datos simulados de respuesta
        Prices mockPrice = new Prices(1, 1, LocalDateTime.parse("2020-06-14T00:00:00"),
                LocalDateTime.parse("2020-12-31T23:59:59"), 35455, 0, 38.95, "EUR");

        when(pricesService.findApplicablePrice(any(), any(), any())).thenReturn(null);

        // Realizar la petición GET simulada
        mockMvc.perform(get("/prices/getPrices")
                        .param("application_date", "2020-06-16T21:00:00")
                        .param("product_id", "1")
                        .param("brand_id", "1"))
                .andExpect(status().isNotFound());
    }

    @BeforeEach
    public void setUpDatabase() {
        // Limpiar la base de datos antes de cada test
        pricesJPARepository.deleteAll();

        // Inicializar la base de datos con precios de ejemplo
        Prices price1 = new Prices(1, 1, LocalDateTime.parse("2020-06-14T00:00:00"),
                LocalDateTime.parse("2020-12-31T23:59:59"), 35455, 0, 35.50, "EUR");
        Prices price2 = new Prices(1, 1, LocalDateTime.parse("2020-06-14T15:00:00"),
                LocalDateTime.parse("2020-06-14T18:30:00"), 35455, 1, 25.45, "EUR");
        Prices price3 = new Prices(1, 1, LocalDateTime.parse("2020-06-15T00:00:00"),
                LocalDateTime.parse("2020-06-15T11:00:00"), 35455, 1, 30.50, "EUR");
        Prices price4 = new Prices(1, 1, LocalDateTime.parse("2020-06-15T16:00:00"),
                LocalDateTime.parse("2020-12-31T23:59:59"), 35455, 1, 38.95, "EUR");

        pricesJPARepository.saveAll(Arrays.asList(price1, price2, price3, price4));
    }
}
