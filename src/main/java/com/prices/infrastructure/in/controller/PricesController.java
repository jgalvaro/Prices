package com.prices.infrastructure.in.controller;

import com.prices.application.services.PricesService;
import com.prices.domain.model.Prices;
import com.prices.infrastructure.dto.PriceResponseDTO;
import com.prices.infrastructure.in.exception.exceptions.PriceNotFoundException;
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

    private final PricesService pricesService;

    public PricesController(PricesService pricesService) {
        this.pricesService = pricesService;
    }

    @GetMapping("/getPrices")
    public ResponseEntity<PriceResponseDTO> getPrices(@RequestParam("application_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate,
                                    @RequestParam("product_id")Integer productId,
                                    @RequestParam("brand_id")Integer brandId){
        Prices price = this.pricesService.findApplicablePrice(applicationDate,productId,brandId);
        if (price == null) {
            throw new PriceNotFoundException("Precio no encontrado para la fecha: " + applicationDate);
        }
        PriceResponseDTO responseDTO = new PriceResponseDTO(price.getProductId(), price.getBrandId(),
                price.getPriceList(), applicationDate, price.getPrice());
        return ResponseEntity.ok(responseDTO);
    }
}