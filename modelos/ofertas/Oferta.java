package ofertas;

public class Oferta {

	private String nombre;

	private float precio;

	private int CodigoOf;

	public Oferta(int CodigoOf, String nombre, float precio) {

		this.CodigoOf = CodigoOf;
		this.nombre = nombre;
		this.precio = precio;

	}

	public int getCodigo() {
		return CodigoOf;
	}

	public float getPrecio() {
		return precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setCodigo(int i) {
		CodigoOf = i;
	}

	public void setPrecio(float i) {
		precio = i;
	}

	public void setNombre(String s) {
		nombre = s;
	}

	public String ToString() {
		return nombre + " " + precio;
	}
}
