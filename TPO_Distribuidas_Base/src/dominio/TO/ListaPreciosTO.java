package dominio.TO;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class ListaPreciosTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Date fecha;
	private Date vigencia;
	private String descripcion;
	private List<ItemLPTO> items;
	
	public ListaPreciosTO(Date fecha, Date vigencia, String descripcion, List<ItemLPTO> items) {
		super();
		this.fecha = fecha;
		this.vigencia = vigencia;
		this.descripcion = descripcion;
		this.items = items;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getVigencia() {
		return vigencia;
	}

	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<ItemLPTO> getItems() {
		return items;
	}

	public void setItems(List<ItemLPTO> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "ListaPreciosTO [fecha=" + fecha + ", vigencia=" + vigencia 
				+ ", descripcion=" + descripcion + ", items=" + items + "]";
	}

}
