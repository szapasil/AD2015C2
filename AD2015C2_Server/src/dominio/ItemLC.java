package dominio;

import java.util.ArrayList;
import java.util.List;

import hbt.HibernateDAO;
import dao.ItemLCDAO;
import dto.ItemLCDTO;
import dto.RodamientoDTO;
import entities.ItemLCENT;

public class ItemLC {

	private Rodamiento rodamiento;
	private float precio;
	private int stock; //SACAR!!!
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
		ItemLCDAO.getInstancia().modificarItemLC(ilp.toENT(lp.toENT()), lp.toENT());
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

	public static ItemLC buscarItemLCDAO(String codRodamiento) {
		ItemLCENT ilcENT = ItemLCDAO.getInstancia().buscarItem(codRodamiento); 
		if(ilcENT!=null)
			return toDOM(ilcENT);
		return null;
	}

	public static ItemLC toDOM(ItemLCENT ilcENT) {
		Rodamiento rod = Rodamiento.toDOM(ilcENT.getRodamiento());
		Proveedor prov = Proveedor.toDOM(ilcENT.getProveedor());
		return new ItemLC(rod, ilcENT.getPrecio(), ilcENT.getStock(), ilcENT.getCondCompra(), ilcENT.getBonificacion(), prov);
	}

	public static List<ItemLC> obtenerItemsLC() {
		List<ItemLC> items = new ArrayList<ItemLC>();
		List<ItemLCENT> itemsENT = ItemLCDAO.getInstancia().obtenerItems();
		for(ItemLCENT ilcENT:itemsENT)
			items.add(toDOM(ilcENT));
		return items;
	}

	public ItemLCDTO toDTO() {
		RodamientoDTO rodamientoDTO = new RodamientoDTO(rodamiento.getCodRodamiento(),rodamiento.getMarca(),rodamiento.getPais(),
						rodamiento.getTipo(),rodamiento.getMedidas(),rodamiento.getCodSFK());
		return new ItemLCDTO(rodamientoDTO,precio,stock,condCompra,bonificacion,proveedor.getCuit());
	}

}
