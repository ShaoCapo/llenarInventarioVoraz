import java.util.*;

public class Pruebas {
									// id:   0       1       2       3       4       5       6
	private static int[][] tamObjetos = { {3, 1}, {1, 1}, {2, 1}, {3, 2}, {1, 1}, {1, 2}, {2, 2},
							  			//   7       8       9      10      11      12      13      14
									   	  {1, 1}, {3, 1}, {1, 1}, {1, 3}, {1, 1}, {1, 1}, {3, 2}, {1, 1}
	};
	
	private static int[][] valor = {
		// id:  0     1    2    3   4   5    6   7   8   9  10  11  12    13    14
			{5000,   10,  20,   1,  1, 10, 100,  1, 50,  1, 40,  1,  1, 1000,    5},
			{ 100,   15,   2,  24, 30,  5,   1,  1,  3, 25, 50, 20, 10,    1, 1000},
			{  10,  200,  50,   1, 25, 40,  15,  5, 10,  1, 10,  2, 90,  100,  200},
			{1000,    1,  15, 200,  1, 20,  80,  1, 60,  1, 90,  1,  5,  200,    2},
			{   5, 1000, 300,  80, 90,  1, 400, 10, 25, 70, 25, 10, 35,   50,   10}
	};
			
	public static void main(String[] args) {	
		ArrayList<Objeto> listaObjetos = new ArrayList<Objeto>();
		Inventario inventario = new Inventario();

		for (int v = 0; v < valor.length; v++) {
			listaObjetos.clear();
			inventario.limpiar();
			for (int t = 0; t < tamObjetos.length; t++) 
				listaObjetos.add(new Objeto(t,tamObjetos[t][0],tamObjetos[t][1],valor[v][t]));	
			ArrayList<Objeto> solucion = Principal.llenarInventario(listaObjetos, inventario);

			System.out.println("PRUEBA " + (v+1));
			if (solucion != null) 
				mostrarSolucion(solucion, inventario);
			else
				System.out.println("    Tu método no ha incluido ningún objeto en el inventario.\n");
		}
	}
	
	public static void mostrarSolucion(ArrayList<Objeto> solucion, Inventario inventario) {
		System.out.println("Objetos en orden de entrada:");
		for (int i = 0; i < solucion.size(); i++)
			System.out.print(solucion.get(i).getId() + " ");
		System.out.println("\n\nInventario:");
		inventario.mostrar();
		int vTotal = 0;
		for (int i = 0; i < solucion.size(); i++){
			vTotal = vTotal + solucion.get(i).getValor();
		}
		System.out.println("El valor total de los objetos del inventario es de: " + vTotal);
		System.out.println();
	}
}
