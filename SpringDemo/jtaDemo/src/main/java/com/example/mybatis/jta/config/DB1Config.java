package com.example.mybatis.jta.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.cj.jdbc.MysqlXADataSource;
import lombok.Data;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Data
@ConfigurationProperties(prefix = "spring.datasource.db1")
@Configuration
@MapperScan(basePackages = "com.example.mybatis.jta.mapper.datasource1", sqlSessionTemplateRef = "database1SqlSessionTemplate")
public class DB1Config {

    String url;
    String username;
    String password;
    int maxTotal;

    @Bean(name = "databases1")
    public DataSource createXADataSource() throws SQLException {
        MysqlXADataSource dataSource = new MysqlXADataSource();
        dataSource.setURL(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        dataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean xaDatasource = new AtomikosDataSourceBean();
        xaDatasource.setXaDataSource(dataSource);
        xaDatasource.setUniqueResourceName("database1");
        xaDatasource.setMaxPoolSize(maxTotal);
        return xaDatasource;
    }
}
