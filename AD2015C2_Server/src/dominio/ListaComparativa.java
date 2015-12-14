package dominio;

import hbt.HibernateDAO;

import java.util.ArrayList;
import java.util.List;

import dao.ListaComparativaDAO;
import entities.ListaComparativaENT;

public class ListaComparativa {

private List<ItemLC> itemsLC;
	
	public ListaComparativa() {
		super();
		this.itemsLC = new ArrayList<ItemLC>();
		persistirse();
	}
	
	public ListaComparativa(List<ItemLC> items) {
		super();
		this.itemsLC = items;
	}

	public List<ItemLC> getItemsLC() {
		return itemsLC;
	}

	public void setItemsLC(List<ItemLC> itemsLC) {
		this.itemsLC = itemsLC;
	}

	public void persistirse() {
		ListaComparativaENT lcENT = toENT();
		HibernateDAO.getInstancia().saveOrUpdate(lcENT);
	}
	
	private ListaComparativaENT toENT() {
		return new ListaComparativaENT();
	}
/*
	public List<ItemLC> obtenerItemsLC() {
		List<ItemLC> itemsLC = new ArrayList<ItemLC>();
		for(ItemLCENT ilcENT:ItemLCDAO.getInstancia().obtenerItems())
			itemsLC.add(ItemLC.toDOM(ilcENT));
		return null;
	}
*/		
	/*
		public dto.Proveedor toDTO() {
			return new dto.Proveedor(this.condicionesCompra,this.cuit,this.direccion,this.estado,
							this.listasDePrecios,this.LPVigente,this.razonSocial);
		}
	*/

	public static ListaComparativa obtenerLC() {
		ListaComparativaENT lcENT = ListaComparativaDAO.getInstancia().BuscarLC();
		if(lcENT!=null)
			return toDOM(lcENT);
		return null;
	}

	public static ListaComparativa toDOM(ListaComparativaENT lcENT) {
		List<ItemLC> items = ItemLC.obtenerItemsLC();
		ListaComparativa lc = new ListaComparativa(items);
		return lc;
	}

}
