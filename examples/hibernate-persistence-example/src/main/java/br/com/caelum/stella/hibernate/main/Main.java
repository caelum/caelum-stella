package br.com.caelum.stella.hibernate.main;

import org.hibernate.classic.Session;
import org.hibernate.validator.InvalidStateException;
import org.hibernate.validator.InvalidValue;

import util.HibernateUtil;
import br.com.caelum.stella.hibernate.persistence.Modelo;
import br.com.caelum.stella.hibernate.persistence.ModeloDAO;

public class Main {

	public static void main(String[] args) {
		Modelo modeloValido = new Modelo();
		modeloValido.setCPF("63101405076");
		modeloValido.setCNPJ("71693607000142");
		save(modeloValido);
		Modelo modeloInvalido = new Modelo();
		modeloInvalido.setCPF("63101405078");
		modeloInvalido.setCNPJ("5");
		save(modeloInvalido);
		ListaModelos();
	}

	private static void ListaModelos() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ModeloDAO dao = new ModeloDAO(session);
		System.out.println("Listagem de modelos:");
		for (Modelo modelo : dao.listAll()){
			System.out.println("\t"+modelo);
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
			System.out.println("Causas:");
			for (InvalidValue invalidValue : e.getInvalidValues()){
				System.out.println("\t"+invalidValue.getMessage());
			}
			session.getTransaction().rollback();
		}
	}
}
