package br.com.caelum.stella.usertype;

import junit.framework.Assert;

import org.hibernate.SessionFactory;
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
	public void shouldSaveEntityMappedWithCpfUserType(){
		Session session = factory.openSession();
		PessoaFisica pessoa = new PessoaFisica();
		pessoa.setCpf(new CPF("555.555.555-55"));
		session.save(pessoa);
		Assert.assertNotNull(pessoa.getId());
	}
	
	@Test
	public void shouldLoadEntity(){
		Session session = factory.openSession();
		PessoaFisica result = (PessoaFisica) session.createCriteria(
				PessoaFisica.class).setMaxResults(1).uniqueResult();
		Assert.assertNotNull(result.getCpf());
	}
	
}
