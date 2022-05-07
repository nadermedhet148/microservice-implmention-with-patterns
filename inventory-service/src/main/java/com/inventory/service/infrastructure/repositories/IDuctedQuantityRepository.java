package com.inventory.service.infrastructure.repositories;
import com.inventory.service.Domain.models.DuctedQuantity;
import com.inventory.service.Domain.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDuctedQuantityRepository extends JpaRepository<DuctedQuantity, Integer> {
    Optional<DuctedQuantity> findOneByOrderId(Integer orderId);

}
