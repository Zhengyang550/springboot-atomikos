package com.jnu.datasource;

import com.jnu.config.DBConfig2;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;


/**
 * @Author: zy
 * @Description: 读取数据源datasource2配置信息
 * @Date: 2020-2-5
 */
//表示这个类为一个配置类
@Configuration
//配置mybatis的接口类放的地方
@MapperScan(basePackages = "com.goldwind.mapper.datasource2", sqlSessionTemplateRef = "testSqlSessionTemplate2")
public class MyBatisConfig2 {
    //创建一个bean对象，并注入到Spring容器中
    @Bean(name = "testDataSource2")
    public DataSource testDataSource(DBConfig2 testConfig) throws SQLException {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(testConfig.getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(testConfig.getPassword());
        mysqlXaDataSource.setUser(testConfig.getUsername());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);

        //将本地事务注册到Atomikos全局事务
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("testDataSource2");

        xaDataSource.setMinPoolSize(testConfig.getMinPoolSize());
        xaDataSource.setMaxPoolSize(testConfig.getMaxPoolSize());
        xaDataSource.setMaxLifetime(testConfig.getMaxLifetime());
        xaDataSource.setBorrowConnectionTimeout(testConfig.getBorrowConnectionTimeout());
        xaDataSource.setLoginTimeout(testConfig.getLoginTimeout());
        xaDataSource.setMaintenanceInterval(testConfig.getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(testConfig.getMaxIdleTime());
        xaDataSource.setTestQuery(testConfig.getTestQuery());
        return xaDataSource;
    }

    /**
     * 功能描述:(datasource2 sql会话工厂)
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "testSqlSessionFactory2")
    //@Qualifier表示查找Spring容器中名字为datasource2DataSource的对象
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("testDataSource2") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "testSqlSessionTemplate2")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("testSqlSessionFactory2") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
