package com.sy.doc.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import java.io.IOException;

/**
 */
@Slf4j
@SpringBootConfiguration
@EnableTransactionManagement
public class DataSourceConfig implements TransactionManagementConfigurer {

    @Autowired
    private DataSource dataSource;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new DataSource();
    }

    @Bean(name = "sqlSessionFactory")
    @ConditionalOnBean(DataSource.class)
    public SqlSessionFactoryBean sqlSessionFactory() throws IOException {
        DefaultResourceLoader defaultLoader = new DefaultResourceLoader();
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setMapperLocations(
                new PathMatchingResourcePatternResolver(defaultLoader).getResources("sqlmap/*.xml"));
        return sqlSessionFactory;
    }

    @Bean
    @Override
    @ConditionalOnBean(DataSource.class)
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
