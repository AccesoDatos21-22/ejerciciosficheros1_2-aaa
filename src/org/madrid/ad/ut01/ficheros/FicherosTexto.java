package org.madrid.ad.ut01.ficheros;

import org.madrid.ad.ut01.ficheros.interfaces.InterfazFicherosTexto;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author Alberto Jiménez
 * @date 2021-9-27
 * @version v1
 * @license GPLv3
 */
public class FicherosTexto implements InterfazFicherosTexto{
	/**
	 * Ejercicio 2
	 * @param rutaFichero
	 */
	@Override
	public void leer(String rutaFichero) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Ejercicio 4
	 * @param rutaFichero
	 * @return
	 */
	@Override
	public int contarCaracteres(String rutaFichero) {
		int count = 0;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(rutaFichero))) {
			while (true) {
				int charInt = reader.read();
				
				if (charInt == -1) {
					break;
				}
				
				if ((char)charInt == ' ') { //TODO salto
					continue;
				}
				
				count++;
			}
		} catch (FileNotFoundException e) {
			System.err.println("Fichero " + rutaFichero + " no encontrado");
		} catch (IOException e) {
			System.err.println("El fichero " + rutaFichero + " no se pudo leer");
		}
		
		return count;
	}
	
	@Override
	public int contarLineas(String rutaFichero) {
		return 0;
	}
	
	/**
	 * Ejercicio 6
	 * @param rutaFichero
	 * @return
	 */
	@Override
	public int contarPalabras(String rutaFichero) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int palabrasPentavocalica(String rutaFichero) {
		return 0;
	}
	
	/**
	 * Ejercicio 8
	 * @param rutaFichero
	 * @return
	 */
	@Override
	public int palabraMasLarga(String rutaFichero) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int frecuenciaVocales(String rutaFichero) {
		return 0;
	}
	
	/**
	 * Ejercicio 10
	 * @param rutaFichero
	 * @return
	 */
	@Override
	public int frecuenciaLetras(String rutaFichero) {
		// TODO Auto-generated method stub
		return 0;
	}
}
