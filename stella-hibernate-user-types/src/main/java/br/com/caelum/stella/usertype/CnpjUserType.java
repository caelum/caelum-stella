package br.com.caelum.stella.usertype;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

import br.com.caelum.stella.tinytype.CNPJ;

/**
 * @author Dayan Costa
 */
public class CnpjUserType implements UserType {

  private static final int[] SQL_TYPES = { Types.VARCHAR };

  @Override
  public Object assemble(Serializable cached, Object owner) throws HibernateException {
    return cached;
  }

  @Override
  public Object deepCopy(Object value) throws HibernateException {
    return value;
  }

  @Override
  public Serializable disassemble(Object value) throws HibernateException {
    return (Serializable) value;
  }

  @Override
  public boolean equals(Object x, Object y) throws HibernateException {
    if (x == y) {
      return true;
    } else if ((x == null) || (y == null)) {
      return false;
    } else {
      return x.equals(y);
    }
  }

  @Override
  public int hashCode(Object x) throws HibernateException {
    return x.hashCode();
  }

  @Override
  public boolean isMutable() {
    return false;
  }

  @Override
  public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner)
      throws HibernateException, SQLException {
    String name = rs.getString(names[0]);
    return rs.wasNull() ? null : new CNPJ(name);
  }

  @Override
  public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session)
      throws HibernateException, SQLException {
    if (value == null) {
      st.setNull(index, Types.VARCHAR);
    } else {
      st.setString(index, value.toString());
    }
  }

  @Override
  public Object replace(Object original, Object target, Object owner) throws HibernateException {
    return original;
  }

  @Override
  @SuppressWarnings("rawtypes")
  public Class returnedClass() {
    return CNPJ.class;
  }

  @Override
  public int[] sqlTypes() {
    return SQL_TYPES;
  }

}
