package entities;

import java.io.Serializable;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ItemRPCCENTpk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="nroRemito", nullable = false)
	private RemitoProvCCENT remito;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codRodamiento", nullable = false)
	private RodamientoENT rodamiento;

	public ItemRPCCENTpk() {
		
	}
	
	public ItemRPCCENTpk(RemitoProvCCENT remito, RodamientoENT rodamiento) {
		super();
		this.remito = remito;
		this.rodamiento = rodamiento;
	}

	public RemitoProvCCENT getRemito() {
		return remito;
	}

	public void setRemito(RemitoProvCCENT remito) {
		this.remito = remito;
	}

	public RodamientoENT getRodamiento() {
		return rodamiento;
	}

	public void setRodamiento(RodamientoENT rodamiento) {
		this.rodamiento = rodamiento;
	}

}
