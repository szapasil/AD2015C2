package dao;

import java.util.List;

import hbt.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dominio.ListaPrecios;
import entities.ItemLCENT;
import entities.ItemLPENT;
import entities.ListaPreciosENT;

public class ItemLCDAO {

	protected static ItemLCDAO instancia = null;
	protected static SessionFactory sf = null;
	protected static Session session = null;
	
	public static ItemLCDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new ItemLCDAO();
		} 
		return instancia;
	}
	
	public void modificarItemLC(ItemLPENT ilp,ListaPreciosENT lp) {
		session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("update from ItemLCENT set precio = ?, stock = ?, condCompra = ?, bonificacion = ?,"
											+ " cuitProveedor = ? where codRodamiento = ?");
		query.setFloat(0, ilp.getPrecio());
		query.setInteger(1, ilp.getStock());
		query.setInteger(2, ilp.getCondcompra());
		query.setInteger(3, ilp.getBonificacion());
		query.setString(4, lp.getProveedor().getCuit());
		query.setString(5, ilp.getId().getRodamiento().getCodRodamiento());
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}

	public ItemLCENT buscarItem(String codRodamiento) {
		session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from ItemLCENT item where item.codRodamiento = :codRodamiento");
		query.setString("codRodamiento", codRodamiento);
		ItemLCENT ilcENT = (ItemLCENT) query.uniqueResult();
		session.flush();
		session.close();
		return ilcENT;
	}

	@SuppressWarnings("unchecked")
	public List<ItemLCENT> obtenerItems() {
		session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from ItemLCENT");
		List<ItemLCENT> lista = query.list();
		session.flush();
		session.close();
		return lista;
	}
}
