package com.order.service.infrastructure.repositories;
import com.order.service.Domain.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer> {
}
