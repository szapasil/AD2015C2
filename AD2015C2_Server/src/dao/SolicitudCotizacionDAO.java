package dao;

import hbt.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.SolicitudCotizacionENT;

public class SolicitudCotizacionDAO {
	protected static SolicitudCotizacionDAO instancia = null;
	protected static SessionFactory sf = null;
	protected static Session session = null;
	
	public static SolicitudCotizacionDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new SolicitudCotizacionDAO();
		} 
		return instancia;
	}
	
	public SolicitudCotizacionENT buscarSolicitudCotizacion(int numero) {
		session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM SolicitudCotizacionENT WHERE numero = :numero");
		query.setInteger("numero", numero);
		SolicitudCotizacionENT scENT = (SolicitudCotizacionENT) query.uniqueResult();
		session.close();
		return scENT;
	}
	
}
