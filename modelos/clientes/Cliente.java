package clientes;

public class Cliente {

	private int ID;

	private String nombreApellidos;

	private boolean acompannante;

	private int edad;

	private int telef;

	// private ArrayList<String> tiposOffers;

	// private HashMap<Oferta, Integer> tiposOfferCant;

	// private ControlOffers controlOf;

	public Cliente(int ID, String nombreApellidos, boolean acompannante, int edad, int telef) {
		this.ID = ID;
		this.nombreApellidos = nombreApellidos;
		this.acompannante = acompannante;
		this.edad = edad;
		this.telef = telef;
		// tiposOffers = new ArrayList<String>();
		// tiposOfferCant = new HashMap<Oferta, Integer>();

	}

	public int getID() {
		return this.ID;
	}

	public String getNombre() {
		return this.nombreApellidos;
	}

	public boolean getAcompannante() {
		return this.acompannante;
	}

	public int getEdad() {
		return this.edad;
	}

	public int getTelefono() {
		return this.telef;
	}

	/*
	 * public HashMap<Oferta, Integer> getTiposOfertasCant() { return
	 * this.tiposOfferCant; }
	 */
	public void setID(int id) {
		ID = id;
	}

	public void setNombre(String name) {
		nombreApellidos = name;
	}

	public void setAcompannante(boolean acomp) {
		acompannante = acomp;
	}

	public void setEdad(int ed) {
		edad = ed;
	}

	public void setTelef(int tel) {
		telef = tel;
	}

	/*
	 * public ArrayList<String> getCadenaOfCant() {
	 * 
	 * for (Map.Entry<Oferta, Integer> entrada : tiposOfferCant.entrySet()) {
	 * 
	 * Oferta o = entrada.getKey(); int c = entrada.getValue();
	 * 
	 * String s = o.getNombre() + "   " + o.getPrecio() + "   " + c;
	 * 
	 * tiposOffers.add(s);
	 * 
	 * } return tiposOffers; }
	 */

}
