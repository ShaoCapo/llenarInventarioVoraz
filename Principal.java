import java.util.*;

public class Principal {

	public static ArrayList<Objeto> llenarInventario(ArrayList<Objeto> candidatos, Inventario inventario) {
		// Desde este algoritmo se debe llamar a seleccionarCandidato() y a esCandidatoFactible()
		ArrayList<Objeto> solucion = new ArrayList<Objeto>(); // INICIALIZA SOLUCION
		Objeto candidato;

		while (!esSolucion(inventario) && (quedanCandidatos(candidatos))){
			candidato = seleccionarCandidato(candidatos);
			candidatos.remove(candidato);
			if (esCandidatoFactible(candidato,inventario)) {
				anyadirCandidato(candidato,inventario);
				solucion.add(candidato);
			}
		}
		if (esSolucion(inventario))
			return solucion;
		else
			return null;
	}
	
	private static Objeto seleccionarCandidato(ArrayList<Objeto> candidatos) {
		Objeto objMAX = new Objeto(0, 0, 0, 0);
		double beneficioMAX = Integer.MIN_VALUE;

		// La tercera estrategia, que es la óptima, es tomar siempre el objeto que proporcione mayor beneficio
		// por unidad de peso
		for (Objeto objeto : candidatos) {
			double beneficio = objeto.getValor() / (objeto.getAlto() * objeto.getAncho());
			if(beneficio > beneficioMAX){
				beneficioMAX = beneficio;
				objMAX = objeto;
			}
		}
		return objMAX;
	}
	
	private static boolean esCandidatoFactible(Objeto candidato, Inventario inventario) {

		boolean esFactible = true; boolean enc = true;

		for (int f = 0; f < inventario.getN(); f++) {
			for (int c = 0; c < inventario.getN(); c++) {
				if(inventario.getCelda(f, c) == -1){ // ENCONTRAMOS EL PRIMER HUECO LIBRE
					//RECORREMOS LA SUBMATRIZ COMPUESTA POR EL CANDIDATO
					for(int f1 = f; f1 < f + candidato.getAlto() && enc; f1++){
						for(int c1 = c; c1 < c + candidato.getAncho(); c1++){
							if(inventario.getCelda(f, c) != -1)
								enc = false;
						}
					}
				}
			}
		}
		return esFactible;
	}

	private static boolean quedanCandidatos(ArrayList<Objeto> candidatos){
		return !candidatos.isEmpty();
	}

	private static boolean esSolucion(Inventario inventario){
		boolean lleno = true;
		for (int f = 0; f < inventario.getN() && lleno; f++)
			for (int c = 0; c < inventario.getN() && lleno; c++)
				if(inventario.getCelda(f, c) == -1)
					lleno = false;
		return lleno; // arreglar
		}

	private static boolean anyadirCandidato(Objeto candidato, Inventario inventario) {
		// añade el elemento a la matriz solucion => inventario
		boolean esValido = true;

		for (int f = 0; f < candidato.getAlto(); f++)
			for (int c = 0; c < candidato.getAncho(); c++)
				if(inventario.getCelda(f, c) == -1)
					inventario.setCelda(f, c, candidato.getId());
		return true;
	}
}
