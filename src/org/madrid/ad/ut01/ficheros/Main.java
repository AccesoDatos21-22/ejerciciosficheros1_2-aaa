package org.madrid.ad.ut01.ficheros;

import java.io.IOException;

public class Main {
	public static final String QUIJOTE = "bin/org/madrid/ad/ut01/ficheros/assets/el_quijote.txt";
	
	public static void main(String[] args) {
		alberto();
		fernando();
	}
	
	private static void alberto() {
		
		System.out.println("Directorio actual: " + System.getProperty("user.dir"));
		// Padding
		System.out.println("\n-----\n");
		
		FicherosTexto ficherosTexto = new FicherosTexto();
		
		// Ejercicio 2
		ficherosTexto.leerBuffered(QUIJOTE);
		// Padding
		System.out.println("\n-----\n");
		
		// Ejercicio 4
		System.out.println("El Quijote tiene " + ficherosTexto.contarCaracteresVisibles(QUIJOTE) + " caracteres visibles");
		// Padding
		System.out.println("\n-----\n");
		
		// Ejercicio 6
		System.out.println("El Quijote tiene " + ficherosTexto.contarPalabras(QUIJOTE) + " palabras");
		// Padding
		System.out.println("\n-----\n");
		
		// Ejercicio 8
		ficherosTexto.palabraMasLarga(QUIJOTE);
		// Padding
		System.out.println("\n-----\n");
		
		// Ejercicio 10
		ficherosTexto.frecuenciaLetras(QUIJOTE);
	}
	
	public static void fernando() {
		FicherosTexto ficherosTexto = new FicherosTexto();
		
		String ruta = "bin/org/madrid/ad/ut01/ficheros/assets/el_quijote.txt";
		//ej1------------------
		ficherosTexto.leer(ruta);
		//ej3-----------------------------
		int resultado = ficherosTexto.contarCaracteres(ruta);
		System.out.println(resultado);
		//ej5-------------
		int res = ficherosTexto.contarLineas(ruta);
		System.out.println(res);
		//ej9------------------------
		ficherosTexto.frecuenciaVocales(ruta);
		
		//el ej 7 me supero. no lo consegui acabar, consegui aislar la palabra pero no consegui comparar las letras, me frustre
		ficherosTexto.palabrasPentavocalica(ruta);
	}
}
