package com.hanshan.sqlbase;

import com.zaxxer.hikari.HikariDataSource;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConnectionWrapper {
    /**
     * 数据源
     */
    private HikariDataSource dataSource;
    /**
     * 连接的数据库
     */
    private String db;
    /**
     *
     */
    private String schema;

}
