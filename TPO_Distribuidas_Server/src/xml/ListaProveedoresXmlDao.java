package xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import dominio.Proveedor;
import dominio.DAO.ProveedorDAO;

public class ListaProveedoresXmlDao {

	private static ListaProveedoresXmlDao instancia;
	private Document doc;
	
	
	public static ListaProveedoresXmlDao getInstancia()
	{
		if (instancia == null)
			instancia = new ListaProveedoresXmlDao();
		
		return instancia;
	}
	
	private void crearDocumento(String archivo)
	{

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try 
		{
			builder = factory.newDocumentBuilder();
			doc = builder.parse(archivo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Proveedor> recuperarProveedores()
	{
		List<Proveedor> provs = new ArrayList<Proveedor>();
		NodeList nodos = doc.getElementsByTagName("Proveedor");
		for(int i = 0; i < nodos.getLength(); i++){
			if(nodos.item(i).hasChildNodes()){
				provs.add(mapProveedor((Element)nodos.item(i)));
			}
		}
		
		return provs;
	}
	
	private Proveedor mapProveedor(Element ele) 
	{
		Proveedor proveedor = new Proveedor();
		proveedor.setCuil(ele.getAttribute("cuil"));
		proveedor.setCondicionesCompra(ele.getElementsByTagName("condiciones_compra").item(0).getTextContent());
		proveedor.setCondicionesPago(ele.getElementsByTagName("condiciones_pago").item(0).getTextContent());
		proveedor.setDescuento(Float.parseFloat(ele.getElementsByTagName("descuento").item(0).getTextContent()));
		proveedor.setDireccion(ele.getElementsByTagName("direccion").item(0).getTextContent());
		proveedor.setEstado(ele.getElementsByTagName("estado").item(0).getTextContent());
		proveedor.setRazonSocial(ele.getElementsByTagName("razon_social").item(0).getTextContent());
		return proveedor;
		
	}
	
	private void persistirProveedores(List<Proveedor> proveedores)
	{
		ProveedorDAO pdao = ProveedorDAO.getInstancia();
		pdao.grabarProveedores(proveedores);		
	}
	
	public void guardarEnBD(String archivo)
	{
		crearDocumento(archivo);
		List<Proveedor> proveedoresLista = recuperarProveedores();
		persistirProveedores(proveedoresLista);
	}
	
}
