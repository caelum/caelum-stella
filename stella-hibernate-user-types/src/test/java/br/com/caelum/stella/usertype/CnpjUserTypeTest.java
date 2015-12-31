package br.com.caelum.stella.usertype;

import static org.junit.Assert.assertEquals;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.stella.tinytype.CNPJ;

public class CnpjUserTypeTest {
  
  private static SessionFactory factory;
  
  @BeforeClass
  public static void geraBanco() {
    Configuration cfg = new Configuration();
    cfg.addAnnotatedClass(PessoaJuridica.class);
    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg
      .getProperties()).build();
    factory = cfg.buildSessionFactory(serviceRegistry);
  }
  
  @Test
  public void shouldSaveAndLoadEntityMappedWithCnpjUserType() {
    Session session = factory.openSession();
    Transaction transaction = session.beginTransaction();
    PessoaJuridica pessoa = new PessoaJuridica();
    CNPJ cnpj = new CNPJ("55.555.555/55555-55");
    pessoa.setCnpj(cnpj);
    session.save(pessoa);
    transaction.commit();
    session.flush();
    session.close();
    session = factory.openSession();
    Long id = pessoa.getId();
    PessoaJuridica load = session.load(PessoaJuridica.class, id);
    assertEquals(cnpj, load.getCnpj());
  }
}
