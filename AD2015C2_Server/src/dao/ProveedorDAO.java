package dao;

import hbt.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dominio.Proveedor;

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
	
	public void Insert(Proveedor proveedor)	{
		session = sf.openSession();
		session.beginTransaction();
		session.persist(proveedor);
		session.getTransaction().commit();
		session.close();
	}
	
}
