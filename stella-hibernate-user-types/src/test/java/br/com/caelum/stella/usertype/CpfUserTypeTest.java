package br.com.caelum.stella.usertype;

import junit.framework.Assert;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.stella.tinytype.CPF;


public class CpfUserTypeTest {

	private static SessionFactory factory;

	@BeforeClass
	public static void geraBanco(){
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(PessoaFisica.class);
		factory = cfg.buildSessionFactory();
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
		Assert.assertEquals(cpf, load.getCpf());
	}
	
}
