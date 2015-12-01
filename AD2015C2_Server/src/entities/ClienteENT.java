package entities;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class ClienteENT {
	
	@Id
	private String cuil;
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="numero_sucursal", nullable = false)
	private OVENT ov; 
	private String razonSocial;
	private String direccion;
	//@OneToMany(cascade=CascadeType.ALL)
	//@JoinColumn(name="cuilCliente")
	//private List<CondPagoENT> condicionesPago;
	private java.sql.Date fechaRegistro;
	private float porcentajeDescuento;
	private String condicionesPago;
	private String condicionIVA;
	
	//@OneToMany(cascade=CascadeType.ALL)
	//@JoinColumn(name="cuilCliente")
	//private List<SolicitudCotizacionENT> solicitudesCotizacion;
	
public ClienteENT(String cuil, OVENT ov, String razonSocial,
			String direccion, Date fechaRegistro, float porcentajeDescuento,
			String condicionesPago, String condicionIVA) {
		super();
		this.cuil = cuil;
		this.ov = ov;
		this.razonSocial = razonSocial;
		this.direccion = direccion;
		this.fechaRegistro = fechaRegistro;
		this.porcentajeDescuento = porcentajeDescuento;
		this.condicionesPago = condicionesPago;
		//this.solicitudesCotizacion = solicitudesCotizacion;
		this.condicionIVA = condicionIVA;
	}
public ClienteENT() {
		super();
		// TODO Auto-generated constructor stub
	}
public String getCuil() {
	return cuil;
}
public void setCuil(String cuil) {
	this.cuil = cuil;
}
public OVENT getOv() {
	return ov;
}
public void setOv(OVENT ov) {
	this.ov = ov;
}

public String getCondicionIVA() {
	return condicionIVA;
}
public void setCondicionIVA(String condicionIVA) {
	this.condicionIVA = condicionIVA;
}
public String getRazonSocial() {
	return razonSocial;
}
public void setRazonSocial(String razonSocial) {
	this.razonSocial = razonSocial;
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
public java.sql.Date getFechaRegistro() {
	return fechaRegistro;
}
public void setFechaRegistro(java.sql.Date fechaRegistro) {
	this.fechaRegistro = fechaRegistro;
}
public float getPorcentajeDescuento() {
	return porcentajeDescuento;
}
public void setPorcentajeDescuento(float porcentajeDescuento) {
	this.porcentajeDescuento = porcentajeDescuento;
}
public String getCondicionesPago() {
	return condicionesPago;
}
public void setCondicionesPago(String condicionesPago) {
	this.condicionesPago = condicionesPago;
}





/* TODO: Ver esta operacion*/
public int calcularAntiguedad(){
	
	int ant = 0;
	
	
	return ant;
}

}
