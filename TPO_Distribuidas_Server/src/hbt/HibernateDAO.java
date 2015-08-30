package hbt;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateDAO {
	
	protected static SessionFactory sf = null;
	protected static Session session = null;
	
	static  {
		sf = HibernateUtil.getSessionFactory();
	}

	protected Session getSession(){
		if(session == null || !session.isOpen()){
			session = sf.openSession();
		}
		return session;
	}
	
	public void closeSession(){
		if (session.isOpen()) session.close();
	}
	
	@SuppressWarnings("rawtypes")
	public void grabarLista(List lista){
		Session session = getSession();
		session.beginTransaction();
		for(Object e : lista){
			session.persist(e);
		}
		session.getTransaction().commit();
	}
	

}
