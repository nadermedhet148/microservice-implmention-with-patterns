package com.com.productReports.infrastructure.repositories;
import com.com.productReports.Domain.Models.ProductOrdersCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductOrdersCountRepository extends JpaRepository<ProductOrdersCount, Integer> {
}
