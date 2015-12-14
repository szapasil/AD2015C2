package dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Remito {
	private int numero;
	private Factura factura;
	private Cliente cliente;
	private Date fechaEmision;
	private List<ItemRemito> items;
	
	public Remito() {
		this.items = new ArrayList<ItemRemito>();
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public Factura getFactura() {
		return factura;
	}
	
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Date getFechaEmision() {
		return fechaEmision;
	}
	
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	
	public List<ItemRemito> getItems() {
		return items;
	}

	public void setItems(List<ItemRemito> items) {
		this.items = items;
	}

	public void agregarItem(ItemOP iop, RemitoCCOV rccov) {
		if(iop.getEstado().equals("pendiente")){
			for(ItemRCCOV irccov:rccov.getItems()){
				if(iop.getRodamiento().getCodRodamiento().equals(irccov.getRodamiento().getCodRodamiento())){
					ItemRemito item = new ItemRemito(iop.getRodamiento(), iop.getCantidad());
					items.add(item);
					irccov.setCantidad(irccov.getCantidad()-iop.getCantidad());
					iop.setEstado("entregado");
					iop.persistirse();
				}
			}
		}
	}
}
