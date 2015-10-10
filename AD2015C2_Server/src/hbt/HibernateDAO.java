package hbt;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateDAO {
	
	protected static HibernateDAO instancia = null;
	protected static SessionFactory sf = null;
	protected static Session session = null;
	
	public static HibernateDAO getInstancia() {
		if (instancia == null) {
			instancia = new HibernateDAO();
			sf = HibernateUtil.getSessionFactory();
		}
		
		return instancia;
	}

	protected Session getSession() {
		if(session == null || !session.isOpen())
			session = sf.openSession();
		return session;
	}
	
	public void closeSession() {
		if (session.isOpen()) session.close();
	}
	
	@SuppressWarnings("rawtypes")
	public void grabarLista(List lista){
		session = getSession();
		session.beginTransaction();
		for(Object e : lista){
			session.persist(e);
		}
		session.getTransaction().commit();
	}
	
	public void saveOrUpdate(Object objeto){
		session = getSession();
		session.beginTransaction();
		session.saveOrUpdate(objeto);
		session.getTransaction().commit();
		session.close();
	}
	
}
