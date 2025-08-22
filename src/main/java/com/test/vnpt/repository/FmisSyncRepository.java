package com.test.vnpt.repository;

import com.test.vnpt.entity.FmisSyncEntity;
import com.test.vnpt.repository.custom.FmisSyncRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FmisSyncRepository extends JpaRepository<FmisSyncEntity, Long>, FmisSyncRepositoryCustom {
}
