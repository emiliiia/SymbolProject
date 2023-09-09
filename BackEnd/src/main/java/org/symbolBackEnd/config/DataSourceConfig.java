package org.symbolBackEnd.config;
/*
  @author emilia
  @project SymbolProject
  @class DataSourceConfig
  @version 1.0.0
  @since 05.09.2023 - 20:18
*/

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource getDataSource(@Value("${spring.datasource.url}") String url,
                                    @Value("${spring.datasource.driverClassName}") String driverClassName,
                                    @Value("${spring.datasource.username}") String username,
                                    @Value("${spring.datasource.password}") String password
    ) {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driverClassName);
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }
}
