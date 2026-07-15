package com.yearup.SkillsSprint_accountingledger.Repository;

import com.yearup.SkillsSprint_accountingledger.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    List<Transaction> findByCategoryId(Integer categoryId);

}
