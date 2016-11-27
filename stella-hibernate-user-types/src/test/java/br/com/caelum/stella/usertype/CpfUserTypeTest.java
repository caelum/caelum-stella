package br.com.caelum.stella.usertype;

import static org.junit.Assert.assertEquals;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.tinytype.CPF;

public class CpfUserTypeTest {

  private static SessionFactory factory;

  @Before
  public void geraBanco() {
    Configuration cfg = new Configuration();
    cfg.addAnnotatedClass(PessoaFisica.class);
    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg
      .getProperties()).build();
    factory = cfg.buildSessionFactory(serviceRegistry);
  }

  @Test
  public void shouldSaveAndLoadEntityMappedWithCpfUserType() {
    Session session = factory.openSession();
    Transaction transaction = session.beginTransaction();
    PessoaFisica pessoa = new PessoaFisica();
    CPF cpf = new CPF("555.555.555-55");
    pessoa.setCpf(cpf);
    session.save(pessoa);
    transaction.commit();
    session.close();
    session = factory.openSession();
    Long id = pessoa.getId();
    PessoaFisica load = session.load(PessoaFisica.class, id);
    assertEquals(cpf, load.getCpf());
  }

}
