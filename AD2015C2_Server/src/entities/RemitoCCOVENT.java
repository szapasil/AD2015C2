package entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="remitosCCOV")
public class RemitoCCOVENT {

	@Id
	private int numero;
	private Date fecha;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ov")
	private OVENT ov;
	
	@OneToMany(cascade=CascadeType.ALL ,fetch=FetchType.LAZY ,mappedBy="id.remito")
	private List<SolicitudDeCompraENT> solicitudesDeCompra;
	
	@OneToMany(cascade=CascadeType.ALL ,fetch=FetchType.LAZY ,mappedBy="id.remito")
	private List<ItemRCCOVENT> items;

	public RemitoCCOVENT() {
		
	}
	
	public RemitoCCOVENT(int numero, Date fecha, OVENT ov) {
		super();
		this.numero = numero;
		this.fecha = fecha;
		this.ov = ov;
		this.solicitudesDeCompra = new ArrayList<SolicitudDeCompraENT>();
		this.items = new ArrayList<ItemRCCOVENT>();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<SolicitudDeCompraENT> getSolicitudesDeCompra() {
		return solicitudesDeCompra;
	}

	public void setSolicitudesDeCompra(
			List<SolicitudDeCompraENT> solicitudesDeCompra) {
		this.solicitudesDeCompra = solicitudesDeCompra;
	}

	public List<ItemRCCOVENT> getItems() {
		return items;
	}

	public void setItems(List<ItemRCCOVENT> items) {
		this.items = items;
	}

	public OVENT getOv() {
		return ov;
	}

	public void setOv(OVENT ov) {
		this.ov = ov;
	}

}
