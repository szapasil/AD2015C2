package hbt;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	
    private static final SessionFactory sessionFactory;
    static {
        try {
        	 AnnotationConfiguration config = new AnnotationConfiguration();
        	 config.addAnnotatedClass(entities.ClienteENT.class);
        	 config.addAnnotatedClass(entities.CondCompraENT.class);
        	 config.addAnnotatedClass(entities.CondCompraProvENT.class);
        	 config.addAnnotatedClass(entities.ItemLPENT.class);
        	 config.addAnnotatedClass(entities.ItemSolCompraENT.class);
        	 config.addAnnotatedClass(entities.ListaPreciosENT.class);
        	 config.addAnnotatedClass(entities.ProveedorENT.class);
        	 config.addAnnotatedClass(entities.RodamientoENT.class);
        	 config.addAnnotatedClass(entities.CondPagoENT.class);
        	 config.addAnnotatedClass(entities.SolicitudCotizacionENT.class);
        	 config.addAnnotatedClass(entities.ItemSolCotizacionENT.class);
        	 config.addAnnotatedClass(entities.ItemSolCotizacionENTpk.class);
        	 //        	 config.addAnnotatedClass(entities.ListaComparativaENT.class);
        	 config.addAnnotatedClass(entities.ItemLCENT.class);
        	 config.addAnnotatedClass(entities.CotizacionENT.class);
        	 config.addAnnotatedClass(entities.ItemCotizacionENT.class);
        	 config.addAnnotatedClass(entities.ItemCotizacionENTpk.class);
        	 config.addAnnotatedClass(entities.OrdenDePedidoENT.class);
        	 config.addAnnotatedClass(entities.ItemOPENT.class);
        	 config.addAnnotatedClass(entities.ItemOPENTpk.class);
        	 config.addAnnotatedClass(entities.FacturaENT.class);
        	 config.addAnnotatedClass(entities.ItemFacturaENT.class);
        	 config.addAnnotatedClass(entities.ItemFacturaENTpk.class);
        	 config.addAnnotatedClass(entities.RemitoENT.class);
        	 config.addAnnotatedClass(entities.ItemRemitoENT.class);
        	 config.addAnnotatedClass(entities.ItemRemitoENTpk.class);
        	 config.addAnnotatedClass(entities.SolicitudDeCompraENT.class);
        	 config.addAnnotatedClass(entities.ItemSolCompraENT.class);
        	 config.addAnnotatedClass(entities.ItemSolCompraENTpk.class);
        	 config.addAnnotatedClass(entities.OVENT.class);
        	 sessionFactory = config.buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static Session getSession()throws HibernateException {
    	return sessionFactory.openSession();
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
}
