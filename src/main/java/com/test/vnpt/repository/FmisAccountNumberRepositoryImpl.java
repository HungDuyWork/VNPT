package com.test.vnpt.repository;

import com.test.vnpt.entity.FmisAccountNumber;
import com.test.vnpt.repository.custom.FmisAccountNumberRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import java.util.HashMap;
import java.util.Map;

@Repository
@RequiredArgsConstructor
@Slf4j
public class FmisAccountNumberRepositoryImpl implements FmisAccountNumberRepositoryCustom {

    private final EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<FmisAccountNumber> filterAccounts(String bankCode, Integer status, Integer fmisAccountId, String accountNumber, int page, int size) {
        try {
            StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM FMIS_ACCOUNT_NUMBER f WHERE 1=1 ");
            Map<String, Object> params = new HashMap<>();

            if (StringUtils.hasText(bankCode)) {
                sqlBuilder.append(" AND f.BANK_CODE = :bankCode");
                params.put("bankCode", bankCode);
            }
            if (status != null && status != -1) {
                sqlBuilder.append(" AND f.STATUS = :status");
                params.put("status", status);
            }
            if (fmisAccountId != null && fmisAccountId != -1) {
                sqlBuilder.append(" AND f.FMIS_ACCOUNT_ID = :fmisAccountId");
                params.put("fmisAccountId", fmisAccountId);
            }
            if (StringUtils.hasText(accountNumber)) {
                sqlBuilder.append(" AND REGEXP_REPLACE(f.ACCOUNT_NUMBER, '[^0-9]', '') = REGEXP_REPLACE(:accountNumber, '[^0-9]', '')");
                params.put("accountNumber", accountNumber);
            }

            Query q = em.createNativeQuery(sqlBuilder.toString(), FmisAccountNumber.class);

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