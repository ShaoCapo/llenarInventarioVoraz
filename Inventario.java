public class Inventario {

	private final int N = 5;
	private int[][] celda;
	
	public Inventario() {
		// Crea un array de tamaño NxN y lo inicializa
		this.celda = new int[this.N][this.N];
		limpiar();
	}
	
	public int getN() {
		// Devuelve el valor de N
		return this.N;
	}
	
	public int getCelda(int c, int f) {
		// Devuelve el valor de la celda en la posición (c,f)
		return this.celda[c][f];
	}
	
	public void setCelda(int c, int f, int valor) {
		// Asigna un valor a la celda en la posición (c,f)		
		this.celda[c][f] = valor;
	}
	
	public void limpiar() {
		// Inicializa el array con valor -1 en todas sus celdas
		for (int f = 0; f < this.N; f++)
			for (int c = 0; c < this.N; c++)
				this.celda[c][f] = -1;		
	}
	
	public void mostrar() {
		// Muestra el contenido del array
	    for (int f = 0; f < this.N; f++) {
		    for (int c = 0; c < this.N; c++)
		    	System.out.print(this.celda[c][f] + "\t");
		    System.out.println();
	    }
	}
}
