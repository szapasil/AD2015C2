package dao;

import hbt.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ListaComparativaENT;

public class ListaComparativaDAO {

	protected static ListaComparativaDAO instancia = null;
	protected static SessionFactory sf = null;
	protected static Session session = null;
	
	public static ListaComparativaDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new ListaComparativaDAO();
		} 
		return instancia;
	}

	public ListaComparativaENT BuscarLC() {
		session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from ListaComparativaENT");
		ListaComparativaENT lcENT = (ListaComparativaENT) query.uniqueResult();
		session.flush();
		session.close();
		return lcENT;
	}
	
}
