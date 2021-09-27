package org.madrid.ad.ut01.ficheros;

public class Main {
	public static final String QUIJOTE = "bin/org/madrid/ad/ut01/ficheros/assets/el_quijote.txt";
	
	public static void main(String[] args) {
		System.out.println("Directorio actual: " + System.getProperty("user.dir"));
		
		FicherosTexto8 ficherosTexto8 = new FicherosTexto8();
		
		// Ejercicio 8
		ficherosTexto8.palabraMasLarga(QUIJOTE);
		
		// Padding
		System.out.println("\n-----\n");
	}
}
