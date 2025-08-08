package com.test.vnpt.repository;

import com.test.vnpt.entity.BankConfigEntity;
import com.test.vnpt.repository.custom.BankConfigRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankConfigRepository extends JpaRepository<BankConfigEntity,Long>, BankConfigRepositoryCustom {
}
