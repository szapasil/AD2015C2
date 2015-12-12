package dominio;

import java.util.ArrayList;
import java.util.List;

public class ItemRT {

	private int sucursal;
	private List<ItemRTOV> itemsOV;
	
	public ItemRT() {
		this.itemsOV = new ArrayList<ItemRTOV>();
	}
	
	public int getSucursal() {
		return sucursal;
	}
	
	public void setSucursal(int sucursal) {
		this.sucursal = sucursal;
	}
	
	public List<ItemRTOV> getItemsOV() {
		return itemsOV;
	}
	
	public void setItemsOV(List<ItemRTOV> itemsOV) {
		this.itemsOV = itemsOV;
	}

	public void agregarProductos(RemitoProvCC rpcc) {
		for(ItemRPCC irpcc:rpcc.getItems()){
			ItemRTOV itemOV = new ItemRTOV();
			itemOV.setRodamiento(irpcc.getRodamiento());
			itemOV.setCantidad(irpcc.getCantidad());
			itemsOV.add(itemOV);
		}
	} 
	
}
