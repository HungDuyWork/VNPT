package com.test.vnpt.repository;

import com.test.vnpt.dto.request.CustomerRequest;
import com.test.vnpt.dto.response.RsTransResultDTO;
import com.test.vnpt.repository.custom.RsTransResultRefundRepositoryCustom;
import com.test.vnpt.utils.TransformObjToCamel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
@Slf4j
public class RsTransResultRefundRepositoryImpl implements RsTransResultRefundRepositoryCustom {

    private final EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<RsTransResultDTO> find(CustomerRequest request) {
        try {
            StringBuilder sqlBuilder = new StringBuilder();
            Map<String, Object> params = new HashMap<>();

            createSqlListSearchSql(request, sqlBuilder, params);

            Query query = em.createNativeQuery(sqlBuilder.toString())
                    .unwrap(org.hibernate.query.NativeQuery.class)
                    .setResultTransformer(new TransformObjToCamel());

            params.forEach(query::setParameter);

            if (request.getPage() >= 0 && request.getSize() > 0) {
                query.setFirstResult(request.getPage() * request.getSize());
                query.setMaxResults(request.getSize());
            }
            return query.getResultList();
        } catch (Exception e) {
            log.error("Lỗi khi tìm kiếm dữ liệu: ", e);
            return List.of();
        }
    }


    private void createSqlListSearchSql(CustomerRequest request, StringBuilder sql, Map<String, Object> params) {
        sql.append("select rbc.BANK_NAME,rbc.ACCOUNT_NUMBER, rtr.STATEMENT_CODE, rtr.STATEMENT_BANK, rtr.TRANSACTION_VNPT," +
                "rtr.AMOUNT, rtrs.RECONCILE_CODE, rtr.MORE_INFO, rtr.TAX_CODE, rtr.VALUE_DATE, rtr.FMIS_ID_GD \n");
        sql.append("from RS_TRANS_RESULT_REFUND rtrs \n ");
        sql.append(" join RS_BANK_CONFIG rbc on rbc.ID = rtrs.BANK_CONFIG_ID \n ");
        sql.append(" join RS_TRANS_RESULT rtr on rtr.ID = rtrs.RS_TRANS_RESULT_ID \n");
        sql.append("where 1 = 1\n");
        if(StringUtils.hasText(request.getBankName()) && StringUtils.hasText(request.getAccountNumber())) {
            sql.append(" and rbc.BANK_NAME = :bankName \n");
            sql.append(" and rbc.ACCOUNT_NUMBER = :accountNumber \n");
            params.put("bankName",request.getBankName());
            params.put("accountNumber",request.getAccountNumber());
        }

        if(StringUtils.hasText(request.getReconcileCode())) {
            sql.append(" and rtrs.RECONCILE_CODE = :reconcileCode \n");
            params.put("reconcileCode",request.getReconcileCode());
        }

        if (StringUtils.hasText(request.getTransactionVnpt())) {
            sql.append(" and rtr.TRANSACTION_VNPT = :transactionVnpt \n");
            params.put("transactionVnpt", request.getTransactionVnpt());
        }

        if (request.getFromAmount() != null && request.getToAmount() != null) {
            sql.append(" and rtr.AMOUNT between :fromAmount and :toAmount \n");
            params.put("fromAmount", request.getFromAmount());
            params.put("toAmount", request.getToAmount());
        }

    }
}