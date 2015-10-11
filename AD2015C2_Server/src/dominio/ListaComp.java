package dominio;

import hbt.HibernateDAO;

import java.util.ArrayList;
import java.util.List;

import entities.ListaCompENT;

public class ListaComp {

private List<ItemLC> itemsLC;
	
	public ListaComp() {
		super();
		this.itemsLC = new ArrayList<ItemLC>();
		ListaCompENT lcENT = toENT();
		HibernateDAO.getInstancia().saveOrUpdate(lcENT);
	}

	public List<ItemLC> getItemsLC() {
		return itemsLC;
	}

	public void setItemsLC(List<ItemLC> itemsLC) {
		this.itemsLC = itemsLC;
	}

	private ListaCompENT toENT() {
		return new ListaCompENT();
		}
		
	/*
		public dto.Proveedor toDTO() {
			return new dto.Proveedor(this.condicionesCompra,this.cuit,this.direccion,this.estado,
							this.listasDePrecios,this.LPVigente,this.razonSocial);
		}
	*/

}
