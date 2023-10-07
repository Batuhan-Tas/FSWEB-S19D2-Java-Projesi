package com.workintech.S19D2.repository;

import com.workintech.S19D2.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
}
