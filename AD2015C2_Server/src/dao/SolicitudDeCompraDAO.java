package dao;

import java.util.Collections;
import java.util.List;

import hbt.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.SolicitudDeCompraENT;

public class SolicitudDeCompraDAO {

	protected static SolicitudDeCompraDAO instancia = null;
	protected static SessionFactory sf = null;
	protected static Session session = null;
	
	public static SolicitudDeCompraDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
		} 
		return instancia;
	}

	@SuppressWarnings("unchecked")
	public List<SolicitudDeCompraENT> obtenerPendientes() {
		session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from SolicitudDeCompraENT sc  where sc.estado = :estado");
		query.setString("estado", "pendiente");
		List<SolicitudDeCompraENT> pendientes = (List<SolicitudDeCompraENT>) query.list();
		session.flush();
		session.close();
		return pendientes;
	}
	
}
