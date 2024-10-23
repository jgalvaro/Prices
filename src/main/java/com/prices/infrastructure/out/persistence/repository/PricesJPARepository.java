package com.prices.infrastructure.out.persistence.repository;

import com.prices.domain.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PricesJPARepository extends JpaRepository<Prices,Integer> {

    @Query("""
            SELECT p FROM Prices p  
            WHERE :applicationDate BETWEEN p.startDate AND p.endDate
            AND p.productId = :productId
            AND p.brandId = :brandId
            ORDER BY p.priority DESC
            LIMIT 1""")
    Prices findApplicablePrice(@Param("applicationDate") LocalDateTime applicationDate,
                                      @Param("productId") Integer productId,
                                      @Param("brandId") Integer brandId);
}
