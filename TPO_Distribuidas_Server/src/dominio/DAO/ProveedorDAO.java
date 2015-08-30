package dominio.DAO;

import hbt.HibernateUtil;

import java.util.List;

import org.hibernate.Query;
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
	
	@SuppressWarnings("unchecked")
	public List<Proveedor> listaDeProveedores() 
	{
		Session session = sf.openSession();
		List<Proveedor> lista = session.createQuery("from Proveedor").list();
		return lista;
	}
	
	public void grabarProveedores(List<Proveedor> proveedores)
	{
		Session session = sf.openSession();
		session.beginTransaction();
		for(Proveedor p:proveedores){
			session.persist(p);
		}
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	
	public void cargarProveedor(Proveedor proveedor)
	{
		Session session = sf.openSession();
		session.beginTransaction();
		session.persist(proveedor);
		session.getTransaction().commit();
		session.close();
	}
	
	public void modificarProveedor(String cuil, String razsoc, float descuento, String direccion, String condPago, String condCompra, String estado)
	{
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("update from Proveedor set razonSocial = ?, descuento = ?, direccion = ?, condicionesPago = ?, condicionesCompra = ?, estado = ? where cuil = ?");
		query.setString(0, razsoc);
		query.setFloat(1, descuento);
		query.setString(2, direccion);
		query.setString(3, condPago);
		query.setString(4, condCompra);
		query.setString(5, estado);
		query.setString(6, cuil);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}
	
	public void bajaProveedor(String cuil)
	{
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("update from Proveedor set estado = ? where cuil = ?");
		query.setString(0, "inactivo");
		query.setString(1, cuil);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}
	
	public Proveedor BuscarProveedor(String cuil) {
		session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Proveedor where cuil = :cuil");
		query.setString("cuil", cuil);
		Proveedor cli = (Proveedor) query.uniqueResult();
		session.close();
		return cli;
	}
	
	@SuppressWarnings("unchecked")
	public List<Proveedor> recuperarProveedors(){
		session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Proveedor");
		List<Proveedor> cliList = query.list();
		session.close();
		return cliList;
	}

}
