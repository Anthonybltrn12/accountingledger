package com.yearup.SkillsSprint_accountingledger.Repository;

import com.yearup.SkillsSprint_accountingledger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
