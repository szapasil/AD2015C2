package dao;

import hbt.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dominio.ItemLP;
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
	
	public void modificarItemLC(ItemLPENT ilp) {
		session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("update from ItemLCENT set precio = ?, stock = ?, condCompra = ?, bonificacion = ?"
											+ " where codRodamiento = ?");
		query.setFloat(0, ilp.getPrecio());
		query.setInteger(1, ilp.getStock());
		query.setInteger(2, ilp.getCondcompra());
		query.setInteger(3, ilp.getBonificacion());
		query.setString(4, ilp.getRodamiento().getCodRodamiento());
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}
}
