package dao;

import hbt.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dominio.Cliente;



public class ClienteDAO {

	
	protected static ClienteDAO instancia = null;
	protected static SessionFactory sf = null;
	protected static Session session = null;
	
	public static ClienteDAO getInstancia()
	{
		if (instancia == null)
		{
			instancia = new ClienteDAO();
			sf = HibernateUtil.getSessionFactory();
		}
		
		return instancia;
	}
	
	
	//Crea  un cliente en DB
	public void crearCliente(Cliente cliente)
	{
		session = sf.openSession();
		session.beginTransaction();
		session.persist(cliente);
		session.getTransaction().commit();
		session.close();
	}
	
	
}
