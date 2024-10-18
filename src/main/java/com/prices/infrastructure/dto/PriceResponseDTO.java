package com.prices.infrastructure.dto;

import java.time.LocalDateTime;

public class PriceResponseDTO {
    private Integer product_id;
    private Integer brand_id;
    private Integer price_list;
    private LocalDateTime application_date;
    private double price;


    public PriceResponseDTO(Integer product_id, Integer brand_id, Integer price_list, LocalDateTime application_date, double price) {
        this.product_id = product_id;
        this.brand_id = brand_id;
        this.price_list = price_list;
        this.application_date = application_date;
        this.price = price;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Integer brand_id) {
        this.brand_id = brand_id;
    }

    public Integer getPrice_list() {
        return price_list;
    }

    public void setPrice_list(Integer price_list) {
        this.price_list = price_list;
    }

    public LocalDateTime getApplication_date() {
        return application_date;
    }

    public void setApplication_date(LocalDateTime application_date) {
        this.application_date = application_date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
