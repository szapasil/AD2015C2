package dominio.DAO;

import java.util.List;

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
	
	
	//Guardar una lista de clientes
	//Le llega la lista leida del xml y la persiste en la bd
	public void cargarClientes(List<Cliente> clientes)
	{
		session = sf.openSession();
		session.beginTransaction();
		for (Cliente c : clientes)
		{
			session.persist(c);
		}
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	//Guardar un cliente
	public void cargarCliente(Cliente cliente)
	{
		session = sf.openSession();
		session.beginTransaction();
		session.persist(cliente);
		session.getTransaction().commit();
		session.close();
	}
	
	public void bajaCliente(String cuil)
	{
		session = sf.openSession();
		session.beginTransaction();
		session.createQuery("delete from Cliente where cuil = ?").setString(0, cuil).executeUpdate();
		session.getTransaction().commit();
		session.close();
		
	}
	
	public void modificarCliente(String cuil, String razsoc, float monto, String direccion)
	{
		session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("update from Cliente set razonSocial = ?, montoTotal = ?, direccion = ? where cuil = ?");
		query.setString(0, razsoc);
		query.setFloat(1, monto);
		query.setParameter(2, direccion);
		query.setParameter(3, cuil);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}

	public Cliente BuscarCliente(String cuil) {
		session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Cliente where cuil = :cuil");
		query.setString("cuil", cuil);
		Cliente cli = (Cliente) query.uniqueResult();
		session.close();
		return cli;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> recuperarClientes(){
		session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Cliente");
		List<Cliente> cliList = query.list();
		session.close();
		return cliList;
	}
	
}
