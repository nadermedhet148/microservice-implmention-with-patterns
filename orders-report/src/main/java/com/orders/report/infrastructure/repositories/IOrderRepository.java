package com.orders.report.infrastructure.repositories;
import com.orders.report.Domain.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer> {
}
