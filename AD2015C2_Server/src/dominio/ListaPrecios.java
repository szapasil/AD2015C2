package dominio;

import hbt.HibernateDAO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

import entities.ListaPreciosENT;

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
		persistirse();
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
	
	private void persistirse() {
		ListaPreciosENT lpENT = toENT();
		HibernateDAO.getInstancia().saveOrUpdate(lpENT);
		
	}

	private ListaPreciosENT toENT() {
		return new ListaPreciosENT(numero, fecha, proveedor.toENT());
	}

}
