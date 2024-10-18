package com.prices.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PRICES")
public class Prices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "PRODUCT_ID")
    private Integer product_id;

    @Column(name = "BRAND_ID")
    private Integer brand_id;

    @Column(name = "START_DATE")
    private LocalDateTime start_date;

    @Column(name = "END_DATE")
    private LocalDateTime end_date;

    @Column(name = "PRICE_LIST")
    private Integer price_list;

    @Column(name = "PRIORITY")
    private Integer priority;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "CURR", length = 3)
    private String curr;

    public Prices() {
    }

    public Prices(Integer product_id, Integer brand_id, LocalDateTime start_date, LocalDateTime end_date, Integer price_list, Integer priority, double price, String curr) {
        this.product_id = product_id;
        this.brand_id = brand_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.price_list = price_list;
        this.priority = priority;
        this.price = price;
        this.curr = curr;
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getStart_date() {
        return start_date;
    }

    public Integer getBrand_id() {
        return brand_id;
    }

    public LocalDateTime getEnd_date() {
        return end_date;
    }

    public Integer getPrice_list() {
        return price_list;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public double getPrice() {
        return price;
    }

    public Integer getPriority() {
        return priority;
    }

    public String getCurr() {
        return curr;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setStart_date(LocalDateTime start_date) {
        this.start_date = start_date;
    }

    public void setBrand_id(Integer brand_id) {
        this.brand_id = brand_id;
    }

    public void setEnd_date(LocalDateTime end_date) {
        this.end_date = end_date;
    }

    public void setPrice_list(Integer price_list) {
        this.price_list = price_list;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }
}
