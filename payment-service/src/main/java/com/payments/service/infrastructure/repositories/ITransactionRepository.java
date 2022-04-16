package com.payments.service.infrastructure.repositories;
import com.payments.service.Domain.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction, Integer> {
}
