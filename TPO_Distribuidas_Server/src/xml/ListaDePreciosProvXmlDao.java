package xml;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import dominio.ItemLP;
import dominio.ListaPrecios;
import dominio.DAO.ListaPreciosDAO;

public class ListaDePreciosProvXmlDao {

	private static ListaDePreciosProvXmlDao instancia;
	private Document doc;
	private int nroLista;
	private String cuilProv;
	
	public static ListaDePreciosProvXmlDao getInstancia()
	{
		if (instancia == null)
			instancia = new ListaDePreciosProvXmlDao();
		
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
	
	
	private ListaPrecios recuperar()
	{
		ListaPrecios lp = new ListaPrecios();
		NodeList nList = doc.getElementsByTagName("ListaPrecios");
		for (int i = 0; i < nList.getLength(); i++)
		{
			if (nList.item(i).hasChildNodes())
			{
				Element e = (Element) nList.item(i);
				lp.setNumero(Integer.parseInt(e.getAttribute("numero")));
				nroLista = lp.getNumero();
				lp.setTipo(e.getAttribute("tipo"));
				lp.setCuilProveedor(e.getElementsByTagName("Cuil").item(0).getTextContent());
				cuilProv = lp.getCuilProveedor();
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				String fechaPublicacion = e.getElementsByTagName("Fecha").item(0).getTextContent();
				String fechaHasta = e.getElementsByTagName("Termino").item(0).getTextContent();
				try {
					lp.setFecha(format.parse(fechaPublicacion));
					lp.setVigencia(format.parse(fechaHasta));				
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				//Falta: a que lista reemplaza, condiciones de venta, recargo y financiacion.
				
			}
		}
		return lp;
	}
	
	
	private void persistirLista(ListaPrecios lp)
	{
		ListaPreciosDAO lpdao = ListaPreciosDAO.getInstancia();
		lpdao.cargarLista(lp);
	}
	
	public void guardarEnBD(String archivo)
	{
		crearDocumento(archivo);
		ListaPrecios lp = recuperar();
		persistirLista(lp);
		guardarItemsEnBD(archivo);
	}
	
	
	public Set<ItemLP> recuperarItems()
	{
		Set<ItemLP> items = new HashSet<ItemLP>();
		NodeList nodos = doc.getElementsByTagName("Item");
	
		for(int i = 0; i < nodos.getLength(); i++)
		{
			if(nodos.item(i).hasChildNodes())
			{
				items.add(mapItemLP((Element)nodos.item(i), nroLista, cuilProv));
			}
		}
		return items;
	}
	 
	
	private ItemLP mapItemLP(Element eleItem, int nroLista, String cuilProv) 
	{
		ItemLP item = new ItemLP();
		// MR1006 - Reemplazo por codRodamiento 
		//item.setSerie(eleItem.getAttribute("serie"));
		//item.setSufijo((eleItem.getElementsByTagName("Sufijo").item(0).getTextContent()));
		//item.setMarca((eleItem.getElementsByTagName("Marca").item(0).getTextContent()));
		//item.setOrigen((eleItem.getElementsByTagName("Origen").item(0).getTextContent()));
		item.setCodRodamiento((eleItem.getElementsByTagName("CodRodamiento").item(0).getTextContent())); // --> hay que cambiar la BD
		item.setPrecio(Float.parseFloat(eleItem.getElementsByTagName("Precio").item(0).getTextContent()));
		item.setStock(Integer.parseInt(eleItem.getElementsByTagName("Stock").item(0).getTextContent()));
		item.setNroLista(nroLista);
		item.setCuilProv(cuilProv);
		return item;
	}
	
	private void persistirItems(Set<ItemLP> items)
	{
		ListaPreciosDAO lpdao = ListaPreciosDAO.getInstancia();
		lpdao.cargarItems(items);		
	}
	
	public void guardarItemsEnBD(String archivo)
	{
		Set<ItemLP> items = recuperarItems();
		persistirItems(items);
	}
	
}
