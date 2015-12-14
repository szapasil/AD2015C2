package dominio;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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

public class Factura {
	private int numero;
	private String tipo;
	private Cliente cliente;
	private Date fechaEmision;
	private float subtotal;
	private float impuestos;
	private float totalDescuento;
	private float total;
	private List<ItemFactura> items;
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	
	public float getSubtotal() {
		return subtotal;
	}
	
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	
	public float getImpuestos() {
		return impuestos;
	}
	
	public void setImpuestos(float impuestos) {
		this.impuestos = impuestos;
	}
	
	public float getTotalDescuento() {
		return totalDescuento;
	}
	
	public void setTotalDescuento(float totalDescuento) {
		this.totalDescuento = totalDescuento;
	}
	
	public float getTotal() {
		return total;
	}
	
	public void setTotal(float total) {
		this.total = total;
	}
	
	public List<ItemFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}

	public void generarFactura(SolicitudDeCompra sc, Remito remitoCliente) {
		setCliente(remitoCliente.getCliente());
		Date fechaHoy = new java.sql.Date(System.currentTimeMillis());
		setFechaEmision(fechaHoy);
		setImpuestos(21);
		setTipo("C");
		agregarItems(sc,remitoCliente);
		calcularSubtotal();
		calcularTotal();
	}
		
	public void agregarItems(SolicitudDeCompra sc, Remito remitoCliente) {
		for(ItemRemito ir:remitoCliente.getItems()){
			for(ItemSolCompra isc:sc.getItems()){
				if(ir.getRodamiento().getCodRodamiento().equals(isc.getRodamiento().getCodRodamiento())){
					ItemFactura item = new ItemFactura();
					item.setRodamiento(ir.getRodamiento());
					item.setCantidad(ir.getCantidad());
					item.setPrecioUnitario(isc.getPrecio());
					items.add(item);
				}
			}
		}
	}
	
	public void calcularSubtotal() {
		subtotal = 0;
		for(ItemFactura item:items)
			subtotal += item.getPrecioUnitario() * item.getCantidad();
	}
	
	public void calcularTotal() {
		total = 0;
		if(cliente.getCondicionIVA().equals("Inscripto"))
			impuestos = 0;
		else
			impuestos = (float) (subtotal * 0.21);
		totalDescuento = (subtotal + impuestos)*(getCliente().geteDescuento()/100)*(-1);
		total = subtotal + impuestos + totalDescuento; 
	}
	

	public void toXML() {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Factura");
			doc.appendChild(rootElement);
			// numeroCotizacion
			Element numeroFactura = doc.createElement("numeroFactura");
			numeroFactura.appendChild(doc.createTextNode(String.valueOf(this.numero)));
			rootElement.appendChild(numeroFactura);
			// numeroSolicitud
			Element tipo = doc.createElement("tipo");
			tipo.appendChild(doc.createTextNode(String.valueOf(this.getTipo())));
			rootElement.appendChild(tipo);
			// idCliente
			Element idCliente = doc.createElement("IdCliente");
			idCliente.appendChild(doc.createTextNode(this.getCliente().getCuil()));
			rootElement.appendChild(idCliente);
			// fechaEmision
			Element fechaEmision = doc.createElement("fechaEmision");
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			fechaEmision.appendChild(doc.createTextNode(format.format((this.getFechaEmision()))));
			rootElement.appendChild(fechaEmision);
			// subtotal
			Element subtotal = doc.createElement("subtotal");
			subtotal.appendChild(doc.createTextNode(String.valueOf(this.getSubtotal())));
			rootElement.appendChild(subtotal);
			// impuestos
			Element impuestos = doc.createElement("impuestos");
			impuestos.appendChild(doc.createTextNode(String.valueOf(this.getImpuestos())));
			rootElement.appendChild(impuestos);
			// totalDescuento
			Element totalDescuento = doc.createElement("totalDescuento");
			totalDescuento.appendChild(doc.createTextNode(String.valueOf(this.getTotalDescuento())));
			rootElement.appendChild(totalDescuento);
			// total
			Element total = doc.createElement("total");
			total.appendChild(doc.createTextNode(String.valueOf(this.getTotal())));
			rootElement.appendChild(total);
			
			// detalle 
			{
				for (ItemFactura itemFactura : items) {
					// items elements
					Element item = doc.createElement("item");
					rootElement.appendChild(item);
					// codigoRodamiento
					Element codigoRodamiento = doc.createElement("codigoRodamiento");
					codigoRodamiento.appendChild(doc.createTextNode(itemFactura.getRodamiento().getCodRodamiento()));
					item.appendChild(codigoRodamiento);
					// cantidad
					Element cantidad = doc.createElement("cantidad");
					DecimalFormat df = new DecimalFormat("#0.##");
					cantidad.appendChild(doc.createTextNode(String.valueOf(itemFactura.getCantidad())));
					item.appendChild(cantidad);
					// precioUnitario
					Element precioUnitario = doc.createElement("precioUnitario");
					precioUnitario.appendChild(doc.createTextNode(df.format(itemFactura.getPrecioUnitario())));
					item.appendChild(precioUnitario);
					// precioTotal
					Element precioTotal = doc.createElement("precioTotal");
					precioTotal.appendChild(doc.createTextNode(df.format(itemFactura.getPrecioUnitario()*itemFactura.getCantidad())));
					item.appendChild(precioTotal);
				}
			}
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("D:\\test\\FACT" + getNumero() + ".xml"));
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
/*	
	public static Factura fromXML(String nombreArchivo, OV estaOV) throws Exception {
		Factura fa = new Factura();
		Document doc = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
				builder = factory.newDocumentBuilder();
				doc = builder.parse(nombreArchivo);
				fa.setNumero(Integer.parseInt(doc.getElementsByTagName("numeroFactura").item(0).getTextContent()));
				fa.setTipo(doc.getElementsByTagName("tipo").item(0).getTextContent());
				fa.setCliente(estaOV.buscarCliente(doc.getElementsByTagName("idCliente").item(0).getTextContent()));
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				java.util.Date parsed = format.parse(doc.getElementsByTagName("fechaEmision").item(0).getTextContent());
				fa.setSubtotal(Float.parseFloat(doc.getElementsByTagName("subtotal").item(0).getTextContent()));
				fa.setImpuestos(Float.parseFloat(doc.getElementsByTagName("impuestos").item(0).getTextContent()));
				fa.setTotalDescuento(Float.parseFloat(doc.getElementsByTagName("totalDescuento").item(0).getTextContent()));
				fa.setTotal(Float.parseFloat(doc.getElementsByTagName("total").item(0).getTextContent()));

				NodeList nList = doc.getElementsByTagName("item");
				for (int i=0;i < nList.getLength(); i++){
				if (nList.item(i).hasChildNodes()){
					Element ele = (Element)nList.item(i);
					ItemFactura itemTemp = new ItemFactura();
					itemTemp.setRodamiento(CC.getInstancia().buscarRodamiento(ele.getElementsByTagName("codigoRodamiento").item(0).getTextContent()));
					itemTemp.setCantidad(Integer.parseInt(ele.getElementsByTagName("cantidad").item(0).getTextContent()));
					itemTemp.setPrecioUnitario(Float.parseFloat(ele.getElementsByTagName("precioUnitario").item(0).getTextContent()));
					fa.items.add(itemTemp);
					fa.calcularTotal();
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
		return fa;
	}	
*/
	
}
