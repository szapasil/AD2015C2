package dominio;

import hbt.HibernateDAO;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import entities.ItemOPENT;
import entities.OrdenDePedidoENT;
import app.CC;
import app.OV;

public class OrdenDePedido {
	private int numero;
	private Date fechaEnviada;	
	private Cliente cliente;

	private List<ItemOP> items;
	public OrdenDePedido(int numero, Date fechaEnviada,	Cliente cliente) {
		super();
		this.numero = numero;
		this.fechaEnviada = fechaEnviada;
		this.cliente = cliente;
		this.items =  new ArrayList<ItemOP>();
	}
	public OrdenDePedido() {
		super();
		this.items =  new ArrayList<ItemOP>();
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getFechaEnviada() {
		return fechaEnviada;
	}
	public void setFechaEnviada(Date fechaEnviada) {
		this.fechaEnviada = fechaEnviada;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<ItemOP> getItems() {
		return items;
	}
	public void setItems(List<ItemOP> items) {
		this.items = items;
	}
	
	
//	public void agregarItemsOrdenDePedido(String codRodamiento, int cantidad, float precio) throws RemoteException{
//		ItemOP item;
//		item = new ItemOP(CC.getInstancia().buscarRodamiento(codRodamiento),cantidad,precio);
//		items.add(item);
//	}
	
	public void persistirse() {
		OrdenDePedidoENT opENT = this.toENT();
		HibernateDAO.getInstancia().saveOrUpdate(opENT);
	}
	
	public OrdenDePedidoENT toENT() {
		List<ItemOPENT> itemsENT = new ArrayList<ItemOPENT>();
		OrdenDePedidoENT opENT = new OrdenDePedidoENT(numero, fechaEnviada, cliente.toENT());
		for (ItemOP item : this.items) {
			itemsENT.add(item.toENT(opENT));
			System.out.println("Agregando items---->"+ itemsENT.size());
		}
		opENT.setItems(itemsENT);
		return opENT;
	}
	
	public static OrdenDePedido toDOM(OrdenDePedidoENT opENT) throws RemoteException {
		OrdenDePedido op = new OrdenDePedido(opENT.getNumero(),opENT.getFechaEnviada(),Cliente.toDOM(opENT.getCliente()));
		List<ItemOP> items = new ArrayList<ItemOP>();
		for (ItemOPENT item : opENT.getItems()) {
			items.add(ItemOP.toDOM(item));
			System.out.println("Agregando items---->"+ items.size());
		}
		
		return op;
	}
	
	public static OrdenDePedido fromXML(String nombreArchivo, OV estaOV) throws Exception {
		OrdenDePedido op = new OrdenDePedido();
		Document doc = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
				builder = factory.newDocumentBuilder();
				doc = builder.parse(nombreArchivo);
				op.setNumero(Integer.parseInt(doc.getElementsByTagName("numeroPedido").item(0).getTextContent()));
				op.setCliente(estaOV.buscarCliente(doc.getElementsByTagName("idCliente").item(0).getTextContent()));
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				java.util.Date parsed;
				parsed = format.parse(doc.getElementsByTagName("fechaSolicitud").item(0).getTextContent());
				op.setFechaEnviada(new java.sql.Date(parsed.getTime()));

				NodeList nList = doc.getElementsByTagName("item");
				for (int i=0;i < nList.getLength(); i++){
				if (nList.item(i).hasChildNodes()){
					Element ele = (Element)nList.item(i);
					ItemOP itemTemp = new ItemOP();
					itemTemp.setRodamiento(CC.getInstancia().buscarRodamiento(ele.getElementsByTagName("codigoRodamiento").item(0).getTextContent()));
					itemTemp.setCantidad(Integer.parseInt(ele.getElementsByTagName("cantidad").item(0).getTextContent()));
					itemTemp.setPrecio(Float.parseFloat(ele.getElementsByTagName("precio").item(0).getTextContent()));
					itemTemp.setCotizacion(estaOV.buscarCotizacion(Integer.parseInt(doc.getElementsByTagName("numeroCotizacion").item(0).getTextContent())));
					itemTemp.setEstado("pendiente");
					op.items.add(itemTemp);
					}
				}
				File f = new File(nombreArchivo);
				f.delete();
			} catch (NumberFormatException e) {e.printStackTrace();
			} catch (DOMException e) {e.printStackTrace();
			} catch (RemoteException e) {e.printStackTrace();
			} catch (ParserConfigurationException e) {e.printStackTrace();
			} catch (SAXException e) {e.printStackTrace();
			} catch (IOException e) {e.printStackTrace();
			} catch (ParseException e) {e.printStackTrace();
		}
		return op;
	}
	
	public void toXML(String nombreArchivo) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("OrdenDePedido");
			doc.appendChild(rootElement);
			// numeroCotizacion
			Element numeroPedido = doc.createElement("numeroPedido");
			numeroPedido.appendChild(doc.createTextNode(String.valueOf(this.numero)));
			rootElement.appendChild(numeroPedido);
			// idCliente
			Element idCliente = doc.createElement("idCliente");
			idCliente.appendChild(doc.createTextNode(this.getCliente().getCuil()));
			rootElement.appendChild(idCliente);
			// fechaSolicitud
			Element fechaSolicitud = doc.createElement("fechaCotizacion");
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			fechaSolicitud.appendChild(doc.createTextNode(format.format((this.getFechaEnviada()))));
			rootElement.appendChild(fechaSolicitud);
			// detalle 
			{
				for (ItemOP itemOrdenDePedido: items) {
					// items elements
					Element item = doc.createElement("item");
					rootElement.appendChild(item);
					// codigoRodamiento
					Element codigoRodamiento = doc.createElement("codigoRodamiento");
					codigoRodamiento.appendChild(doc.createTextNode(itemOrdenDePedido.getRodamiento().getCodRodamiento()));
					item.appendChild(codigoRodamiento);
					// cantidad
					Element cantidad = doc.createElement("cantidad");
					cantidad.appendChild(doc.createTextNode(String.valueOf(itemOrdenDePedido.getCantidad())));
					item.appendChild(cantidad);
					// precio
					Element precio = doc.createElement("precio");
					precio.appendChild(doc.createTextNode(String.valueOf(itemOrdenDePedido.getPrecio())));
					item.appendChild(precio);
					// numeroSolicitud
					Element numeroCotizacion = doc.createElement("numeroCotizacion");
					numeroCotizacion.appendChild(doc.createTextNode(String.valueOf(itemOrdenDePedido.getCotizacion().getNumero())));
					item.appendChild(numeroCotizacion);
					
				}
			}
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("D:\\test\\" + nombreArchivo + ".xml"));
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
