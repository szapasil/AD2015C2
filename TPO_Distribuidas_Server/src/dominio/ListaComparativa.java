package dominio;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.persistence.*;

import dominio.DAO.ListaComparativaDAO;

@Entity
@Table(name="listaComparativa")
public class ListaComparativa implements Observer {

	@OneToMany
	@JoinColumn(name="idLista")
	private List<ItemLC> itemsLC;
	
	public ListaComparativa(){
	}

	public List<ItemLC> getItemsLC() {
		return itemsLC;
	}

	public void setItemsLC(List<ItemLC> itemsLC) {
		this.itemsLC = itemsLC;
	}
	
	//Observer 
	public void update(Observable o, Object arg) {
		ListaPrecios lp = (ListaPrecios) o;
		actualizarListaComparativa(lp);
		System.out.println("Observer detecto lista nueva del prooveedor: " + lp.getProveedor().getCuil());
	}

	private void actualizarListaComparativa(ListaPrecios lp) {
		boolean existe = false;
		ItemLC item = null;
		for(ItemLP ilp: lp.getItems()){
			for(ItemLC ilc: itemsLC){
				if(ilc.getRodamiento().getCodRodamiento().equals(ilp.getRodamiento().getCodRodamiento())){
					existe = true;
					if(ilc.getPrecio() > ilp.getPrecio()){
						ilc.modificarItemLC(lp,ilp);
						ListaComparativaDAO.getInstancia().updateItemLC(lp,ilp);
					}
				}
			}
			if(!existe){
				item = new ItemLC(ilp.getRodamiento(),ilp.getPrecio(),ilp.getDescuento(),ilp.getCondiciones(),ilp.getStock(),lp.getProveedor());
				itemsLC.add(item);
			}
		}
	}
	
	
}
