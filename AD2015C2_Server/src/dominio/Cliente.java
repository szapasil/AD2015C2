package dominio;

import hbt.HibernateDAO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import dao.ClienteDAO;
import entities.ClienteENT;

public class Cliente {
	
	private String razonSocial;
	private String direccion;
	private String cuil;
	private List<CondPago> condicionesPago;
	private java.sql.Date fechaRegistro;
	private List<SolicitudCotizacion> solicitudesCotizacion;

	
	
public Cliente( String cuil, String razonSocial, String direccion) {
	super();
	this.razonSocial = razonSocial;
	this.cuil = cuil;
	long time = System.currentTimeMillis();
	this.fechaRegistro  = new java.sql.Date(time);
	this.condicionesPago = new ArrayList<CondPago>();
	this.direccion = direccion;
	this.solicitudesCotizacion =  new ArrayList<SolicitudCotizacion>();
	ClienteENT cliENT = toENT();
	HibernateDAO.getInstancia().saveOrUpdate(cliENT);
}

public Cliente(){
	
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

public List<CondPago> getCondicionesPago() {
	return condicionesPago;
}

public void setCondicionesPago(List<CondPago> condicionesPago) {
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
	
	ClienteENT cliENT =  ClienteDAO.getInstancia().BuscarCliente(cuil);
	if(cliENT!=null)
		return toDOM(cliENT);
	return null;
}
	




public void modificar(String razonSocial, String direccion) {
	if(!direccion.isEmpty())
		this.direccion = direccion;
	if(!razonSocial.isEmpty())
		this.razonSocial = razonSocial; 
	ClienteENT cliENT  = toENT();
	HibernateDAO.getInstancia().saveOrUpdate(cliENT);
}


private static Cliente toDOM(ClienteENT cliENT) {
	return new Cliente(cliENT.getCuil(), cliENT.getRazonSocial(), cliENT.getDireccion());
}

public ClienteENT toENT() {
	return new ClienteENT(cuil, razonSocial, direccion);
}





/* TODO: Ver esta operacion*/
public int calcularAntiguedad(){
	
	int ant = 0;
	
	
	return ant;
}

public void baja() {
	ClienteENT cliENT = toENT();
	HibernateDAO.getInstancia().saveOrUpdate(cliENT);
	
}





}
