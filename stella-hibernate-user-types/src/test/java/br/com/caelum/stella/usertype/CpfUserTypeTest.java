package br.com.caelum.stella.usertype;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.stella.tinytype.CPF;

import static org.junit.Assert.assertEquals;


public class CpfUserTypeTest {

	private static SessionFactory factory;

	@BeforeClass
	public static void geraBanco(){
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(PessoaFisica.class);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();        
        factory = cfg.buildSessionFactory(serviceRegistry);
	}
	
	@Test
	public void shouldSaveAndLoadEntityMappedWithCpfUserType(){
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		PessoaFisica pessoa = new PessoaFisica();
		CPF cpf = new CPF("555.555.555-55");
		pessoa.setCpf(cpf);
		session.save(pessoa);
		transaction.commit();
		session.flush();
		session.close();
		session = factory.openSession();
		Long id = pessoa.getId();
		PessoaFisica load = (PessoaFisica) session.load(PessoaFisica.class, id);
		assertEquals(cpf, load.getCpf());
	}
	
}
