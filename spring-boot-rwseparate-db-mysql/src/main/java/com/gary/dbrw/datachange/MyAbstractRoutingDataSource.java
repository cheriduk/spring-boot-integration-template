package com.gary.dbrw.datachange;

import com.gary.dbrw.util.NumberUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MyAbstractRoutingDataSource extends AbstractRoutingDataSource {

    @Value("${mysql.datasource.num}")
    private int num;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    protected Object determineCurrentLookupKey() {
        String typeKey = DbContextHolder.getDbType();
        if (typeKey.equals(DbContextHolder.WRITE)) {
            log.info("使用了写库w");
            return typeKey;
        }
        //使用随机数决定使用哪个读库（可写负载均衡算法）
        int sum = NumberUtil.getRandom(1, num);
        log.info("使用了读库r{}", sum);
        return DbContextHolder.READ + sum;
    }
}
