package entities;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.mapping.Selectable;

@Embeddable
public class ItemSolCompraENTpk implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4814264563603459289L;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="numero_solicitudCompra")
	private SolicitudDeCompraENT solicitudCompra;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codRodamiento")
	private RodamientoENT rodamiento;
	public ItemSolCompraENTpk() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemSolCompraENTpk(SolicitudDeCompraENT solicitudCompra,
			RodamientoENT rodamiento) {
		super();
		this.solicitudCompra = solicitudCompra;
		this.rodamiento = rodamiento;
	}
	public SolicitudDeCompraENT getSolicitudCompra() {
		return solicitudCompra;
	}
	public void setSolicitudCompra(SolicitudDeCompraENT solicitudCompra) {
		this.solicitudCompra = solicitudCompra;
	}
	public RodamientoENT getRodamiento() {
		return rodamiento;
	}
	public void setRodamiento(RodamientoENT rodamiento) {
		this.rodamiento = rodamiento;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
