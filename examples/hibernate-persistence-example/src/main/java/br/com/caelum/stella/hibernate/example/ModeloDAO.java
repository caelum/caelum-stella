package br.com.caelum.stella.hibernate.example;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public class ModeloDAO {

    private Session session;

    public ModeloDAO(Session session) {
        super();
        this.session = session;
    }

    public Modelo load(Serializable id) throws HibernateException {
        return (Modelo) session.load(Modelo.class, id);
    }

    public void persist(Modelo modelo) throws HibernateException {
        session.persist(modelo);
    }

    public Serializable save(Modelo modelo) throws HibernateException {
        return session.save(modelo);
    }

    public void update(Modelo modelo) throws HibernateException {
        session.update(modelo);
    }

    @SuppressWarnings("unchecked")
    public List<Modelo> listAll() {
        List<Modelo> list = session.createCriteria(Modelo.class).list();
        return list;
    }

}
