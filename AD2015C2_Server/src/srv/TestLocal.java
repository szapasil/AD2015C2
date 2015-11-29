package srv;

import java.rmi.RemoteException;
import java.text.ParseException;
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
/*			
			CC.getInstancia().altaRodamiento("RSA0001", "ZKL", "USA", "Bolilla", "1x3", "SFK2502");
			CC.getInstancia().altaRodamiento("RSA0002", "ZKL", "USA", "Rodillo", "1x3", "SFK2503");
			CC.getInstancia().altaRodamiento("RSA0003", "ZKL", "USA", "Rodillo", "1x3", "SFK2504");
			CC.getInstancia().altaRodamiento("RSA0004", "ZKL", "USA", "Rodillo", "1x3", "SFK2504");
			CC.getInstancia().altaRodamiento("RSA0005", "ZKL", "USA", "Rodillo", "1x3", "SFK2504");
			CC.getInstancia().altaRodamiento("RSA0006", "ZKL", "USA", "Rodillo", "1x3", "SFK2504");
			CC.getInstancia().altaRodamiento("RSA0007", "ZKL", "USA", "Rodillo", "1x3", "SFK2504");
			Rodamiento r = Rodamiento.buscarRodamientoDAO("RSA0001");
			LOG (r.getCodSFK());
			
			//ALTA OV
			LOG ("ALTA OV >>>");
			CC.getInstancia().altaOV("Sucursal1");
			CC.getInstancia().altaOV("Sucursal2");
			
			//ALTA CLIENTE
			LOG ("ALTA CLIENTE >>>");
			CC.getInstancia().getInstanciaOV("Sucursal1").altaCliente("20-30000002-6", "Gaston R", " Oro 1800");
			Cliente c = CC.getInstancia().getInstanciaOV("Sucursal1").buscarCliente("20-30000002-6");
			
			//ALTA SOLICITUD COTIZACION
			LOG ("ALTA SOLICITUD COTIZACION >>>");
			CC.getInstancia().getInstanciaOV("Sucursal1").altaSolicitudCotizacion(1000, Calendar.getInstance().getTime(),	"20-30000002-6");
			OV ov =CC.getInstancia().getInstanciaOV("Sucursal1");
			SolicitudCotizacion sc = ov.buscarSolicitudCotizacion(1000);
			//AGREGAR ITEMS A SOLICITUD COTIZACION
			sc.agregarItemSolicitud("RSA0001", 1);
			sc.agregarItemSolicitud("RSA0002", 2);
			sc.agregarItemSolicitud("RSA0003", 3);
			
			sc.persistirse();
			sc.agregarItemSolicitud("RSA0004", 1);
			sc.agregarItemSolicitud("RSA0005", 2);
			sc.agregarItemSolicitud("RSA0006", 3);
			sc.persistirse();
			LOG ("ALTA SOLICITUD COTIZACION >>>");
			CC.getInstancia().getInstanciaOV("Sucursal1").altaSolicitudCotizacion(2000, Calendar.getInstance().getTime(),	"20-30000002-6");
			SolicitudCotizacion sc2 = ov.buscarSolicitudCotizacion(2000);
			sc2.agregarItemSolicitud("RSA0001", 1);
			sc2.agregarItemSolicitud("RSA0004", 2);
			sc2.agregarItemSolicitud("RSA0006", 3);
			sc2.persistirse();
			sc.toXML("PRUEBA1");
			
			SolicitudCotizacion sc3 = SolicitudCotizacion.fromXML("D:\\test\\PRUEBA1.xml", ov);
			LOG (String.valueOf(sc3.getNumero()));
			LOG ("FIN >>>");
*/			

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
		}
	}

	// SILVIO INICIO >>>
	public static void LOG(String TEXTO){
		System.out.println(TEXTO);
	}
	// SILVIO FIN <<<									
}