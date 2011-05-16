package br.com.caelum.stella.hibernate.example;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;

import org.hibernate.classic.Session;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.hibernate.example.util.HibernateUtil;

public class HibernatePersistenceExample {
	
	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();


    public static void main(String[] args) {
        Modelo valido = criaModeloValido();
//        Set<ConstraintViolation<Modelo>> violationsForValido = validator.validate(valido);

//        System.out.println(violationsForValido);
        
        save(valido);
        Modelo invalido = criaModeloInvalido();
        save(invalido);
//        Set<ConstraintViolation<Modelo>> violationsForInvalido = validator.validate(invalido);
//        System.out.println(violationsForInvalido);
        listaModelosPersistidos();
    }

    private static Modelo criaModeloInvalido() {
        Modelo modeloInvalido = new Modelo();
        modeloInvalido.setCpf("63101405078");
        modeloInvalido.setCnpj("5");
        return modeloInvalido;
    }

    private static Modelo criaModeloValido() {
        Modelo modeloValido = new Modelo();
        modeloValido.setCpf("63101405076");
        modeloValido.setCnpj("71693607000142");
        return modeloValido;
    }

    private static void listaModelosPersistidos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ModeloDAO dao = new ModeloDAO(session);
        System.out.println("Listagem de modelos persistidos:");
        for (Modelo modelo : dao.listAll()) {
            System.out.println("\t" + modelo);
        }
    }

    private static void save(Modelo modelo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ModeloDAO dao = new ModeloDAO(session);
        try {
            dao.save(modelo);
            System.out.println("Modelo válido: " + modelo);
            session.getTransaction().commit();
        } catch (ConstraintViolationException e) {
            System.out.println("Modelo inválido: " + modelo);
            System.out
                    .println("Listagem das mensagens de validação (obtidas do arquivo ValidatorMessages.properties):");
            for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
                System.out.println("\t" + violation.getMessage());
            }
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}
