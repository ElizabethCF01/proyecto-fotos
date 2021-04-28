package ofertas;

public class Oferta {
	private String nombre;
	private int precio;

	public Oferta(String n,int p ) {
	
		nombre=n;
		precio=p;
		
	}
	
	public int getPrecio() {
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
