package dao;

import hbt.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dominio.CondCompra;
import entities.CondCompraENT;

public class CondCompraDAO {

	protected static CondCompraDAO instancia = null;
	protected static SessionFactory sf = null;
	protected static Session session = null;
	
	public static CondCompraDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
		} 
		return instancia;
	}

	public void bajaLC(CondCompraENT condCompraENT) {
		session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("update from CondCompraENT set itemLC = ? where id = ?");
		query.setParameter(0, null);
		query.setInteger(1, condCompraENT.getId());
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}

	public void altaLC(CondCompraENT ent) {
		session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("update from CondCompraENT set itemLC = ? where id = ?");
		query.setParameter(0, null);
		query.setInteger(1, condCompraENT.getId());
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();	
	}
	
}
