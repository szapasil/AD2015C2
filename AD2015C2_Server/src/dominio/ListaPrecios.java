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

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import app.CC;
import app.OV;
import entities.ItemLPENT;
import entities.ItemSolCotizacionENT;
import entities.ListaPreciosENT;
import entities.SolicitudCotizacionENT;

public class ListaPrecios {

	private int numero;
	private Date fecha;
	private Proveedor proveedor;
	private List<ItemLP> items;

	public ListaPrecios(int numero, Date fecha, Proveedor proveedor) {
		super();
		this.numero = numero;
		this.fecha = fecha;
		this.proveedor = proveedor;
		this.items = new ArrayList<ItemLP>();
//		persistirse();
	}

	public ListaPrecios() {
		// TODO Auto-generated constructor stub
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
	
	public Proveedor getProveedor() {
		return proveedor;
	}
	
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	public List<ItemLP> getItems() {
		return items;
	}
	
	public void setItems(List<ItemLP> items) {
		this.items = items;
	}
/*
	public dto.ListaPrecios toDTO() {
		return new dto.ListaPrecios(this.fecha,this.items,this.numero,this.proveedor);
	}
*/
	
	public void agregarItem(Element ele, Rodamiento rod) {
		float itemPrecio = Float.parseFloat(ele.getElementsByTagName("Precio").item(0).getTextContent());
		int itemStock = Integer.parseInt(ele.getElementsByTagName("Stock").item(0).getTextContent());
		int itemCC = Integer.parseInt(ele.getElementsByTagName("CondCompra").item(0).getTextContent());
		int itemBonif = Integer.parseInt(ele.getElementsByTagName("Bonificacion").item(0).getTextContent());
//		ItemLP ilp = new ItemLP(rod, itemPrecio, itemStock);
		ItemLP ilp = new ItemLP(rod, itemPrecio, itemStock, itemCC, itemBonif);
//		ilp.obtenerCondCompra(ele);
		items.add(ilp);
	}
	
	public void persistirse() {
		ListaPreciosENT lpENT = toENT();
		HibernateDAO.getInstancia().saveOrUpdate(lpENT);
//		proveedor.modificar("","",numero);
		proveedor.setLPVigente(numero);
		proveedor.persistirse();
	}

	public ListaPreciosENT toENT() {
		List<ItemLPENT> itemsENT = new ArrayList<ItemLPENT>();
		ListaPreciosENT lpENT = new ListaPreciosENT(numero, fecha, proveedor.toENT());
		for (ItemLP item : items) {
			itemsENT.add(item.toENT(lpENT));
		}
		lpENT.setItems(itemsENT);
		return lpENT;
	}
	
	public static ListaPrecios fromXML(String nombreArchivo) {
		ListaPrecios lp = new ListaPrecios();
		Document doc = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			doc = builder.parse(nombreArchivo);
			
			NodeList nListLP = doc.getElementsByTagName("ListaPrecios");
			for(int j=0;j < nListLP.getLength(); j++){
				if(nListLP.item(j).hasChildNodes()){
					Element eleLP = (Element)nListLP.item(j);
					lp.setNumero(Integer.parseInt(eleLP.getElementsByTagName("Numero").item(0).getTextContent()));
					lp.setProveedor(CC.getInstancia().buscarProveedor(eleLP.getElementsByTagName("Proveedor").item(0).getTextContent()));
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					java.util.Date parsed = format.parse(eleLP.getElementsByTagName("Fecha").item(0).getTextContent());
					lp.setFecha(new java.sql.Date(parsed.getTime()));

					NodeList nListItems = doc.getElementsByTagName("Item");
					lp.items = new ArrayList<ItemLP>();
					for (int i=0;i < nListItems.getLength(); i++){
						if (nListItems.item(i).hasChildNodes()){
							Element eleItem = (Element)nListItems.item(i);
							ItemLP ilp = new ItemLP();
							Rodamiento rod = CC.getInstancia().buscarRodamiento(eleItem.getElementsByTagName("Codigo").item(0).getTextContent());
							if(rod==null)
								rod = CC.getInstancia().altaRodamientoXML(eleItem);
							ilp.setRodamiento(rod);
							ilp.setBonificacion(Integer.parseInt(eleItem.getElementsByTagName("Bonificacion").item(0).getTextContent()));
							ilp.setCondcompra(Integer.parseInt(eleItem.getElementsByTagName("CondCompra").item(0).getTextContent()));
							ilp.setPrecio(Float.parseFloat(eleItem.getElementsByTagName("Precio").item(0).getTextContent()));
							lp.items.add(ilp);
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
		} return lp;
	}
	
}
