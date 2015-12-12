package dao;

import hbt.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.OVENT;

public class OVDAO {
	protected static OVDAO instancia = null;
	protected static SessionFactory sf = null;
	protected static Session session = null;
	
	public static OVDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new OVDAO();
		} 
		return instancia;
	}
	
	public OVENT BuscarOV(int nroSucursal) {
		session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from OVENT ov  where ov.numeroSucursal = :numeroSucursal");
		query.setInteger("numeroSucursal", nroSucursal);
		OVENT ovENT = (OVENT) query.uniqueResult();
		session.flush();
		session.close();
		return ovENT;
	}	
	
}