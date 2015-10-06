package dominio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import dao.ClienteDAO;




public class Cliente {
	
	
	private String razonSocial;
	private String direccion;

	private String cuil;
	private CondPago condicionesPago;
	private java.sql.Date fechaRegistro;
	private List<SolicitudCotizacion> solicitudesCotizacion;

	
	
	public Cliente(String razonSocial, String cuil, Date fechaRegistro, CondPago condicionesPago, String direccion,
		       List<SolicitudCotizacion> solicitudesContizacion) {
	super();
	this.razonSocial = razonSocial;
	this.cuil = cuil;
	this.fechaRegistro = fechaRegistro;
	this.condicionesPago = condicionesPago;
	this.direccion = direccion;
	this.solicitudesCotizacion =  new ArrayList<SolicitudCotizacion>();
}

public Cliente()
{
	
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

public String getCuil() {
	return cuil;
}

public void setCuil(String cuil) {
	this.cuil = cuil;
}

public CondPago getCondicionesPago() {
	return condicionesPago;
}

public void setCondicionesPago(CondPago condicionesPago) {
	this.condicionesPago = condicionesPago;
}

public Date getFechaRegistro() {
	return fechaRegistro;
}

public void setFechaRegistro(java.sql.Date fechaRegistro) {
	this.fechaRegistro = fechaRegistro;
}

public List<SolicitudCotizacion> getSolicitudesCotizacion() {
	return solicitudesCotizacion;
}

public void setSolicitudesCotizacion(
		List<SolicitudCotizacion> solicitudesCotizacion) {
	this.solicitudesCotizacion = solicitudesCotizacion;
}
	
public static Cliente buscarClienteDAO(String cuil) {
	return ClienteDAO.getInstancia().BuscarCliente(cuil);
}
	
/* TODO: Ver esta operacion*/
public int calcularAntiguedad(){
	
	int ant = 0;
	
	
	return ant;
}

}
