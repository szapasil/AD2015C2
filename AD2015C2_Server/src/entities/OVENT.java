package entities;

import java.util.List;

import javax.persistence.*;

import dominio.Cliente;
import dominio.Cotizacion;
import dominio.Factura;
import dominio.OrdenDeCompra;
import dominio.OrdenDePedido;
import dominio.Remito;
import dominio.SolicitudCotizacion;

@Entity
@Table(name="oficinasDeVenta")
public class OVENT {

	@Id
	@Column (name="numero_sucursal", nullable=false)
	private int numeroSucursal;
	@Column
	private String nombreSucursal;
	
	
	public OVENT() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OVENT(int numeroSucursal, String nombreSucursal) {
		super();
		this.numeroSucursal = numeroSucursal;
		this.nombreSucursal = nombreSucursal;
	}
	public int getNumeroSucursal() {
		return numeroSucursal;
	}
	public void setNumeroSucursal(int numeroSucursal) {
		this.numeroSucursal = numeroSucursal;
	}
	public String getNombreSucursal() {
		return nombreSucursal;
	}
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}
	
	
}
