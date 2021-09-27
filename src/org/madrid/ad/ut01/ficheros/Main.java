package org.madrid.ad.ut01.ficheros;

public class Main {
	public static final String QUIJOTE = "bin/org/madrid/ad/ut01/ficheros/assets/el_quijote.txt";
	
	public static void main(String[] args) {
		System.out.println("Directorio actual: " + System.getProperty("user.dir"));
		
		FicherosTexto ficherosTexto = new FicherosTexto();
		
		// Ejercicio 2
		ficherosTexto.leer(QUIJOTE);
		
		// Padding
		System.out.println("\n-----\n");
		
		// Ejercicio 4test
		System.out.println("El Quijote contiene " + ficherosTexto.contarCaracteres(QUIJOTE) + " caracteres");
	}
}
