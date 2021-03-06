package dominio;
import hbt.HibernateDAO;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import app.CC;
import app.OV;
import dao.SolicitudCotizacionDAO;
import entities.ItemSolCotizacionENT;
import entities.SolicitudCotizacionENT;

public class SolicitudCotizacion {
	private Date fechaEnviada;	
	private int numero;
	private Cliente cliente;
	private List<ItemSolCotizacion> items;

	public SolicitudCotizacion(int numero, Date fechaEnviada, 
			Cliente cliente) {
		super();
		this.numero = numero;
		this.fechaEnviada = fechaEnviada;
		this.cliente = cliente;
		this.items =  new ArrayList<ItemSolCotizacion>();
		persistirse();
	}
	
	public SolicitudCotizacion SolicitudCotizacionFromClient(int numero, Date fechaEnviada, 
			Cliente cliente) {
		SolicitudCotizacion sc = new SolicitudCotizacion();
		sc.numero = numero;
		sc.fechaEnviada = fechaEnviada;
		sc.cliente = cliente;
		sc.items =  new ArrayList<ItemSolCotizacion>();
		return sc;
	}
	
	public SolicitudCotizacion(){
		this.items =  new ArrayList<ItemSolCotizacion>();
	}
	
	public Date getFechaEnviada() {
		return fechaEnviada;
	}
	
	public void setFechaEnviada(Date fechaEnviada) {
		this.fechaEnviada = fechaEnviada;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemSolCotizacion> getItems() {
		return items;
	}
	
	public void setItems(List<ItemSolCotizacion> items) {
		this.items = items;
	}
	
	// SILVIO INICIO >>>
	public void persistirse() {
		SolicitudCotizacionENT scENT = this.toENT();
		HibernateDAO.getInstancia().saveOrUpdate(scENT);
	}
	
	public SolicitudCotizacionENT toENT() {
		List<ItemSolCotizacionENT> itemsENT = new ArrayList<ItemSolCotizacionENT>();
		SolicitudCotizacionENT scENT = new SolicitudCotizacionENT(numero, this.cliente.toENT(),fechaEnviada);
		for (ItemSolCotizacion item : this.items) {
			itemsENT.add(item.toENT(scENT));
			System.out.println("Agregando items---->"+ itemsENT.size());
		}
		scENT.setItems(itemsENT);
		return scENT;
	}
	
	public static SolicitudCotizacion toDOM(SolicitudCotizacionENT scENT) throws RemoteException {
		SolicitudCotizacion sc = new SolicitudCotizacion(scENT.getNumeroSolicitud(),
				scENT.getFechaEnviada(),Cliente.toDOM(scENT.getCliente()));
		List<ItemSolCotizacion> items = new ArrayList<ItemSolCotizacion>();
		for (ItemSolCotizacionENT item : scENT.getItems()) {
			items.add(ItemSolCotizacion.toDOM(item));
			System.out.println("Agregando items---->"+ items.size());
		}
		return sc;
	}
	
	public static SolicitudCotizacion buscarSolicitudCotizacionDAO(int numero) throws RemoteException {
		SolicitudCotizacionENT scENT = SolicitudCotizacionDAO.getInstancia().buscarSolicitudCotizacion(numero);
		if(scENT!=null)
			return toDOM(scENT);
		return null;
	}


	
	public void agregarItemSolicitud(String codRodamiento,int cantidad) {
		try {
			Rodamiento r = CC.getInstancia().buscarRodamiento(codRodamiento);
			ItemSolCotizacion itemsc = new ItemSolCotizacion(r,cantidad);
			this.items.add(itemsc);
			System.out.println("---->"+ items.size());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
		
	public static SolicitudCotizacion fromXML(String nombreArchivo, OV estaOV) throws Exception {
		SolicitudCotizacion sc = new SolicitudCotizacion();
		Document doc = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
				builder = factory.newDocumentBuilder();
				doc = builder.parse(nombreArchivo);
				sc.setNumero(Integer.parseInt(doc.getElementsByTagName("numeroSolicitud").item(0).getTextContent()));
				sc.setCliente(estaOV.buscarCliente(doc.getElementsByTagName("idCliente").item(0).getTextContent()));
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				java.util.Date parsed;
				parsed = format.parse(doc.getElementsByTagName("fechaSolicitud").item(0).getTextContent());
				sc.setFechaEnviada(new java.sql.Date(parsed.getTime()));

				NodeList nList = doc.getElementsByTagName("item");
				for (int i=0;i < nList.getLength(); i++){
				if (nList.item(i).hasChildNodes()){
					Element ele = (Element)nList.item(i);
					ItemSolCotizacion itemTemp = new ItemSolCotizacion();
					itemTemp.setRodamiento(CC.getInstancia().buscarRodamiento(ele.getElementsByTagName("codigoRodamiento").item(0).getTextContent()));
					itemTemp.setCantidad(Integer.parseInt(ele.getElementsByTagName("cantidad").item(0).getTextContent()));
					sc.items.add(itemTemp);
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
		return sc;
	}
	
	public void toXML(String nombreArchivo) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("SolicitudCotizacion");
			doc.appendChild(rootElement);
			// numeroSolicitud
			Element numeroSolicitud = doc.createElement("numeroSolicitud");
			numeroSolicitud.appendChild(doc.createTextNode(String.valueOf(this.numero)));
			rootElement.appendChild(numeroSolicitud);
			// idCliente
			Element idCliente = doc.createElement("idCliente");
			idCliente.appendChild(doc.createTextNode(this.getCliente().getCuil()));
			rootElement.appendChild(idCliente);
			// fechaSolicitud
			Element fechaSolicitud = doc.createElement("fechaSolicitud");
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			fechaSolicitud.appendChild(doc.createTextNode(format.format((this.getFechaEnviada()))));
			rootElement.appendChild(fechaSolicitud);
			// detalle 
			{
				for (ItemSolCotizacion itemSolicitud : items) {
					// items elements
					Element item = doc.createElement("item");
					rootElement.appendChild(item);
					// codigoRodamiento
					Element codigoRodamiento = doc.createElement("codigoRodamiento");
					codigoRodamiento.appendChild(doc.createTextNode(itemSolicitud.getRodamiento().getCodRodamiento()));
					item.appendChild(codigoRodamiento);
					// cantidad
					Element cantidad = doc.createElement("cantidad");
					cantidad.appendChild(doc.createTextNode(String.valueOf(itemSolicitud.getCantidad())));
					item.appendChild(cantidad);
				}
			}
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("C:\\test\\" + nombreArchivo + ".xml"));
//			StreamResult result = new StreamResult(new File("D:\\test\\" + nombreArchivo + ".xml"));
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
	// SILVIO FIN <<<

	public void generarSolicitudDesdeOP(OrdenDePedido op, List<ItemOP> itemsACotizar) {
		setCliente(op.getCliente());
		setFechaEnviada(op.getFechaEnviada());
		setNumero(op.getNumero());
		for(ItemOP iop:itemsACotizar){
			ItemSolCotizacion isc = new ItemSolCotizacion(iop.getRodamiento(),iop.getCantidad());
			items.add(isc);
		}
	}
		
}
