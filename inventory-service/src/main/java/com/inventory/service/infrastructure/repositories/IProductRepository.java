package com.inventory.service.infrastructure.repositories;
import com.inventory.service.Domain.models.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findOneByProductId(Integer productId);
}
