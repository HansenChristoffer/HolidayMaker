/*
 * Copyright 2020-2030 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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