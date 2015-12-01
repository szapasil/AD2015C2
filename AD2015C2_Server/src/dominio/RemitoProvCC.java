package dominio;

import hbt.HibernateDAO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
}
