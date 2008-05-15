package br.com.caelum.stella.hibernate.example.main;

import org.hibernate.classic.Session;
import org.hibernate.validator.InvalidStateException;
import org.hibernate.validator.InvalidValue;

import util.HibernateUtil;
import br.com.caelum.stella.hibernate.example.persistence.Modelo;
import br.com.caelum.stella.hibernate.example.persistence.ModeloDAO;

public class HibernatePersistenceExample {

	public static void main(String[] args) {
		Modelo valido = criaModeloValido();
		save(valido);
		Modelo invalido = criaModeloInvalido();
		save(invalido);
		ListaModelosPersistidos();
	}

	private static Modelo criaModeloInvalido() {
		Modelo modeloInvalido = new Modelo();
		modeloInvalido.setCPF("63101405078");
		modeloInvalido.setCNPJ("5");
		return modeloInvalido;

	}

	private static Modelo criaModeloValido() {
		Modelo modeloValido = new Modelo();
		modeloValido.setCPF("63101405076");
		modeloValido.setCNPJ("71693607000142");
		return modeloValido;
	}

	private static void ListaModelosPersistidos() {
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
		} catch (InvalidStateException e) {
			System.out.println("Modelo inválido: " + modelo);
			System.out.println("Listagem das mensagens de validação (obtidas do arquivo ValidatorMessages.properties):");
			for (InvalidValue invalidValue : e.getInvalidValues()) {
				System.out.println("\t" + invalidValue.getMessage());
			}
			session.getTransaction().rollback();
		}
		finally {
			session.close();
		}
	}
}
