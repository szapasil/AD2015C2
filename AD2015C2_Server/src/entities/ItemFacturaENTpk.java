package entities;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class ItemFacturaENTpk implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4481989443794573466L;

	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="numero_factura", nullable = false)
	private FacturaENT factura;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="codRodamiento", nullable = false)
	private RodamientoENT rodamiento;

	public ItemFacturaENTpk() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemFacturaENTpk(FacturaENT factura, RodamientoENT rodamiento) {
		super();
		this.factura = factura;
		this.rodamiento = rodamiento;
	}

	public FacturaENT getFactura() {
		return factura;
	}

	public void setFactura(FacturaENT factura) {
		this.factura = factura;
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
