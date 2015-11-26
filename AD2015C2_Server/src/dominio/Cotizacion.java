package dominio;

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

public class Cotizacion {
		private Date fechaEnviada;
		private Date fechaExpiracion;
		private int numero;
		private SolicitudCotizacion solicitudCotizacion;
		private Cliente cliente;
		private List<ItemCotizacion> items;
		
		public Cotizacion(int numero, int numeroSolicitudCotizacion
				,Date fechaEnviada,Cliente cliente) {
			super();
			this.numero = numero;
			this.fechaEnviada = fechaEnviada;
			this.cliente = cliente;
			this.items =  new ArrayList<ItemCotizacion>();
		}
		public Cotizacion() {
			this.items =  new ArrayList<ItemCotizacion>();
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
		public SolicitudCotizacion getSolicitudCotizacion() {
			return solicitudCotizacion;
		}
		public void setSolicitudCotizacion(SolicitudCotizacion solicitudCotizacion) {
			this.solicitudCotizacion = solicitudCotizacion;
		}
		public Cliente getCliente() {
			return cliente;
		}
		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}
		public List<ItemCotizacion> getItems() {
			return items;
		}
		public void setItems(List<ItemCotizacion> items) {
			this.items = items;
		}
		public Date getFechaExpiracion() {
			return fechaExpiracion;
		}
		public void setFechaExpiracion(Date fechaExpiración) {
			this.fechaExpiracion = fechaExpiración;
		}
		
		public void agregarItemCotizacion() {
			
		}

		public static Cotizacion fromXML(String nombreArchivo, OV estaOV) {
			Cotizacion c = new Cotizacion();
			Document doc = null;
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder;
			try {
					builder = factory.newDocumentBuilder();
					doc = builder.parse(nombreArchivo);
					c.setNumero(Integer.parseInt(doc.getElementsByTagName("numeroCotizacion").item(0).getTextContent()));
					c.setSolicitudCotizacion(estaOV.buscarSolicitudCotizacion(Integer.parseInt(doc.getElementsByTagName("numeroSolicitud").item(0).getTextContent())));
					c.setCliente(estaOV.buscarCliente(doc.getElementsByTagName("idCliente").item(0).getTextContent()));
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					java.util.Date parsed;
					parsed = format.parse(doc.getElementsByTagName("fechaSolicitud").item(0).getTextContent());
					c.setFechaEnviada(new java.sql.Date(parsed.getTime()));
					parsed = format.parse(doc.getElementsByTagName("fechaExpiracion").item(0).getTextContent());
					c.setFechaExpiracion(new java.sql.Date(parsed.getTime()));


					NodeList nList = doc.getElementsByTagName("item");
					for (int i=0;i < nList.getLength(); i++){
					if (nList.item(i).hasChildNodes()){
						Element ele = (Element)nList.item(i);
						ItemCotizacion itemTemp = new ItemCotizacion();
						itemTemp.setRodamiento(CC.getInstancia().buscarRodamiento(ele.getElementsByTagName("codigoRodamiento").item(0).getTextContent()));
						itemTemp.setCantidad(Integer.parseInt(ele.getElementsByTagName("cantidad").item(0).getTextContent()));
						itemTemp.setPrecio(Float.parseFloat(ele.getElementsByTagName("precio").item(0).getTextContent()));
						c.items.add(itemTemp);
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
			return c;
		}
		
		
		public void toXML(String nombreArchivo) {
			try {
				DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
				// root elements
				Document doc = docBuilder.newDocument();
				Element rootElement = doc.createElement("Cotizacion");
				doc.appendChild(rootElement);
				// numeroCotizacion
				Element numeroCotizacion = doc.createElement("numeroCotizacion");
				numeroCotizacion.appendChild(doc.createTextNode(String.valueOf(this.numero)));
				rootElement.appendChild(numeroCotizacion);
				// numeroSolicitud
				Element numeroSolicitud = doc.createElement("numeroSolicitud");
				numeroSolicitud.appendChild(doc.createTextNode(String.valueOf(this.numero)));
				rootElement.appendChild(numeroSolicitud);
				// idCliente
				Element idCliente = doc.createElement("idCliente");
				idCliente.appendChild(doc.createTextNode(this.getCliente().getCuil()));
				rootElement.appendChild(idCliente);
				// fechaSolicitud
				Element fechaSolicitud = doc.createElement("fechaCotizacion");
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				fechaSolicitud.appendChild(doc.createTextNode(format.format((this.getFechaEnviada()))));
				rootElement.appendChild(fechaSolicitud);
				// fechaExpiracion
				Element fechaExpiracion = doc.createElement("fechaExpiracion");
				//SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				fechaExpiracion.appendChild(doc.createTextNode(format.format((this.getFechaExpiracion()))));
				rootElement.appendChild(fechaExpiracion);
				// detalle 
				{
					for (ItemCotizacion itemCotizacion : items) {
						// items elements
						Element item = doc.createElement("item");
						rootElement.appendChild(item);
						// codigoRodamiento
						Element codigoRodamiento = doc.createElement("codigoRodamiento");
						codigoRodamiento.appendChild(doc.createTextNode(itemCotizacion.getRodamiento().getCodRodamiento()));
						item.appendChild(codigoRodamiento);
						// cantidad
						Element cantidad = doc.createElement("cantidad");
						cantidad.appendChild(doc.createTextNode(String.valueOf(itemCotizacion.getCantidad())));
						item.appendChild(cantidad);
						// precio
						Element precio = doc.createElement("precio");
						precio.appendChild(doc.createTextNode(String.valueOf(itemCotizacion.getPrecio())));
						item.appendChild(precio);

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
