package dominio;

import hbt.HibernateDAO;

import java.util.ArrayList;
import java.util.List;

import dao.CondCompraDAO;
import dao.ItemLCDAO;
import entities.ItemLCENT;
import entities.CondCompraENT;

public class ItemLC {

	private Rodamiento rodamiento;
	private float precio;
	private int stock;
	private int condCompra;
	private int bonificacion;
//	private List<CondCompra> condicionesCompra;
	private Proveedor proveedor;
	
	public ItemLC() {
		
	}

	public ItemLC(Rodamiento rodamiento, float precio, int stock, int condCompra, 
			int bonificacion, Proveedor proveedor) {
		super();
		this.rodamiento = rodamiento;
		this.precio = precio;
		this.stock = stock;
		this.condCompra = condCompra;
		this.bonificacion = bonificacion;
//		this.condicionesCompra = new ArrayList<CondCompra>();
		this.proveedor = proveedor;
	}

	public Rodamiento getRodamiento() {
		return rodamiento;
	}

	public void setRodamiento(Rodamiento rodamiento) {
		this.rodamiento = rodamiento;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

//	public List<CondCompra> getCondicionesCompra() {
//		return condicionesCompra;
//	}

//	public void setCondicionesCompra(List<CondCompra> condicionesCompra) {
//		this.condicionesCompra = condicionesCompra;
//	}

	public int getCondcompra() {
		return condCompra;
	}

	public void setCondcompra(int condCompra) {
		this.condCompra = condCompra;
	}

	public int getBonificacion() {
		return bonificacion;
	}

	public void setBonificacion(int bonificacion) {
		this.bonificacion = bonificacion;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public void modificarItemLC(ListaPrecios lp, ItemLP ilp) {
		this.precio = ilp.getPrecio();
		this.bonificacion = ilp.getBonificacion();
		this.condCompra = ilp.getCondcompra();
		this.proveedor = lp.getProveedor();
//		condicionesCompra = ilp.getCondicionesCompra();
		ItemLCDAO.getInstancia().modificarItemLC(ilp.toENT());
//		for(CondCompra cc:condicionesCompra)
//			CondCompraDAO.getInstancia().bajaLC(cc.toENT());
//		for(CondCompra ilpcc:ilp.getCondicionesCompra())
//			CondCompraDAO.getInstancia().altaLC(ilpcc.toENT());
	}

	public void persistirse() {
		ItemLCENT ilcENT = toENT();
		HibernateDAO.getInstancia().saveOrUpdate(ilcENT);
	}

	public ItemLCENT toENT() {
		return new ItemLCENT(rodamiento.toENT(), precio, stock, condCompra, bonificacion, proveedor.toENT());
//		List<CondCompraENT> condicionesCompraENT = null;
//		for(CondCompra cc:this.condicionesCompra)
//			condicionesCompraENT.add(cc.toENT());
//		return new ItemLCENT(rodamiento.toENT(), precio, stock,	condicionesCompraENT, proveedor.toENT());
	}

}
