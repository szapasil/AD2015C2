package hbt;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	
    private static final SessionFactory sessionFactory;
    static
    {
        try
        {
        	 AnnotationConfiguration config = new AnnotationConfiguration();
        	 config.addAnnotatedClass(app.ODV.class);
        	 config.addAnnotatedClass(dominio.Cliente.class);
        	 config.addAnnotatedClass(dominio.Cotizacion.class);
        	 config.addAnnotatedClass(dominio.Factura.class);
        	 config.addAnnotatedClass(dominio.ItemCotizacion.class);
        	 config.addAnnotatedClass(dominio.ItemFactura.class);
        	 config.addAnnotatedClass(dominio.ItemLC.class);
        	 config.addAnnotatedClass(dominio.ItemLP.class);
        	 config.addAnnotatedClass(dominio.ItemOC.class);
        	 config.addAnnotatedClass(dominio.ItemOP.class);
        	 config.addAnnotatedClass(dominio.ItemRemito.class);
        	 config.addAnnotatedClass(dominio.ItemSC.class);
        	 config.addAnnotatedClass(dominio.ItemSolicitud.class);
        	 config.addAnnotatedClass(dominio.ListaComp.class);
        	 config.addAnnotatedClass(dominio.ListaPrecios.class);
             config.addAnnotatedClass(dominio.SolicitudCotizacion.class);
             config.addAnnotatedClass(dominio.Marca.class);
             config.addAnnotatedClass(dominio.OrdenDeCompra.class);
             config.addAnnotatedClass(dominio.OrdenDePedido.class);
             config.addAnnotatedClass(dominio.Proveedor.class);
             config.addAnnotatedClass(dominio.Remito.class);
             config.addAnnotatedClass(dominio.Rodamiento.class);
             config.addAnnotatedClass(dominio.SolicitudCotizacion.class);
             config.addAnnotatedClass(dominio.SolicitudDeCompra.class);
             config.addAnnotatedClass(dominio.Venta.class);
        	 sessionFactory = config.buildSessionFactory();
        }
        catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static Session getSession()throws HibernateException {
    	return sessionFactory.openSession();
    }
 
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
