package dominio.DAO;

import hbt.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dominio.ItemLC;
import dominio.ItemLP;
import dominio.ListaComp;
import dominio.ListaPrecios;

public class ListaComparativaDAO {

	protected static ListaComparativaDAO instancia = null;
	protected static SessionFactory sf = null;
	protected static Session session = null;
	
	public static ListaComparativaDAO getInstancia()
	{
		if (instancia == null)
		{	
			instancia = new ListaComparativaDAO();
			sf = HibernateUtil.getSessionFactory();
		}
		
		return instancia;
	}
	
	public void crearLista()
	{
		session = sf.openSession();
		session.beginTransaction();
		ListaComp lc = new ListaComp();
		session.persist(lc);
		//genero la tabla ListaComparativa: id y fecha.
		session.getTransaction().commit();
		session.close();
		//genero la tabla ItemLC:
		crearItemsLista();
	}
	
	@SuppressWarnings("unchecked")
	public void crearItemsLista() {
		session = sf.openSession();
		session.beginTransaction();
		List<ListaPrecios> listasP = new ArrayList<ListaPrecios>();
		listasP = session.createQuery("from ListaPrecios").list();
		for (int i = 0; i < listasP.size(); i++) {
			ListaPrecios lp = new ListaPrecios();
			lp = listasP.get(i);						
			List<ItemLP> items = new ArrayList<ItemLP>();
			items = lp.getItems(); 
			for (int j = 0; j < items.size(); j++) {
				ItemLP ilp = items.get(j);
				ItemLC ilc = new ItemLC(ilp.getRodamiento(),ilp.getPrecio(),ilp.getDescuento(),ilp.getCondiciones(),ilp.getStock(),lp.getProveedor());
				session.persist(ilc);	
			}
		}
		session.getTransaction().commit();
		session.close();
	}

	// MR1206
	public void updateItemLC(ListaPrecios lp,ItemLP ilp) {
		session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("update from ListaComparativa set precio = ?, descuento = ?," +
											"condiciones = ?, stock = ?, cuilProv = ? where codRodamiento = ?");
		query.setFloat(0,ilp.getPrecio());
		query.setFloat(1,ilp.getDescuento());
		query.setString(2,ilp.getCondiciones());
		query.setInteger(3,ilp.getStock());
		query.setString(4,lp.getProveedor().getCuil());
		query.setParameter(5,ilp.getRodamiento().getCodRodamiento());
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}

	// MR1206
	public void insert(ItemLC iLC) {
		session = sf.openSession();
		session.beginTransaction();
		session.save(iLC); // MR1206 - Funciona asi???? Probar...
		session.getTransaction().commit();
		session.close();
	}

}
