package com.hanshan.mysql8.config;

import com.hanshan.common.config.IJdbcConfiguration;
import com.hanshan.common.pojo.model.ServerInfo;
import lombok.Data;

@Data
public class Mysql8Configuration implements IJdbcConfiguration {
    private String driver = "com.mysql.cj.jdbc.Driver";
    //private String jdbcUrl = "jdbc:mysql://localhost:3306/database";
    //private String jdbcUrl = "jdbc:mysql://";
    private Boolean hasDatabaseUrl = true;
    private Boolean hasSchemaUrl = false;
    private Boolean hasDatabase = true;
    private Boolean hasSchema = false;
    private Integer maximumPoolSize = 5;
    private Integer minimumIdle = 1;
    private Long maxLifeTime = 10 * 60 * 1000L;
    private Long idleTimeout = 10 * 60 * 1000L;

    private Mysql8Configuration(Integer maximumPoolSize, Integer minimumIdle, Long maxLifeTime, Long idleTimeout) {
       
        this.maximumPoolSize = maximumPoolSize;
        this.minimumIdle = minimumIdle;
        if (maxLifeTime != null)
            this.maxLifeTime = maxLifeTime;
        if (idleTimeout != null)
            this.idleTimeout = idleTimeout;
    }

    public static Mysql8Configuration getInstance(Integer maximumPoolSize, Integer minimumIdle, Long maxLifeTime, Long idleTimeout) {
        return new Mysql8Configuration(maximumPoolSize,minimumIdle,maxLifeTime,idleTimeout);
    }
    @Override
    public String getDriver() {
        return this.driver;
    }

    @Override
    public String getServerUrl(ServerInfo server) {
        String jdbcUrl = "jdbc:mysql://%s:%s";
        return String.format(jdbcUrl, server.getHost(), server.getPort());
    }

    @Override
    public String getDbUrl(ServerInfo server, String db) {
        String jdbcUrl = "jdbc:mysql://%s:%s/%s";
        return String.format(jdbcUrl, server.getHost(), server.getPort(), db);
    }

    @Override
    public String getSchemaUrl(ServerInfo server, String db, String schema) {
        return null;
    }

    @Override
    public Boolean hasDatabaseUrl() {
        return this.hasDatabaseUrl;
    }

    @Override
    public Boolean hasSchemaUrl() {
        return this.hasSchemaUrl;
    }

    @Override
    public Boolean hasDatabase() {
        return this.hasDatabase;
    }

    @Override
    public Boolean hasSchema() {
        return this.hasSchema;
    }

    @Override
    public Integer getMaximumPoolSize() {
        return this.maximumPoolSize;
    }

    @Override
    public Integer getMinimumIdle() {
        return this.minimumIdle;
    }

    @Override
    public Long getMaxLifeTime() {
        return this.maxLifeTime;
    }

    @Override
    public String getDefaultSchema() {
        return null;
    }
}
