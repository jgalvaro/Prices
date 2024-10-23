package com.prices.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class PriceResponseDTO {

    @JsonProperty("product_id")
    private Integer productId;

    @JsonProperty("brand_id")
    private Integer brandId;

    @JsonProperty("price_list")
    private Integer priceList;

    @JsonProperty("application_date")
    private LocalDateTime applicationDate;

    @JsonProperty("price")
    private double price;

    // Constructor con camelCase
    public PriceResponseDTO(Integer productId, Integer brandId, Integer priceList, LocalDateTime applicationDate, double price) {
        this.productId = productId;
        this.brandId = brandId;
        this.priceList = priceList;
        this.applicationDate = applicationDate;
        this.price = price;
    }

    // Getters y Setters en camelCase
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getPriceList() {
        return priceList;
    }

    public void setPriceList(Integer priceList) {
        this.priceList = priceList;
    }

    public LocalDateTime getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDateTime applicationDate) {
        this.applicationDate = applicationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
