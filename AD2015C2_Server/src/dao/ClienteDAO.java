package dao;

import hbt.HibernateUtil;

import org.hibernate.Query;
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
	
	
	// Crea  un cliente en DB
	public void crearCliente(Cliente cliente)
	{
		session = sf.openSession();
		session.beginTransaction();
		session.persist(cliente);
		session.getTransaction().commit();
		session.close();
	}
	
	// Busca un cliente en DB por su CUIL
	public Cliente BuscarCliente(String cuil) {
		session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM CLIENTES WHERE cuil = :cuil");
		query.setString("cuil", cuil);
		Cliente cli = (Cliente) query.uniqueResult();
		session.close();
		return cli;
	}
	
	
	public void bajaCliente(String cuil)
	{
		session = sf.openSession();
		session.beginTransaction();
		session.createQuery("DELETE FROM CLIENTES WHERE cuil = ?").setString(0, cuil).executeUpdate();
		session.getTransaction().commit();
		session.close();
		
	}
	
	public void modificarCliente(String cuil, String razsoc, String direccion)
	{
		session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("UPDATE FROM CLIENTES  set razonSocial = ?, direccion = ? where cuil = ?");
		query.setString(0, razsoc);
		query.setParameter(1, direccion);
		query.setParameter(2, cuil);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}

	
}
