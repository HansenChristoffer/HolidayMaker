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
 * https://sysjm3.newton.nodehill.se/article/spring-sqlite
 */
import org.hibernate.boot.MappingException;
import org.hibernate.dialect.identity.IdentityColumnSupportImpl;

public class SQLiteIdentityColumnSupport extends IdentityColumnSupportImpl {

  @Override
  public boolean supportsIdentityColumns() {
    return true;
  }

  @Override
  public String getIdentitySelectString(String table, String column, int type)
          throws MappingException {
    return "select last_insert_rowid()";
  }

  @Override
  public String getIdentityColumnString(int type) throws MappingException {
    return "integer";
  }
}