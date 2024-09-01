/*
 * Copyright 2013 The musicbrainz-data Authors
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package fm.last.musicbrainz.data.hibernate;

import fm.last.musicbrainz.data.model.ReleaseGroupPrimaryType;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReleaseGroupPrimaryTypeUserType extends AbstractEnumUserType<ReleaseGroupPrimaryType> {

  public ReleaseGroupPrimaryTypeUserType() {
    super(ReleaseGroupPrimaryType.class);
  }

  @Override
  public Integer getIntegerValue(ReleaseGroupPrimaryType type) {
    return type.getId();
  }

  @Override
  public ReleaseGroupPrimaryType getEnumConstant(Integer id) {
    return ReleaseGroupPrimaryType.valueOf(id);
  }

  @Override
  public Object nullSafeGet(ResultSet resultSet, String[] strings, SessionImplementor sessionImplementor, Object o) throws HibernateException, SQLException {
    return null;
  }

  @Override
  public void nullSafeSet(PreparedStatement preparedStatement, Object o, int i, SessionImplementor sessionImplementor) throws HibernateException, SQLException {

  }
}
