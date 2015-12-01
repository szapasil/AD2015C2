package dominio;

import java.util.Date;
import java.util.List;

public class Remito {
	private int numero;
	private Factura factura;
	private Cliente cliente;
	private Date fechaEmision;
	private List<ItemRemito> items;
}
