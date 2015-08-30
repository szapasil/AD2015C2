package dominio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="solicitudesDeCompra")
public class SolicitudDeCompra {
	
	private int numero;
	private Date fecha;
	private float precioTotal;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="item")
	private List<ItemSC> items;

	public SolicitudDeCompra(int numero, Date fecha, float precioTotal,
			List<ItemSC> items) {
		super();
		this.numero = numero;
		this.fecha = fecha;
		this.precioTotal = precioTotal;
		this.items  = new ArrayList<ItemSC>();
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

	public float getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}

	public List<ItemSC> getItems() {
		return items;
	}

	public void setItems(List<ItemSC> items) {
		this.items = items;
	}
	
}
