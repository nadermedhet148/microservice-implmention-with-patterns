package com.ay.testlab.kafka.infrastructure.repositories;
import com.ay.testlab.kafka.Domain.Models.ProductOrdersCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductOrdersCountRepository extends JpaRepository<ProductOrdersCount, Integer> {
}
