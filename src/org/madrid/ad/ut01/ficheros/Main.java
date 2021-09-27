package org.madrid.ad.ut01.ficheros;

public class Main {
	public static final String QUIJOTE = "bin/org/madrid/ad/ut01/ficheros/assets/el_quijote.txt";
	
	public static void main(String[] args) {
		System.out.println("Directorio actual: " + System.getProperty("user.dir"));
		
		FicherosTexto10 ficherosTexto10 = new FicherosTexto10();
		
		// Ejercicio 10
		ficherosTexto10.frecuenciaLetras(QUIJOTE);
		
		// Padding
		System.out.println("\n-----\n");
	}
}
