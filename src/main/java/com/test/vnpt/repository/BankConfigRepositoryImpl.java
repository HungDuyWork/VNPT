package com.test.vnpt.repository;

import com.test.vnpt.entity.BankConfigEntity;
import com.test.vnpt.repository.custom.BankConfigRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
@Slf4j
public class BankConfigRepositoryImpl implements BankConfigRepositoryCustom {

    private final EntityManager entityManager;
    @Override
    @Transactional(readOnly = true)
    public List<BankConfigEntity> findAccount(String bankName, String accountNumber, String serviceType, Integer status, Integer page, Integer size) {
        try {
            StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM RS_BANK_CONFIG f WHERE 1 = 1");
            Map<String, Object> params = new HashMap<>();

            if(StringUtils.hasText(bankName)) {
                sqlBuilder.append(" AND f.BANK_NAME = :bankName");
                params.put("bankName", bankName);
            }
            if (StringUtils.hasText(accountNumber)) {
                sqlBuilder.append(" AND REGEXP_REPLACE(f.ACCOUNT_NUMBER, '[^0-9]', '') = REGEXP_REPLACE(:accountNumber, '[^0-9]', '')");
                params.put("accountNumber", accountNumber);
            }
            if(StringUtils.hasText(serviceType)) {
                sqlBuilder.append(" AND f.SERVICE_TYPE = :serviceType");
                params.put("serviceType", serviceType);
            }
            if(status != null && status != -1) {
                sqlBuilder.append(" AND f.STATUS = :status");
                params.put("status", status);
            }

            Query q = entityManager.createNativeQuery(sqlBuilder.toString(), BankConfigEntity.class);

            params.forEach(q::setParameter);

            if (page >= 0 && size > 0) {
                q.setFirstResult(page * size);
                q.setMaxResults(size);
            }

            return q.getResultList();
        } catch (Exception e) {
            log.error("Lỗi khi lọc tài khoản: ", e);
            return List.of();
        }
    }
}