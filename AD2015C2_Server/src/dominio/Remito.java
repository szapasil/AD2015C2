package dominio;

import java.io.File;
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

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Remito {
	private int numero;
	private Factura factura;
	private Cliente cliente;
	private Date fechaEmision;
	private List<ItemRemito> items;
	
	public Remito() {
		this.items = new ArrayList<ItemRemito>();
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public Factura getFactura() {
		return factura;
	}
	
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Date getFechaEmision() {
		return fechaEmision;
	}
	
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	
	public List<ItemRemito> getItems() {
		return items;
	}

	public void setItems(List<ItemRemito> items) {
		this.items = items;
	}

	public void agregarItem(OrdenDePedido op, ItemOP iop, RemitoCCOV rccov) {
		if(iop.getEstado().equals("pendiente")){
			for(ItemRCCOV irccov:rccov.getItems()){
				if(iop.getRodamiento().getCodRodamiento().equals(irccov.getRodamiento().getCodRodamiento())){
					ItemRemito item = new ItemRemito(iop.getRodamiento(), iop.getCantidad());
					items.add(item);
					irccov.setCantidad(irccov.getCantidad()-iop.getCantidad());
					iop.setEstado("entregado");
					iop.persistirse(op.toENT());
				}
			}
		}
	}

	public void toXML() {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("RemitoCliente");
			doc.appendChild(rootElement);
			// nroRemitoCliente
			Element nroRemitoCliente = doc.createElement("nroRemitoCliente");
			nroRemitoCliente.appendChild(doc.createTextNode(String.valueOf(this.numero)));
			rootElement.appendChild(nroRemitoCliente);
			// nroFactura
			Element nroFactura = doc.createElement("nroFactura");
			nroFactura.appendChild(doc.createTextNode(String.valueOf(this.getFactura().getNumero())));
			rootElement.appendChild(nroFactura);
			// cuilCliente
			Element cuilCliente = doc.createElement("cuilCliente");
			cuilCliente.appendChild(doc.createTextNode(String.valueOf(this.getCliente().getCuil())));
			rootElement.appendChild(cuilCliente);
			// fecha
			Element fecha = doc.createElement("fecha");
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			fecha.appendChild(doc.createTextNode(format.format((this.getFechaEmision()))));
			rootElement.appendChild(fecha);
			
			// detalle 
			{
				for (ItemRemito itemRemito : items) {
					// items elements
					Element item = doc.createElement("item");
					rootElement.appendChild(item);
					// codigoRodamiento
					Element codigoRodamiento = doc.createElement("codigoRodamiento");
					codigoRodamiento.appendChild(doc.createTextNode(itemRemito.getRodamiento().getCodRodamiento()));
					item.appendChild(codigoRodamiento);
					// cantidad
					Element cantidad = doc.createElement("cantidad");
					cantidad.appendChild(doc.createTextNode(String.valueOf(itemRemito.getCantidad())));
					item.appendChild(cantidad);
				}
			}
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("C:\\test\\RemitoCliente" + String.valueOf(getNumero()) + ".xml"));
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
