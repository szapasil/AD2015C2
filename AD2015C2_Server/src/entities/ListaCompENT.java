package entities;

import hbt.PersistentObject;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="listaComparativa")
public class ListaCompENT extends PersistentObject {
	
	@OneToMany
	@JoinColumn(name="idListaComp")
	private List<ItemLCENT> itemsLC;
	
//	public ListaCompENT(List<ItemLCENT> itemsLC) {
//		super();
//		this.itemsLC = new ArrayList<ItemLCENT>();
//	}
	
	public ListaCompENT() {
		super();
		this.itemsLC = new ArrayList<ItemLCENT>();
	}

//	public ListaCompENT(){
//		
//	}

	public List<ItemLCENT> getItemsLC() {
		return itemsLC;
	}

	public void setItemsLC(List<ItemLCENT> itemsLC) {
		this.itemsLC = itemsLC;
	}

}
