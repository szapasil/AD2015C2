package entities;

import hbt.PersistentObject;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="listaComparativa")
public class ListaCompENT extends PersistentObject {
	
	@OneToMany(mappedBy="id",cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name="idLC")
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
