package ofertas;

public class Oferta {
	private String nombre;
	private float precio;

	public Oferta(String n,float p ) {
	
		nombre=n;
		precio=p;
		
	}
	
	public float getPrecio() {
		return precio;
	}
	public String getNombre() {
		return nombre;
	}
	
	public void setPrecio(int i) {
		precio=i;
	}
	public void setNombre(String s) {
		nombre=s;
	}
}
