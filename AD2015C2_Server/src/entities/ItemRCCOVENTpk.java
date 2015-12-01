package entities;

import java.io.Serializable;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ItemRCCOVENTpk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="nroRemito", nullable = false)
	private RemitoCCOVENT remito;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codRodamiento", nullable = false)
	private RodamientoENT rodamiento;

	public ItemRCCOVENTpk() {
		
	}
	
	public ItemRCCOVENTpk(RemitoCCOVENT remito, RodamientoENT rodamiento) {
		super();
		this.remito = remito;
		this.rodamiento = rodamiento;
	}

	public RemitoCCOVENT getRemito() {
		return remito;
	}

	public void setRemito(RemitoCCOVENT remito) {
		this.remito = remito;
	}

	public RodamientoENT getRodamiento() {
		return rodamiento;
	}

	public void setRodamiento(RodamientoENT rodamiento) {
		this.rodamiento = rodamiento;
	}

}
