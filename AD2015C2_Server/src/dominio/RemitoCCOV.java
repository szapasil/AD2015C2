package dominio;

import hbt.HibernateDAO;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.Date;
import java.text.ParseException;
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

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import entities.ItemRCCOVENT;
import entities.RemitoCCOVENT;
import entities.SolicitudDeCompraENT;
import app.CC;
import app.OV;

public class RemitoCCOV {

	private int numero;
	private OV ov;
	private Date fecha;
	private List<SolicitudDeCompra> solicitudesDeCompra;
	private List<ItemRCCOV> items;
	
	public RemitoCCOV(int numero, OV ov, Date fecha,List<SolicitudDeCompra> solicitudesDeCompra, List<ItemRCCOV> items) {
		super();
		this.numero = numero;
		this.ov = ov;
		this.fecha = fecha;
		this.solicitudesDeCompra = solicitudesDeCompra;
		this.items = items;
	}

	public RemitoCCOV() {

	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public OV getOV() {
		return ov;
	}

	public void setOV(OV ov) {
		this.ov = ov;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<SolicitudDeCompra> getSolicitudesDeCompra() {
		return solicitudesDeCompra;
	}

	public void setSolicitudesDeCompra(List<SolicitudDeCompra> solicitudesDeCompra) {
		this.solicitudesDeCompra = solicitudesDeCompra;
	}

	public List<ItemRCCOV> getItems() {
		return items;
	}

	public void setItems(List<ItemRCCOV> items) {
		this.items = items;
	}

	public void persistirse() {
		RemitoCCOVENT rpccENT = toENT();
		HibernateDAO.getInstancia().saveOrUpdate(rpccENT);
	}

	public RemitoCCOVENT toENT() {
		List<ItemRCCOVENT> itemsENT = new ArrayList<ItemRCCOVENT>();
		List<SolicitudDeCompraENT> scsENT = new ArrayList<SolicitudDeCompraENT>();
		RemitoCCOVENT rccovENT = new RemitoCCOVENT(numero, fecha, ov.toENT());
		for (ItemRCCOV item : items) {
			itemsENT.add(item.toENT(rccovENT));
		}
		rccovENT.setItems(itemsENT);
		for (SolicitudDeCompra sc : solicitudesDeCompra) {
			scsENT.add(sc.toENT());
//			scsENT.add(sc.toENT(rccovENT));?????????
		}
		rccovENT.setSolicitudesDeCompra(scsENT);
		return rccovENT;
	}

	public void agregarItems(RemitoProvCC rpcc) {
		for(ItemRPCC irpcc:rpcc.getItems()){
			ItemRCCOV irccov = new ItemRCCOV(irpcc.getRodamiento(), irpcc.getCantidad());
			items.add(irccov);
		}
	}

	public void toXML() {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("RemitoCCOV");
			doc.appendChild(rootElement);
			// numeroRCCOV
			Element numeroRCCOV = doc.createElement("numeroRCCOV");
			numeroRCCOV.appendChild(doc.createTextNode(String.valueOf(this.numero)));
			rootElement.appendChild(numeroRCCOV);
			// nroSucursal
			Element nroSucursal = doc.createElement("nroSucursal");
			nroSucursal.appendChild(doc.createTextNode(String.valueOf(this.getOV().getNumeroSucursal())));
			rootElement.appendChild(nroSucursal);
			// fecha
			Element fecha = doc.createElement("fecha");
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			fecha.appendChild(doc.createTextNode(format.format((this.getFecha()))));
			rootElement.appendChild(fecha);
			// Solicitudes de Compra 
			{
				for (SolicitudDeCompra solicitud : solicitudesDeCompra) {
					// nroSC
					Element nroSC = doc.createElement("nroSC");
					nroSC.appendChild(doc.createTextNode(String.valueOf(solicitud.getNumero())));
					rootElement.appendChild(nroSC);
				}
			}
			// detalle 
			{
				for (ItemRCCOV itemRCCOV : items) {
					// items elements
					Element item = doc.createElement("item");
					rootElement.appendChild(item);
					// codigoRodamiento
					Element codigoRodamiento = doc.createElement("codigoRodamiento");
					codigoRodamiento.appendChild(doc.createTextNode(itemRCCOV.getRodamiento().getCodRodamiento()));
					item.appendChild(codigoRodamiento);
					// cantidad
					Element cantidad = doc.createElement("cantidad");
					cantidad.appendChild(doc.createTextNode(String.valueOf(itemRCCOV.getCantidad())));
					item.appendChild(cantidad);
				}
			}
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("C:\\test\\RemitoCCOV" + String.valueOf(getNumero()) + ".xml"));
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

	public static RemitoCCOV fromXML(String nombreArchivo) {
		RemitoCCOV rccov = new RemitoCCOV();
		Document doc = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			doc = builder.parse(nombreArchivo);
			
			NodeList nRCCOV = doc.getElementsByTagName("RemitoCCOV");
			for(int j=0;j < nRCCOV.getLength(); j++){
				if(nRCCOV.item(j).hasChildNodes()){
					Element eleRCCOV = (Element)nRCCOV.item(j);
					rccov.setNumero(Integer.parseInt(eleRCCOV.getElementsByTagName("Numero").item(0).getTextContent()));
					rccov.setOV(CC.getInstancia().buscarOV(Integer.parseInt(eleRCCOV.getElementsByTagName("NroSucursal").item(0).getTextContent())));
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					java.util.Date parsed = format.parse(eleRCCOV.getElementsByTagName("Fecha").item(0).getTextContent());
					rccov.setFecha(new java.sql.Date(parsed.getTime()));
					//SCs
					NodeList nListSCs = doc.getElementsByTagName("SolicitudDeCompra");
					rccov.solicitudesDeCompra = new ArrayList<SolicitudDeCompra>();
					for (int i=0;i < nListSCs.getLength(); i++){
						if (nListSCs.item(i).hasChildNodes()){
							Element eleSC = (Element)nListSCs.item(i);
							SolicitudDeCompra sc = CC.getInstancia().buscarSolCompra(Integer.parseInt(eleSC.getElementsByTagName("nroSC").item(0).getTextContent()));
							if(sc==null)
								rccov.solicitudesDeCompra.add(sc);
							else
								System.out.println("La SolCompra " + eleSC.getElementsByTagName("nroSC").item(0).getTextContent() + " no existe");
						}
					}
					//Items
					NodeList nListItems = doc.getElementsByTagName("Item");
					rccov.items = new ArrayList<ItemRCCOV>();
					for (int h=0;h < nListItems.getLength(); h++){
						if (nListItems.item(h).hasChildNodes()){
							Element eleItem = (Element)nListItems.item(h);
							ItemRCCOV irccov = new ItemRCCOV();
							Rodamiento rod = CC.getInstancia().buscarRodamiento(eleItem.getElementsByTagName("CodRodamiento").item(0).getTextContent());
							if(rod==null){
								irccov.setRodamiento(rod);
								irccov.setCantidad(Integer.parseInt(eleItem.getElementsByTagName("Cantidad").item(0).getTextContent()));
								rccov.items.add(irccov);
							}
							else
								System.out.println("El Rodamiento " + eleItem.getElementsByTagName("CodRodamiento").item(0).getTextContent() + " no existe");
							
						}
					}
//					File f = new File(nombreArchivo); LUEGO PONER
//					f.delete();
				}
			}
		} catch (NumberFormatException e) {e.printStackTrace();
		} catch (DOMException e) {e.printStackTrace();
		} catch (RemoteException e) {e.printStackTrace();
		} catch (ParserConfigurationException e) {e.printStackTrace();
		} catch (SAXException e) {e.printStackTrace();
		} catch (IOException e) {e.printStackTrace();
		} catch (ParseException e) {e.printStackTrace();
		} return rccov;
	}

}
