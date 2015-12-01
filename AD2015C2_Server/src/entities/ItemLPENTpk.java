package entities;

import java.io.Serializable;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ItemLPENTpk implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="nroLP", nullable = false)
	private ListaPreciosENT listaPrecios;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codRodamiento", nullable = false)
	private RodamientoENT rodamiento;

	public ItemLPENTpk() {
		
	}
	
	public ItemLPENTpk(ListaPreciosENT listaPrecios, RodamientoENT rodamiento) {
		super();
		this.listaPrecios = listaPrecios;
		this.rodamiento = rodamiento;
	}

	public ListaPreciosENT getListaPrecios() {
		return listaPrecios;
	}

	public void setListaPrecios(ListaPreciosENT listaPrecios) {
		this.listaPrecios = listaPrecios;
	}

	public RodamientoENT getRodamiento() {
		return rodamiento;
	}

	public void setRodamiento(RodamientoENT rodamiento) {
		this.rodamiento = rodamiento;
	}

}
