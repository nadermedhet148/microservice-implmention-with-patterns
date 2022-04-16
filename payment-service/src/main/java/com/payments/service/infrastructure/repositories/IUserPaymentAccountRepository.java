package com.payments.service.infrastructure.repositories;
import com.payments.service.Domain.models.UserPaymentAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserPaymentAccountRepository extends JpaRepository<UserPaymentAccount, Integer> {
}
