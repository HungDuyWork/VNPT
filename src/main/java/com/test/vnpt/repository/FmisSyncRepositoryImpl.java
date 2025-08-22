package com.test.vnpt.repository;

import com.test.vnpt.dto.request.FmisSyncRequest;
import com.test.vnpt.repository.custom.FmisSyncRepositoryCustom;
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
public class FmisSyncRepositoryImpl implements FmisSyncRepositoryCustom {

    private final EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<?> findFmisSync(FmisSyncRequest request) {
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
    private void createSqlListSearchSql(FmisSyncRequest request, StringBuilder sql, Map<String, Object> params) {
        sql.append("select fs.ID, fs.ID_GD, fs.NGAY, rsb.BANK_NAME, "
        + "rsb.ACCOUNT_NUMBER, fs.TK_NH_NH, fs.TK_NH_CH, fs.LOAI_NV,"
        + "fs.LOAI_SK, fs.MERCHANT, fs.TIEN, fs.TRANSACTION_STATUS, "
        + "fs.CREATE_DATE, fs.LAST_UPDATE, fs.SO_CHUNG_TU, fs.NOI_DUNG, fs.TRANSACTION_THONGBAO \n");

        sql.append("from FMIS_SYNC fs \n");
        sql.append("left join RS_BANK_CONFIG rsb ON rsb.ID = fs.BANK_CONFIG_ID \n");
        sql.append("where 1 = 1\n");
        if(StringUtils.hasText(request.getBankName()) && StringUtils.hasText(request.getAccountNumber())) {
            sql.append(" and rbc.BANK_NAME = :bankName \n");
            sql.append(" and rbc.ACCOUNT_NUMBER = :accountNumber \n");
            params.put("bankName",request.getBankName());
            params.put("accountNumber",request.getAccountNumber());
        }
        if(StringUtils.hasText(request.getServiceType())) {
            sql.append(" and rsb.SERVICE_TYPE = :serviceType \n");
            params.put("serviceType",request.getServiceType());
        }
        if(StringUtils.hasText(request.getTransactionStatus())) {
            sql.append(" and fs.TRANSACTION_STATUS = :transactionStatus \n");
            params.put("transactionStatus",request.getTransactionStatus());
        }
        if(StringUtils.hasText(request.getLoaiSk())) {
            sql.append(" and fs.LOAI_SK = :loaiSk \n");
            params.put("loaiSk",request.getLoaiSk());
        }
        if(StringUtils.hasText(request.getFromDate()) && StringUtils.hasText(request.getToDate())) {
            sql.append(" AND fs.NGAY BETWEEN :fromDate AND :toDate \n");
            params.put("fromDate", request.getFromDate());
            params.put("toDate", request.getToDate());
        }
    }
}
