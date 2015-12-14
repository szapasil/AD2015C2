package entities;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class ItemCotizacionENTpk implements Serializable {
	private static final long serialVersionUID = -2678387704362020180L;

	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="numero_cotizacion", nullable = false)
	private CotizacionENT cotizacion;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="codRodamiento", nullable = false)
	private RodamientoENT rodamiento;

	public ItemCotizacionENTpk() {
		super();
	}

	public ItemCotizacionENTpk(CotizacionENT cotizacion, RodamientoENT rodamiento) {
		super();
		this.cotizacion = cotizacion;
		this.rodamiento = rodamiento;
	}

	public CotizacionENT getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(CotizacionENT cotizacion) {
		this.cotizacion = cotizacion;
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
