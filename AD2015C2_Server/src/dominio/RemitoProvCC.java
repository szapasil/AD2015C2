package dominio;

import hbt.HibernateDAO;

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

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import app.CC;
import entities.ItemRPCCENT;
import entities.OrdenDeCompraENT;
import entities.RemitoProvCCENT;

public class RemitoProvCC {

	private int numero;
	private Proveedor proveedor;
	private Date fecha;
	private List<OrdenDeCompra> ordenesDeCompra;
	private List<ItemRPCC> items;
	
	public RemitoProvCC(int numero, Proveedor proveedor, Date fecha) {
		super();
		this.numero = numero;
		this.proveedor = proveedor;
		this.fecha = fecha;
		this.ordenesDeCompra = new ArrayList<OrdenDeCompra>();
		this.items = new ArrayList<ItemRPCC>();
	}

	public RemitoProvCC() {
	
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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

	public List<OrdenDeCompra> getOrdenesDeCompra() {
		return ordenesDeCompra;
	}

	public void setOrdenesDeCompra(List<OrdenDeCompra> ordenesDeCompra) {
		this.ordenesDeCompra = ordenesDeCompra;
	}

	public List<ItemRPCC> getItems() {
		return items;
	}

	public void setItems(List<ItemRPCC> items) {
		this.items = items;
	}

	public void persistirse() {
		RemitoProvCCENT rpccENT = toENT();
		HibernateDAO.getInstancia().saveOrUpdate(rpccENT);
	}

	public RemitoProvCCENT toENT() {
		List<ItemRPCCENT> itemsENT = new ArrayList<ItemRPCCENT>();
		List<OrdenDeCompraENT> ocsENT = new ArrayList<OrdenDeCompraENT>();
		RemitoProvCCENT rpccENT = new RemitoProvCCENT(numero, fecha, proveedor.toENT());
		for (ItemRPCC item : items) {
			itemsENT.add(item.toENT(rpccENT));
		}
		rpccENT.setItems(itemsENT);
		for (OrdenDeCompra oc : ordenesDeCompra) {
			ocsENT.add(oc.toENT());
//			ocsENT.add(oc.toENT(rpccENT));?????????
		}
		rpccENT.setOrdenesDeCompra(ocsENT);
		return rpccENT;
	}

	public static RemitoProvCC fromXML(String nombreArchivo) {
		RemitoProvCC rpcc = new RemitoProvCC();
		Document doc = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			doc = builder.parse(nombreArchivo);
			
			NodeList nRPCC = doc.getElementsByTagName("RemitoProvCC");
			for(int j=0;j < nRPCC.getLength(); j++){
				if(nRPCC.item(j).hasChildNodes()){
					Element eleRPCC = (Element)nRPCC.item(j);
					rpcc.setNumero(Integer.parseInt(eleRPCC.getElementsByTagName("Numero").item(0).getTextContent()));
					rpcc.setProveedor(CC.getInstancia().buscarProveedor(eleRPCC.getElementsByTagName("Proveedor").item(0).getTextContent()));
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					java.util.Date parsed = format.parse(eleRPCC.getElementsByTagName("Fecha").item(0).getTextContent());
					rpcc.setFecha(new java.sql.Date(parsed.getTime()));
					//OCs
					NodeList nListOCs = doc.getElementsByTagName("OC");
					rpcc.ordenesDeCompra = new ArrayList<OrdenDeCompra>();
					for (int i=0;i < nListOCs.getLength(); i++){
						if (nListOCs.item(i).hasChildNodes()){
							Element eleOC = (Element)nListOCs.item(i);
							OrdenDeCompra oc = CC.getInstancia().buscarOC(Integer.parseInt(eleOC.getElementsByTagName("NumeroOC").item(0).getTextContent()));
							if(oc==null)
								rpcc.ordenesDeCompra.add(oc);
							else
								System.out.println("La OC " + eleOC.getElementsByTagName("NumeroOC").item(0).getTextContent() + " no existe");
						}
					}
					//Items
					NodeList nListItems = doc.getElementsByTagName("Item");
					rpcc.items = new ArrayList<ItemRPCC>();
					for (int h=0;h < nListItems.getLength(); h++){
						if (nListItems.item(h).hasChildNodes()){
							Element eleItem = (Element)nListItems.item(h);
							ItemRPCC irpcc = new ItemRPCC();
							Rodamiento rod = CC.getInstancia().buscarRodamiento(eleItem.getElementsByTagName("CodRodamiento").item(0).getTextContent());
							if(rod==null){
								irpcc.setRodamiento(rod);
								irpcc.setCantidad(Integer.parseInt(eleItem.getElementsByTagName("Cantidad").item(0).getTextContent()));
								rpcc.items.add(irpcc);
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
		} return rpcc;
	}
}
