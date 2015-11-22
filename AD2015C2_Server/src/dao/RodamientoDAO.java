package dao;

import hbt.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.RodamientoENT;

public class RodamientoDAO {

	protected static RodamientoDAO instancia = null;
	protected static SessionFactory sf = null;
	protected static Session session = null;
	
	public static RodamientoDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new RodamientoDAO();
		} 
		return instancia;
	}
	
	public RodamientoENT BuscarRodamiento(String codRodamiento) {
		session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from RodamientoENT rod where rod.codRodamiento = :codRodamiento");
		query.setString("codRodamiento", codRodamiento);
		RodamientoENT rodENT = (RodamientoENT) query.uniqueResult();
		session.flush();
		session.close();
		return rodENT;
	}	

}