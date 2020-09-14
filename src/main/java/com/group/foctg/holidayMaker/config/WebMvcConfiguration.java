package com.group.foctg.holidayMaker.config;

/**
 *
 * @author Christoffer Hansen &lt;chris.hansen.ch@outlook.com&gt;
 */
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@Configuration
class WebMvcConfiguration implements WebMvcConfigurer {

  @Bean
  public DataSource dataSource() {
    DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
    dataSourceBuilder.driverClassName("org.sqlite.JDBC");
    dataSourceBuilder.url("jdbc:sqlite:./src/main/resources/data/hmdb.db");
    return dataSourceBuilder.build();
  }
}