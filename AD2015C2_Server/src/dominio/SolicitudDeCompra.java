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

import app.OV;
import dao.ProveedorDAO;
import dao.SolicitudDeCompraDAO;
import entities.ItemLPENT;
import entities.ItemSolCompraENT;
import entities.OVENT;
import entities.OrdenDePedidoENT;
import entities.ProveedorENT;
import entities.SolicitudDeCompraENT;

public class SolicitudDeCompra {

	private int numero;
	private OV ov;
	private Date fechaEmision;
	private float precioTotal;
	private OrdenDePedido ordenDePedido;
	private String estado;
	private Date fechaEntregaEstimada;
	private List<ItemSolCompra> items;

	public SolicitudDeCompra() {
		
	}
	
	public SolicitudDeCompra(int numero, OV ov, Date fechaEmision, float precioTotal, OrdenDePedido ordenDePedido,
					String estado, Date fechaEntregaEstimada) {
		super();
		this.numero = numero;
		this.ov = ov;
		this.fechaEmision = fechaEmision;
		this.precioTotal = precioTotal;
		this.ordenDePedido = ordenDePedido;
		this.estado = estado;
		this.fechaEntregaEstimada = fechaEntregaEstimada;
		this.items = new ArrayList<ItemSolCompra>();
		persistirse();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public OV getOv() {
		return ov;
	}

	public void setOv(OV ov) {
		this.ov = ov;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}

	public OrdenDePedido getOrdenDePedido() {
		return ordenDePedido;
	}

	public void setOrdenDePedido(OrdenDePedido ordenDePedido) {
		this.ordenDePedido = ordenDePedido;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Date getFechaEntregaEstimada() {
		return fechaEntregaEstimada;
	}

	public void setFechaEntregaEstimada(Date fechaEntregaEstimada) {
		this.fechaEntregaEstimada = fechaEntregaEstimada;
	}

	public List<ItemSolCompra> getItems() {
		return items;
	}

	public void setItems(List<ItemSolCompra> items) {
		this.items = items;
	}
	
	public void persistirse() {
		SolicitudDeCompraENT scENT = toENT();
		HibernateDAO.getInstancia().saveOrUpdate(scENT);
	}

	public SolicitudDeCompraENT toENT() {
		OrdenDePedidoENT opENT = new OrdenDePedidoENT();
		List<ItemSolCompraENT> itemsENT = new ArrayList<ItemSolCompraENT>();
		SolicitudDeCompraENT scENT = new SolicitudDeCompraENT(numero, ov.toENT(), ordenDePedido.toENT(), 
				fechaEmision, fechaEntregaEstimada, precioTotal, estado);
		for(ItemSolCompra item:items) 
			itemsENT.add(item.toENT(scENT));
		scENT.setItems(itemsENT);
		return new SolicitudDeCompraENT();
	}

	public static List<SolicitudDeCompra> buscarSCPendentesDAO() {
		List<SolicitudDeCompra> pendientes = new ArrayList<SolicitudDeCompra>();
		for(SolicitudDeCompraENT sc:SolicitudDeCompraDAO.getInstancia().obtenerPendientes())
			pendientes.add(toDOM(sc));
		return pendientes;
	}

	public static SolicitudDeCompra toDOM(SolicitudDeCompraENT scENT) {
//		List<OrdenDePedido> ops = new ArrayList<OrdenDePedido>();
		List<ItemSolCompra> items = new ArrayList<ItemSolCompra>();
		SolicitudDeCompra sc = new SolicitudDeCompra();
		sc.setEstado(scENT.getEstado());
		sc.setFechaEmision(scENT.getFechaEmision());
		sc.setFechaEntregaEstimada(scENT.getFechaEntregaEstimada());
		for(ItemSolCompraENT iscENT:scENT.getItems())
			items.add(ItemSolCompra.toDOM(iscENT));
		sc.setItems(items);
		sc.setNumero(scENT.getNumero());
		sc.setOrdenDePedido(OrdenDePedido.toDOM(scENT.getOp()));
		sc.setOv(OV.toDOM(scENT.getOv()));
		sc.setPrecioTotal(scENT.getPrecioTotal());
		return sc;
	}

	public void generarSolicitudCompra(SolicitudDeCompra sc, OrdenDePedido op, OV ov) {
		setEstado("pendiente");
		Date fechaHoy = new java.sql.Date(System.currentTimeMillis());
		setFechaEmision(fechaHoy);
		setFechaEntregaEstimada(null);
		setOrdenDePedido(op);
		setOv(ov);
	}

	public void toXML() {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("SolicitudDeCompra");
			doc.appendChild(rootElement);
			// numeroSolicitudDeCompra
			Element numeroSolicitudDeCompra = doc.createElement("numeroSolicitudDeCompra");
			numeroSolicitudDeCompra.appendChild(doc.createTextNode(String.valueOf(this.numero)));
			rootElement.appendChild(numeroSolicitudDeCompra);
			// numeroOP
			Element numeroOP = doc.createElement("numeroOP");
			numeroOP.appendChild(doc.createTextNode(String.valueOf(this.ordenDePedido.getNumero())));
			rootElement.appendChild(numeroOP);
			// nroSucursal
			Element nroSucursal = doc.createElement("nroSucursal");
			nroSucursal.appendChild(doc.createTextNode(String.valueOf(this.ov.getNumeroSucursal())));
			rootElement.appendChild(nroSucursal);
			// fechaEmision
			Element fechaEmision = doc.createElement("fechaEmision");
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			fechaEmision.appendChild(doc.createTextNode(format.format((this.fechaEmision))));
			rootElement.appendChild(fechaEmision);
			// precioTotal
			Element precioTotal = doc.createElement("precioTotal");
			precioTotal.appendChild(doc.createTextNode(String.valueOf(this.precioTotal)));
			rootElement.appendChild(precioTotal);			
			// detalle 
			{
				for (ItemSolCompra itemSC : items) {
					// items elements
					Element item = doc.createElement("item");
					rootElement.appendChild(item);
					// codigoRodamiento
					Element codigoRodamiento = doc.createElement("codigoRodamiento");
					codigoRodamiento.appendChild(doc.createTextNode(itemSC.getRodamiento().getCodRodamiento()));
					item.appendChild(codigoRodamiento);
					// cantidad
					Element cantidad = doc.createElement("cantidad");
					cantidad.appendChild(doc.createTextNode(String.valueOf(itemSC.getCantidad())));
					item.appendChild(cantidad);
					// precio
					Element precio = doc.createElement("precio");
					precio.appendChild(doc.createTextNode(String.valueOf(itemSC.getPrecio())));
					item.appendChild(precio);
					// cuitProveedor
					Element cuitProveedor = doc.createElement("cuitProveedor");
					cuitProveedor.appendChild(doc.createTextNode(itemSC.getProveedor().getCuit()));
					item.appendChild(cuitProveedor);
				}
			}
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("C:\\test\\SolCompra" + String.valueOf(getNumero()) + ".xml"));
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
	
}
