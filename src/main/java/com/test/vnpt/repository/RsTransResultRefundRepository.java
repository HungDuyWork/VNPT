package com.test.vnpt.repository;

import com.test.vnpt.entity.RsTransResultEntity;
import com.test.vnpt.repository.custom.RsTransResultRefundRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RsTransResultRefundRepository extends JpaRepository<RsTransResultEntity, Long>, RsTransResultRefundRepositoryCustom {

}
