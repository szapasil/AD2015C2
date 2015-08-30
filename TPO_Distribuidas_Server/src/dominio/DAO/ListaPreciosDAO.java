package dominio.DAO;

import java.util.Set;

import hbt.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dominio.ItemLP;
import dominio.ListaPrecios;

public class ListaPreciosDAO {

	protected static ListaPreciosDAO instancia = null;
	protected static SessionFactory sf = null;
	protected static Session session = null;
	
	public static ListaPreciosDAO getInstancia()
	{
		if (instancia == null)
		{
			instancia = new ListaPreciosDAO();
			sf = HibernateUtil.getSessionFactory();
		}
		
		return instancia;
	}
	
	public void cargarLista(ListaPrecios lp)
	{
		session = sf.openSession();
		session.beginTransaction();
		session.persist(lp);
		session.getTransaction().commit();
		session.close();
	}
	
	public void cargarItems(Set<ItemLP> items)
	{
		session = sf.openSession();
		session.beginTransaction();
		for (ItemLP item : items)
		{
			session.persist(item);
		}
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
}
