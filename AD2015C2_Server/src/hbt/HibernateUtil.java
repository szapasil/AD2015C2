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
//        	 config.addAnnotatedClass(entities.CondCompraENT.class);
        	 config.addAnnotatedClass(entities.CondCompraProvENT.class);
        	 config.addAnnotatedClass(entities.ItemLPENT.class);
        	 config.addAnnotatedClass(entities.ItemSCENT.class);
        	 config.addAnnotatedClass(entities.ListaPreciosENT.class);
        	 config.addAnnotatedClass(entities.ProveedorENT.class);
        	 config.addAnnotatedClass(entities.RodamientoENT.class);
        	 config.addAnnotatedClass(entities.CondPagoENT.class);
        	 config.addAnnotatedClass(entities.ListaCompENT.class);
        	 config.addAnnotatedClass(entities.ItemLCENT.class);
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
