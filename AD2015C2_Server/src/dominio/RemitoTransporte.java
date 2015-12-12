package dominio;

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

public class RemitoTransporte {

	private int numero;
	private Date fecha;
	private List<ItemRT> items;
	
	public RemitoTransporte() {
		this.items = new ArrayList<ItemRT>();
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public List<ItemRT> getItems() {
		return items;
	}
	
	public void setItems(List<ItemRT> items) {
		this.items = items;
	}

	public void agregarPedidoOV(RemitoProvCC rpcc, int nroSucursal) {
		ItemRT item = new ItemRT();
		item.setSucursal(nroSucursal);
		item.agregarProductos(rpcc);
		items.add(item);
	}

	public void toXML() {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("RemitoTransporte");
			doc.appendChild(rootElement);
			// numeroRT
			Element numeroRT = doc.createElement("numeroRT");
			numeroRT.appendChild(doc.createTextNode(String.valueOf(this.numero)));
			rootElement.appendChild(numeroRT);
			// fecha
			Element fecha = doc.createElement("fecha");
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			fecha.appendChild(doc.createTextNode(format.format((this.getFecha()))));
			rootElement.appendChild(fecha);
			// itemsRT 
			{
				for (ItemRT itemRT : items) {
					// items elements
					Element item = doc.createElement("item");
					rootElement.appendChild(item);
					// sucursal
					Element sucursal = doc.createElement("sucursal");
					sucursal.appendChild(doc.createTextNode(String.valueOf(itemRT.getSucursal())));
					item.appendChild(sucursal);
					// itemsRTOV 
					{
						for (ItemRTOV itemRTOV : itemRT.getItemsOV()) {
							// itemsOV elements
							Element itemOV = doc.createElement("itemOV");
							rootElement.appendChild(itemOV);
							// codigoRodamiento
							Element codigoRodamiento = doc.createElement("codigoRodamiento");
							codigoRodamiento.appendChild(doc.createTextNode(itemRTOV.getRodamiento().getCodRodamiento()));
							item.appendChild(codigoRodamiento);
							// cantidad
							Element cantidad = doc.createElement("cantidad");
							cantidad.appendChild(doc.createTextNode(String.valueOf(itemRTOV.getCantidad())));
							item.appendChild(cantidad);
						}
					}
				}
			}
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("C:\\Eclipse EE\\RT" + String.valueOf(getNumero()) + ".xml"));
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
