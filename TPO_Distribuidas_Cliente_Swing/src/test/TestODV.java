package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import delegado.BusinessDelegateODV;

public class TestODV {

	
	public static void main(String[] args) {
	
		BusinessDelegateODV bdODV = new BusinessDelegateODV();
		bdODV.LookupServiceODV();
		
		//-----------------------------------------------------------------------------------------//
		/*
		 * Administracion de clientes:
		 * Entrada: el ingreso de los datos de clientes es realizado de manera manual por medio
		 * de una interfaz grafica por parte del operador de la aplicacion de la oficina de venta
		 * o por medio de un archivo xml, en ambos casos debe persistirse en la base de datos.
		 */
		
		//CARGA CLIENTES DEL ARCHIVO XML:
		bdODV.cargaDeClientesDesdeXML("ListaClientes.xml");
		
		//CARGA UN CLIENTE:
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    	String fecha = "27/05/2015";
		try {
			bdODV.cargarUnCliente("0005", "Maglor", format.parse(fecha), 0, "Maglor's Gap");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//MODIFICA DATOS DE UN CLIENTE:
		bdODV.actualizarUnCliente("0004", "Makalaure", 0, "Himring");
		
		//DA DE BAJA UN CLIENTE:
		bdODV.bajaDeUnCliente("0004");
		
		//-------------------------------------------------------------------------------------//
		
		/* Recepcion de solicitudes de cotizacion de rodamientos:
		 * Entrada: documento xml.
		 * Salida: la solicitud de cotizacion ingresada debe persistirse en la Base de Datos
		 * administrada por la CPR.
		 */
		
		//GUARDA UNA SOLICITUD Y SUS ITEMS EN LA BD:
		bdODV.cargarSolicitudDesdeXML("Solicitud_Cotizacion.xml");
			
	

	}

}
