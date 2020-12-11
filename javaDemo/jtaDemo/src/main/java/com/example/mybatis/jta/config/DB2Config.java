package com.example.mybatis.jta.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.cj.jdbc.MysqlXADataSource;
import lombok.Data;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

@Data
@ConfigurationProperties(prefix = "spring.datasource.db2")
@Configuration
@MapperScan(basePackages = "com.example.mybatis.jta.mapper.datasource2", sqlSessionTemplateRef = "database2SqlSessionTemplate")
public class DB2Config {

    String url;
    String username;
    String password;
    int maxTotal;
    String mapperLocations;

    @Bean(name = "database2")
    public DataSource getXADataSource() throws SQLException {
        MysqlXADataSource dataSource = new MysqlXADataSource();
        dataSource.setURL(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        dataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean xaDatasource = new AtomikosDataSourceBean();
        xaDatasource.setXaDataSource(dataSource);
        xaDatasource.setUniqueResourceName("database2");
        xaDatasource.setMaxPoolSize(maxTotal);
        xaDatasource.setMinPoolSize(3);
        return xaDatasource;
    }

    @Bean (name="database2SqlSessionFactory")
    public SqlSessionFactory user2SqlSessionTemplate() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        MybatisProperties mybatisProperties = new MybatisProperties();
        String[] locations = {mapperLocations};
        mybatisProperties.setMapperLocations(locations);
        bean.setMapperLocations(mybatisProperties.resolveMapperLocations());
        bean.setDataSource(getXADataSource());
        return bean.getObject();
    }

    @Bean(name = "database2SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(user2SqlSessionTemplate());
    }

}
