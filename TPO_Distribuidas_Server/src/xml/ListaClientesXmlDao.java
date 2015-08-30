package xml;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import dominio.Cliente;
import dominio.DAO.ClienteDAO;


public class ListaClientesXmlDao {

	private static ListaClientesXmlDao instancia;
	private Document doc;
	
	public static ListaClientesXmlDao getInstancia()
	{
		if(instancia == null){
			instancia = new ListaClientesXmlDao();

		}
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
	

	public List<Cliente> recuperarClientes()
	{
		List<Cliente> items = new ArrayList<Cliente>();
		NodeList nodos = doc.getElementsByTagName("Cliente");
		for(int i = 0; i < nodos.getLength(); i++){
			if(nodos.item(i).hasChildNodes()){
				items.add(mapCliente((Element)nodos.item(i)));
			
			}
		}
		
		return items;
	}
	
	private Cliente mapCliente(Element eleItem) 
	{
		Cliente cliente = new Cliente();
		cliente.setCuil(eleItem.getElementsByTagName("Cuil").item(0).getTextContent());
		cliente.setDireccion(eleItem.getElementsByTagName("Direccion").item(0).getTextContent());
		String fechaReg = eleItem.getElementsByTagName("Fecha").item(0).getTextContent();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			cliente.setFechaRegistrado(format.parse(fechaReg));
		} catch (ParseException e) {
			System.out.println("Problema con la fecha");
			e.printStackTrace();
		}
		cliente.setMontoTotal(Float.parseFloat(eleItem.getElementsByTagName("Monto").item(0).getTextContent()));
		cliente.setRazonSocial(eleItem.getElementsByTagName("Razon").item(0).getTextContent());
			
		return cliente;
		
	}
	
	//Carga la BD con los clientes del xml.
	private void persistirClientes(List<Cliente> clientes)
	{
		ClienteDAO cdao = ClienteDAO.getInstancia();
		cdao.cargarClientes(clientes);		
	}
	
	public void guardarEnBD(String archivo)
	{
		crearDocumento(archivo);
		List<Cliente> clientesLista = recuperarClientes();
		persistirClientes(clientesLista);
	}
	
	
}
