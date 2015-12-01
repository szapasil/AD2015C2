package entities;

import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemRemitoENTpk implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4481989443794573466L;

	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="numero_remito", nullable = false)
	private RemitoENT remito;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="codRodamiento", nullable = false)
	private RodamientoENT rodamiento;

	public ItemRemitoENTpk() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemRemitoENTpk(RemitoENT remito, RodamientoENT rodamiento) {
		super();
		this.remito = remito;
		this.rodamiento = rodamiento;
	}

	public RemitoENT getRemito() {
		return remito;
	}

	public void setRemito(RemitoENT remito) {
		this.remito = remito;
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

