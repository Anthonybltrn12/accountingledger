package com.yearup.SkillsSprint_accountingledger.Repository;

import com.yearup.SkillsSprint_accountingledger.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Integer> {


}
