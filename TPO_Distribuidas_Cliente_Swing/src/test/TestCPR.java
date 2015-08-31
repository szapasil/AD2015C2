package test;

import delegado.BusinessDelegateCPR;

public class TestCPR {


	public static void main(String[] args) 
	{
		
		BusinessDelegateCPR bdCPR = new BusinessDelegateCPR();
		bdCPR.LookupServiceCPR();
		
		//----------------------------------------------------------------------------------------//
		/*
		 * Administrar cartera de proveedores:
		 * Entrada: el ingreso de los datos de un proveedor es manual por parte del operador
		 * de la aplicacion o desde xml.
		 */
		
		//CARGA DE PROVEEDORES DESDE ARCHIVO XML:
		bdCPR.cargaDeProveedoresDesdeXML("ListaProveedores.xml");
		
		//CARGA DE UN PROVEEDOR:
		bdCPR.altaProveedor("Manwe", "Piedras 400", "20-28456543-6", "condicion 2", (float) 0.2, "sin condiciones");
		
		//MODIFICAR UN PROVEEDOR:
		bdCPR.modificarProveedor("Sulimo", "Valinor", "20-28456543-6", "nueva condicion", 2, "sin condicion", "activo");
		
		//BAJA DE UN PROVEEDOR:
		bdCPR.bajaProveedor("20-28456543-6");
		
		//-----------------------------------------------------------------------------------------//
		/*
		 * Administrar listas de precios de proveedores:
		 * Entrada: archivo de texto (formato xml) describiendo los items que compone la lista de
		 * precios. Puede incluir descuentos y/o recargos sobre los precios de lista.
		 */
		
		//CARGA DE UNA LISTA DE PRECIOS DESDE UN ARCHIVO XML:
		bdCPR.cargarListaDePreciosXML("ListaPreciosProveedor.xml");
		bdCPR.cargarListaDePreciosXML("ListaPreciosProveedor_2.xml");
		//Todavia no carga los datos de: reemplazo y condiciones de venta porque los tengo que ver mejor
		//pero el resto si.
		
		//-----------------------------------------------------------------------------------------//
		/*
		 * Armar una lista comparativa en base a todas las listas de proveedores cargadas.
		 * (En realidad no entiendo cual sería la diferencia entre esto y lo que se arma en la BD
		 * que es la tabla con los Items de las listas de precios de todos los proveedores.)
		 */
		
		bdCPR.generarListaComparativa();
	}

}
