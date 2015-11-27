package entities;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class ItemSolCotizacionENTpk implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2678387704362020180L;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="numero_Solicitud", nullable = false)
	private SolicitudCotizacionENT solicitudCotizacion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codRodamiento", nullable = false)
	private RodamientoENT rodamiento;
	
	public SolicitudCotizacionENT getSolicitudCotizacion() {
		return solicitudCotizacion;
	}
	
	public void setSolicitudCotizacion(SolicitudCotizacionENT solicitudCotizacion) {
		this.solicitudCotizacion = solicitudCotizacion;
	}
	
	public RodamientoENT getRodamiento() {
		return rodamiento;
	}
	
	public void setRodamiento(RodamientoENT rodamiento) {
		this.rodamiento = rodamiento;
	}
	
	public ItemSolCotizacionENTpk() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ItemSolCotizacionENTpk(SolicitudCotizacionENT solicitudCotizacion,
			RodamientoENT rodamiento) {
		super();
		this.solicitudCotizacion = solicitudCotizacion;
		this.rodamiento = rodamiento;
	}
	
}
