package entities;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class ItemOPENTpk implements Serializable{

	private static final long serialVersionUID = 2116570386573301413L;
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="numero_pedido", nullable = false)
	private OrdenDePedidoENT pedido;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codRodamiento", nullable = false)
	private RodamientoENT rodamiento;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="numero_cotizacion", nullable = false)
	private CotizacionENT cotizacion;

	public ItemOPENTpk() {
		super();
	}

	public ItemOPENTpk(OrdenDePedidoENT pedido, RodamientoENT rodamiento,
			CotizacionENT cotizacion) {
		super();
		this.pedido = pedido;
		this.rodamiento = rodamiento;
		this.cotizacion = cotizacion;
	}

	public OrdenDePedidoENT getPedido() {
		return pedido;
	}

	public void setPedido(OrdenDePedidoENT pedido) {
		this.pedido = pedido;
	}

	public RodamientoENT getRodamiento() {
		return rodamiento;
	}

	public void setRodamiento(RodamientoENT rodamiento) {
		this.rodamiento = rodamiento;
	}

	public CotizacionENT getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(CotizacionENT cotizacion) {
		this.cotizacion = cotizacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
