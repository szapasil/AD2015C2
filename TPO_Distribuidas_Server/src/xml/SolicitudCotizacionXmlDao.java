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

import dominio.ItemSolicitud;
import dominio.SolicitudCotizacion;
import dominio.DAO.SolicitudCotizacionDAO;

public class SolicitudCotizacionXmlDao {

	private static SolicitudCotizacionXmlDao instancia;
	private Document doc;
	private int nroSolicitud;
	
	
	public static SolicitudCotizacionXmlDao getInstancia()
	{
		if (instancia == null)
			instancia = new SolicitudCotizacionXmlDao();
		
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
	
	private SolicitudCotizacion recuperar()
	{
		SolicitudCotizacion sc = new SolicitudCotizacion();
		NodeList nList = doc.getElementsByTagName("SolicitudCotizacion");
		for (int i = 0; i < nList.getLength(); i++)
		{
			if (nList.item(i).hasChildNodes())
			{
				Element e = (Element) nList.item(i);
						
				sc.setNumero(Integer.parseInt(e.getAttribute("numero")));
				nroSolicitud = sc.getNumero();//
				sc.setCuilCliente(e.getElementsByTagName("Cuil").item(0).getTextContent());
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				String fecha = e.getAttribute("fecha");
				try {
					sc.setFechaEnviada(format.parse(fecha));
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				sc.setEstado("pendiente");
			}
		}
		return sc;
	}
		
	private void persistirItems(Set<ItemSolicitud> items)
	{
		SolicitudCotizacionDAO scdao = SolicitudCotizacionDAO.getInstancia();
		scdao.cargarItems(items);		
	}
	
	private void persistirSolicitud(SolicitudCotizacion sc)
	{
		SolicitudCotizacionDAO scdao = SolicitudCotizacionDAO.getInstancia();
		scdao.cargarSolicitud(sc);
	}
		
	public void guardarEnBD(String archivo)
	{
		crearDocumento(archivo);
		SolicitudCotizacion sc = recuperar();
		persistirSolicitud(sc); // MR0406 - El enunciado dice que se debe corroborar que los rodamientos ingresado sean validos
		guardarItemsEnBD(archivo);
	}
	
	public void guardarItemsEnBD(String archivo)
	{
		Set<ItemSolicitud> items = recuperarItems();
		persistirItems(items);
	}
	
	public Set<ItemSolicitud> recuperarItems()
	{
		Set<ItemSolicitud> items = new HashSet<ItemSolicitud>();
		NodeList nodos = doc.getElementsByTagName("Item");
	
		for(int i = 0; i < nodos.getLength(); i++)
		{
			if(nodos.item(i).hasChildNodes())
			{
				items.add(mapItemSolicitud((Element)nodos.item(i), nroSolicitud));
			}
		}
		return items;
	}
		
	private ItemSolicitud mapItemSolicitud(Element eleItem, int nroSolicitud) 
	{
		ItemSolicitud item = new ItemSolicitud();
		item.setSerie(eleItem.getAttribute("serie"));
		item.setSufijo((eleItem.getElementsByTagName("Sufijo").item(0).getTextContent()));
		item.setMarca((eleItem.getElementsByTagName("Marca").item(0).getTextContent()));
		item.setOrigen((eleItem.getElementsByTagName("Origen").item(0).getTextContent()));
		item.setCantidad((eleItem.getElementsByTagName("Cantidad").item(0).getTextContent()));
		item.setNroSolicitud(nroSolicitud);
		return item;
	}
}
