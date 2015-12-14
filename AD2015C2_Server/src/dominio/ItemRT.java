package dominio;

import java.util.ArrayList;
import java.util.List;

public class ItemRT {

	private String destino;
	private List<ItemRTOV> itemsOV;
	
	public ItemRT() {
		this.itemsOV = new ArrayList<ItemRTOV>();
	}
	
	public String getDestino() {
		return destino;
	}
	
	public void setDestino(String destino) {
		this.destino = destino;
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

	public void agregarProductos(Remito remitoCliente) {
		for(ItemRemito ir:remitoCliente.getItems()){
			ItemRTOV itemOV = new ItemRTOV();
			itemOV.setRodamiento(ir.getRodamiento());
			itemOV.setCantidad(ir.getCantidad());
			itemsOV.add(itemOV);
		}
	} 
	
}
