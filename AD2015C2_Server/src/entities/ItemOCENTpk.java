package entities;

import java.io.Serializable;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ItemOCENTpk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="nroOC", nullable = false)
	private OrdenDeCompraENT oc;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codRodamiento", nullable = false)
	private RodamientoENT rodamiento;

	public ItemOCENTpk() {
		
	}
	
	public ItemOCENTpk(OrdenDeCompraENT oc, RodamientoENT rodamiento) {
		super();
		this.oc = oc;
		this.rodamiento = rodamiento;
	}

	public OrdenDeCompraENT getOrdenDeCompra() {
		return oc;
	}

	public void setOrdenDeCompra(OrdenDeCompraENT oc) {
		this.oc = oc;
	}

	public RodamientoENT getRodamiento() {
		return rodamiento;
	}

	public void setRodamiento(RodamientoENT rodamiento) {
		this.rodamiento = rodamiento;
	}

}
