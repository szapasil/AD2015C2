package dao;

import hbt.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.OrdenDeCompraENT;

public class OrdenDeCompraDAO {
	protected static OrdenDeCompraDAO instancia = null;
	protected static SessionFactory sf = null;
	protected static Session session = null;
	
	public static OrdenDeCompraDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new OrdenDeCompraDAO();
		} 
		return instancia;
	}
	
	public OrdenDeCompraENT BuscarOC(int numero) {
		session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from OrdenDeCompraENT oc  where oc.numero = :numero");
		query.setInteger("numero", numero);
		OrdenDeCompraENT ocENT = (OrdenDeCompraENT) query.uniqueResult();
		session.flush();
		session.close();
		return ocENT;
	}	
}