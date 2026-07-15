package com.yearup.SkillsSprint_accountingledger.Repository;


import com.yearup.SkillsSprint_accountingledger.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
