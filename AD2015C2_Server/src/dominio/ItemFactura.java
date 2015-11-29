package dominio;

import java.text.DecimalFormat;

public class ItemFactura {
private Rodamiento rodamiento;
private int cantidad;
private float precioUnitario;
public ItemFactura () {
	super();
	}
public ItemFactura (Rodamiento rodamiento, int cantidad, float precioUnitario, float precioTotal) {
	super();
	this.rodamiento=rodamiento;
	this.cantidad= cantidad;
	this.precioUnitario=precioUnitario;
	}
public Rodamiento getRodamiento() {
	return rodamiento;
}
public void setRodamiento(Rodamiento rodamiento) {
	this.rodamiento = rodamiento;
}
public int getCantidad() {
	return cantidad;
}
public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}
public float getPrecioUnitario() {
	return precioUnitario;
}
public void setPrecioUnitario(float precioUnitario) {
	this.precioUnitario = precioUnitario;
}
public float calcularTotalItemFloat () {
	return (this.cantidad * this.precioUnitario);
}
}
