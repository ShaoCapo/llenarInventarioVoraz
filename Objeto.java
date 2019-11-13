public class Objeto {

	private int id;
	private int ancho;
	private int alto;
	private int valor;
	
	public Objeto(int id, int ancho, int alto, int valor) {
		// Inicializa el objeto
		this.id = id;
		this.ancho = ancho;
		this.alto = alto;
		this.valor = valor;
	}
	
	public int getId() {
		// Devuelve el Id del objeto
		return this.id;
	}
	
	public int getAncho() {
		// Devuelve el ancho del objeto
		return this.ancho;
	}
	
	public int getAlto() {
		// Devuelve el alto del objeto
		return this.alto;
	}
	
	public int getValor() {
		// Devuelve el valor del objeto
		return this.valor;
	}
}
