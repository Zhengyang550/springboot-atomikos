package com.jnu.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: zy
 * @Description: 读取配置文件信息
 * @Date: 2020-2-5
 */
@Data
@ConfigurationProperties(prefix = "mysql.datasource.datasource2")
public class DBConfig2 {
    private String url;
    private String username;
    private String password;
    private int minPoolSize;
    private int maxPoolSize;
    private int maxLifetime;
    private int borrowConnectionTimeout;
    private int loginTimeout;
    private int maintenanceInterval;
    private int maxIdleTime;
    private String testQuery;
}

