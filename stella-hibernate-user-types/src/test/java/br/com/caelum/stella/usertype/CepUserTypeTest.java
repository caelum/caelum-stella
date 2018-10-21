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

import br.com.caelum.stella.tinytype.CEP;

/**
 * @author Edenir Norberto Anschau
 *
 */
public class CepUserTypeTest {

    private static SessionFactory factory;

    @BeforeClass
    public static void geraBanco() {
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Endereco.class);
        ServiceRegistry serviceRegistry;
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
        factory = cfg.buildSessionFactory(serviceRegistry);
    }

    @Test
    public void shouldSaveAndLoadEntityMappedWithCepUserType() {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Endereco endereco = new Endereco();
        CEP cep = new CEP("12345-678");
        endereco.setCep(cep);
        session.save(endereco);
        transaction.commit();
        session.flush();
        session.close();
        session = factory.openSession();
        Long id = endereco.getId();
        Endereco load = (Endereco) session.load(Endereco.class, id);
        assertEquals(cep, load.getCep());
    }

}