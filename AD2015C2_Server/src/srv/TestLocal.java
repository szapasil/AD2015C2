package srv;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import dominio.Cliente;
import dominio.Rodamiento;
import dominio.SolicitudCotizacion;
import app.CC;
import app.OV;

public class TestLocal {

	public static void main(String[] args) throws ParseException {

		LOG ("Inicio");
		//ALTA RODAMIENTO
//		LOG ("ALTA RODAMIENTO >>>");s
		try {
			//ALTA OV
			LOG ("ALTA OV >>>");
			CC.getInstancia().altaOV(1, "Sucursal1");
			CC.getInstancia().altaOV(2, "Sucursal2");
			
			
			//ALTA CLIENTE
			LOG ("ALTA CLIENTE >>>");

			OV ov1 = CC.getInstancia().getInstanciaOV(1);
			
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date parsed;
			parsed = format.parse("30/11/2015");
			Date fecha = new java.sql.Date(parsed.getTime());
			
			ov1.altaCliente("Gaston R0", " Oro 1800", "20-00000002-0", "Inscripto", "Contado", 20, fecha);
			ov1.altaCliente("Gaston R1", " Oro 1800", "20-10000002-1", "Inscripto", "Contado", 20, fecha);
			ov1.altaCliente("Gaston R2", " Oro 1800", "20-20000002-2", "Inscripto", "Contado", 20, fecha);
			ov1.altaCliente("Gaston R3", " Oro 1800", "20-30000002-3", "Inscripto", "Contado", 20, fecha);
			ov1.altaCliente("Gaston R4", " Oro 1800", "20-40000002-4", "Inscripto", "Contado", 20, fecha);
			
			OV ov2 = CC.getInstancia().getInstanciaOV(2);
			
			ov2.altaCliente("Martin R0", " Oro 1800", "30-00000002-0", "No Inscripto", "30 dias", 20, fecha);
			ov2.altaCliente("Martin R1", " Oro 1800", "30-10000002-1", "No Inscripto", "30 dias", 20, fecha);
			ov2.altaCliente("Martin R2", " Oro 1800", "30-20000002-2", "No Inscripto", "30 dias", 20, fecha);
			ov2.altaCliente("Martin R3", " Oro 1800", "30-30000002-3", "No Inscripto", "60 dias", 20, fecha);
			ov2.altaCliente("Martin R4", " Oro 1800", "30-40000002-4", "No Inscripto", "60 dias", 20, fecha);

			
			//Cliente c1 = CC.getInstancia().getInstanciaOV(1).buscarCliente("20-30000002-6");
			//Cliente c2 = CC.getInstancia().getInstanciaOV(1).buscarCliente("30-00000002-0");
			//LOG(c2.getRazonSocial());
		
			
			CC.getInstancia().altaRodamiento("RSA0001", "ZKL", "USA", "Bolilla", "1x3", "SFK2502");
			CC.getInstancia().altaRodamiento("RSA0002", "ZKL", "USA", "Rodillo", "1x3", "SFK2503");
			CC.getInstancia().altaRodamiento("RSA0003", "ZKL", "USA", "Rodillo", "1x3", "SFK2504");
			CC.getInstancia().altaRodamiento("RSA0004", "ZKL", "USA", "Rodillo", "1x3", "SFK2504");
			CC.getInstancia().altaRodamiento("RSA0005", "ZKL", "USA", "Rodillo", "1x3", "SFK2504");
			CC.getInstancia().altaRodamiento("RSA0006", "ZKL", "USA", "Rodillo", "1x3", "SFK2504");
			CC.getInstancia().altaRodamiento("RSA0007", "ZKL", "USA", "Rodillo", "1x3", "SFK2504");
			Rodamiento r = Rodamiento.buscarRodamientoDAO("RSA0001");
			LOG (r.getCodSFK());
			
				
			
			//ALTA CLIENTE
			//Cliente c3 = CC.getInstancia().getInstanciaOV(2).buscarCliente("30-40000002-4");
			
			//ALTA SOLICITUD COTIZACION
			LOG ("ALTA SOLICITUD COTIZACION >>>");
			SolicitudCotizacion sc = CC.getInstancia().getInstanciaOV(2).altaSolicitudCotizacionFromClient(1100, Calendar.getInstance().getTime(),	"30-40000002-4");
			//OV ov21 =CC.getInstancia().getInstanciaOV(2);
			//SolicitudCotizacion sc = ov21.buscarSolicitudCotizacion(1000);
			//AGREGAR ITEMS A SOLICITUD COTIZACION
			sc.agregarItemSolicitud("RSA0001", 1);
			sc.agregarItemSolicitud("RSA0002", 2);
			sc.agregarItemSolicitud("RSA0003", 3);
			
			sc.persistirse();
			sc.agregarItemSolicitud("RSA0004", 1);
			sc.agregarItemSolicitud("RSA0005", 2);
			sc.agregarItemSolicitud("RSA0006", 3);
			sc.toXML("PRUEBA1");

			LOG ("ALTA SOLICITUD COTIZACION >>>");
			SolicitudCotizacion sc2 = CC.getInstancia().getInstanciaOV(1).altaSolicitudCotizacionFromClient(2100, Calendar.getInstance().getTime(),	"20-00000002-0");
			//OV ov11 =CC.getInstancia().getInstanciaOV(1);
			//SolicitudCotizacion sc2 = ov11.buscarSolicitudCotizacion(2000);
			sc2.agregarItemSolicitud("RSA0001", 1);
			sc2.agregarItemSolicitud("RSA0004", 2);
			sc2.agregarItemSolicitud("RSA0006", 3);
			sc2.toXML("PRUEBA2");

			
			SolicitudCotizacion sc3 = SolicitudCotizacion.fromXML("D:\\test\\PRUEBA1.xml", CC.getInstancia().getInstanciaOV(1));
			LOG (String.valueOf(sc3.getNumero()));
			LOG ("FIN >>>");

	 		//ALTA PROVEEDOR
			CC.getInstancia().altaProveedor("30-00000001-9", "Rodamientos S.A.", "Rivadavia 4545");
			CC.getInstancia().altaProveedor("30-00000002-9", "Rodamientos Malos", "Av. San Juan 2331");
		
			//BAJA PROVEEDOR
//			CC.getInstancia().bajaProveedor("30-00000002-9");
			
			//MODIFICAR PROVEEDOR
//			CC.getInstancia().modificarProveedor("30-00000002-9", "", "Av. San Juan 2333");
	  		
			//BUSCAR PROVEEDOR
//			ProveedorENT provEnt = ProveedorDAO.getInstancia().BuscarProveedor("30-00000001-9");
//			System.out.println(provEnt.getDireccion());
	
			//ALTA RODAMIENTO
			CC.getInstancia().altaRodamiento("RSA0001", "ZKL", "USA", "Bolilla", "1x3", "SFK2502");
			CC.getInstancia().altaRodamiento("RSA0002", "ZKL", "USA", "Rodillo", "1x3", "SFK2503");
					
		
			//BAJA RODAMIENTO
//			CC.getInstancia().bajaRodamiento("RSA0001");
			
			//MODIFICAR RODAMIENTO
//			CC.getInstancia().modificarRodamiento("RSA0002", "", "", "", "2x4", "");
			
			//ALTA LISTA DE PRECIOS
			CC.getInstancia().altaListaPrecios("ListaPrecios1001.xml");
			CC.getInstancia().altaListaPrecios("ListaPrecios2001.xml"); 		

			//ALTA LISTA COMPARATIVA
//			CC.getInstancia().altaListaComp();	
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// SILVIO INICIO >>>
	public static void LOG(String TEXTO){
		System.out.println(TEXTO);
	}
	// SILVIO FIN <<<									
}