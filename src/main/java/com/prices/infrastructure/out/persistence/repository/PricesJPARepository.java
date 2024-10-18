package com.prices.infrastructure.out.persistence.repository;

import com.prices.domain.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PricesJPARepository extends JpaRepository<Prices,Integer> {

    @Query("SELECT p FROM Prices p \n" +
            "WHERE :application_date BETWEEN p.start_date AND p.end_date \n" +
            "AND p.product_id = :product_id \n" +
            "AND p.brand_id = :brand_id \n" +
            "ORDER BY p.priority DESC \n" +
            "LIMIT 1")
    Prices findApplicablePrice(@Param("application_date") LocalDateTime application_date,
                                      @Param("product_id") Integer productId,
                                      @Param("brand_id") Integer brandId);

}
