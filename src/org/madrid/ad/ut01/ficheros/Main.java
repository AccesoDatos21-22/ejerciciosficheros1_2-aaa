package org.madrid.ad.ut01.ficheros;

public class Main {
	public static final String QUIJOTE = "bin/org/madrid/ad/ut01/ficheros/assets/el_quijote.txt";
	
	public static void main(String[] args) {
		System.out.println("Directorio actual: " + System.getProperty("user.dir"));
		
		FicherosTexto6 ficherosTexto6 = new FicherosTexto6();
		
		// Ejercicio 6
		System.out.println("El Quijote tiene " + ficherosTexto6.contarPalabras(QUIJOTE) + " palabras");
		
		// Padding
		System.out.println("\n-----\n");
	}
}
