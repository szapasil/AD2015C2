package dominio.DAO;

import java.util.Set;

import hbt.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dominio.ItemSolicitud;
import dominio.SolicitudCotizacion;

public class SolicitudCotizacionDAO {

	protected static SolicitudCotizacionDAO instancia = null;
	protected static SessionFactory sf = null;
	protected static Session session = null;
	
	public static SolicitudCotizacionDAO getInstancia()
	{
		if (instancia == null)
		{
			instancia = new SolicitudCotizacionDAO();
			sf = HibernateUtil.getSessionFactory();
		}
		
		return instancia;
	}
	
	//Persiste los Items de la Solicitud:
	public void cargarItems(Set<ItemSolicitud> items)
	{
		session = sf.openSession();
		session.beginTransaction();
		for (ItemSolicitud item : items)
		{
			session.persist(item);
		}
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	//Persiste la Solicitud de Cotizacion:
	public void cargarSolicitud(SolicitudCotizacion sc)
	{
		session = sf.openSession();
		session.beginTransaction();
		session.persist(sc);
		session.getTransaction().commit();
		session.close();
	}

}
