package dominio;

import hbt.HibernateDAO;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import dao.OrdenDeCompraDAO;
import entities.ItemOCENT;
import entities.OrdenDeCompraENT;

public class OrdenDeCompra {
	
	private int numero;
	private float montoTotal;
	private Proveedor proveedor;
	private Date fecha;
	private SolicitudDeCompra solicitudDeCompra;
	private List<ItemOC> items; 
	
	public OrdenDeCompra(Proveedor proveedor, Date fecha, SolicitudDeCompra solicitudDeCompra) {
		super();
		this.montoTotal = 0;
		this.proveedor = proveedor;
		this.fecha = fecha;
		this.solicitudDeCompra = solicitudDeCompra;
		this.items = new ArrayList<ItemOC>();
//		persistirse();
	}

	public OrdenDeCompra() {
		
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public float getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(float montoTotal) {
		this.montoTotal = montoTotal;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public SolicitudDeCompra getSolicitudDeCompra() {
		return solicitudDeCompra;
	}

	public void setSolicitudDeCompra(SolicitudDeCompra solicitudDeCompra) {
		this.solicitudDeCompra = solicitudDeCompra;
	}

	public List<ItemOC> getItems() {
		return items;
	}

	public void setItems(List<ItemOC> items) {
		this.items = items;
	}
	
	public void persistirse() {
		OrdenDeCompraENT ocENT = toENT();
		HibernateDAO.getInstancia().saveOrUpdate(ocENT);
	}

	public OrdenDeCompraENT toENT() {
		List<ItemOCENT> itemsENT = new ArrayList<ItemOCENT>();
		OrdenDeCompraENT ocENT = new OrdenDeCompraENT(numero, montoTotal, proveedor.toENT(), fecha, solicitudDeCompra.toENT());
		for(ItemOC item : items) {
			itemsENT.add(item.toENT(ocENT));
		}
		ocENT.setItems(itemsENT);
		return ocENT;
//		return new OrdenDeCompraENT(numero, montoTotal, proveedor.toENT(), fecha, solicitudDeCompra.toENT());
	}

	public void agregarItems(List<ItemSolCompra> itemsSC) {
		for(ItemSolCompra isc:itemsSC){
			ItemOC ioc = new ItemOC(isc.getRodamiento(), isc.getCantidad(), isc.getPrecio());
			montoTotal = montoTotal + isc.getPrecio();
			items.add(ioc);
		}
	}
		
	public void toXML() {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("OrdenDeCompra");
			doc.appendChild(rootElement);
			// numeroOC
			Element numeroOC = doc.createElement("numeroOC");
			numeroOC.appendChild(doc.createTextNode(String.valueOf(this.numero)));
			rootElement.appendChild(numeroOC);
			// idProveedor
			Element idProveedor = doc.createElement("idProveedor");
			idProveedor.appendChild(doc.createTextNode(this.getProveedor().getCuit()));
			rootElement.appendChild(idProveedor);
			// idSolCompra
			Element idSolCompra = doc.createElement("idSolCompra");
			idSolCompra.appendChild(doc.createTextNode(String.valueOf(this.getSolicitudDeCompra().getNumero())));
			rootElement.appendChild(idSolCompra);
			// fecha
			Element fecha = doc.createElement("fecha");
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			fecha.appendChild(doc.createTextNode(format.format((this.getFecha()))));
			rootElement.appendChild(fecha);
			// montoTotal
			Element montoTotal = doc.createElement("montoTotal");
			montoTotal.appendChild(doc.createTextNode(String.valueOf(this.getMontoTotal())));
			rootElement.appendChild(montoTotal);
			// detalle 
			{
				for (ItemOC itemOC : items) {
					// items elements
					Element item = doc.createElement("item");
					rootElement.appendChild(item);
					// codigoRodamiento
					Element codigoRodamiento = doc.createElement("codigoRodamiento");
					codigoRodamiento.appendChild(doc.createTextNode(itemOC.getRodamiento().getCodRodamiento()));
					item.appendChild(codigoRodamiento);
					// cantidad
					Element cantidad = doc.createElement("cantidad");
					cantidad.appendChild(doc.createTextNode(String.valueOf(itemOC.getCantidad())));
					item.appendChild(cantidad);
					// precio
					Element precio = doc.createElement("precio");
					precio.appendChild(doc.createTextNode(String.valueOf(itemOC.getPrecio())));
					item.appendChild(precio);
				}
			}
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("C:\\Eclipse EE\\OC" + String.valueOf(getNumero()) + ".xml"));
			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);
			transformer.transform(source, result);
			System.out.println("File saved!");
		  } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  }
	}

	public static OrdenDeCompra buscarOCDAO(int numero) {
		OrdenDeCompraENT ocENT = OrdenDeCompraDAO.getInstancia().BuscarOC(numero);
		if(ocENT!=null)
			return toDOM(ocENT);
		return null;
	}

	private static OrdenDeCompra toDOM(OrdenDeCompraENT ocENT) {
		OrdenDeCompra oc = new OrdenDeCompra();
		List<ItemOC> items = new ArrayList<ItemOC>();
		oc.setFecha(ocENT.getFecha());
		oc.setMontoTotal(ocENT.getMontoTotal());
		oc.setNumero(ocENT.getNumero());
		oc.setProveedor(Proveedor.toDOM(ocENT.getProveedor()));
		oc.setSolicitudDeCompra(SolicitudDeCompra.toDOM(ocENT.getSolicitudDeCompra()));
		for(ItemOCENT iocENT:ocENT.getItems())
			items.add(ItemOCENT.toDOM(iocENT));
		oc.setItems(items);
		return oc;
	}

}
