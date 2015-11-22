package dao;

import hbt.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ProveedorENT;

public class ProveedorDAO {
	protected static ProveedorDAO instancia = null;
	protected static SessionFactory sf = null;
	protected static Session session = null;
	
	public static ProveedorDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new ProveedorDAO();
		} 
		return instancia;
	}
	
	public ProveedorENT BuscarProveedor(String cuit) {
		session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from ProveedorENT prov  where prov.cuit = :cuit");
		query.setString("cuit", cuit);
		ProveedorENT provENT = (ProveedorENT) query.uniqueResult();
		session.flush();
		session.close();
		return provENT;
	}	
}
