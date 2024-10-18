package com.prices.infrastructure.in.controller;

import com.prices.application.services.PricesService;
import com.prices.domain.Prices;
import com.prices.infrastructure.dto.PriceResponseDTO;
import com.prices.infrastructure.in.exception.exceptions.PriceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/prices")
public class PricesController{

    @Autowired
    private final PricesService pricesService;

    public PricesController(PricesService pricesService) {
        this.pricesService = pricesService;
    }

    @GetMapping("/getPrices")
    public ResponseEntity getPrices(@RequestParam("application_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime application_date,
                                    @RequestParam("product_id")Integer product_id,
                                    @RequestParam("brand_id")Integer brand_id){
        Prices price = this.pricesService.findApplicablePrice(application_date,product_id,brand_id);
        if (price == null) {
            throw new PriceNotFoundException("Precio no encontrado para la fecha: " + application_date);
        }
        PriceResponseDTO responseDTO = new PriceResponseDTO(price.getProduct_id(), price.getBrand_id(),
                price.getPrice_list(), application_date, price.getPrice());
        return ResponseEntity.ok(responseDTO);
    }

}