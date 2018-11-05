package com.account.project.accoundetails.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.account.project.accountdetails.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

}
