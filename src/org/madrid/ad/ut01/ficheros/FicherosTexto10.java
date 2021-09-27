package org.madrid.ad.ut01.ficheros;

import org.madrid.ad.ut01.ficheros.interfaces.InterfazFicherosTexto;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Alberto Jiménez
 * @date 2021-9-27
 * @version v1
 * @license GPLv3
 */
public class FicherosTexto10 implements InterfazFicherosTexto{
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
		// TODO Auto-generated method stub
		return 0;
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
		Map<Integer, Integer> letters = new HashMap<>();
		int enneCount = 0;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(rutaFichero))) {
			while (true) {
				int charInt = reader.read();
				
				// Conversor de acentos a caracteres planos; en minúscuals y mayúscuals respectivamente
				switch (charInt) {
					// A
					case 225:
					case 193:
						charInt = 'a';
						
						break;
					// E
					case 233:
					case 201:
						charInt = 'e';
						
						break;
					// I
					case 105:
					case 205:
						charInt = 'i';
						
						break;
					// O
					case 243:
					case 211:
						charInt = 'o';
						
						break;
					// U
					case 250:
					case 218:
						charInt = 'u';
						
						break;
				}
				
				if (isLetter(charInt)) {
					// Ñ se suma completamente por separado porque da muchos problemas
					if (charInt == 209 || charInt == 241) {
						enneCount++;
					} else {
						Integer value = letters.get(charInt);
						
						if (value != null) {
							letters.put(charInt, ++value);
						} else {
							letters.put(charInt, 1);
						}
					}
				}
				
				if (charInt == -1) {
					break;
				}
			}
			
			for (Map.Entry<Integer, Integer> entry : letters.entrySet()) {
				int key = entry.getKey();
				
				System.out.println("Conteo de " + (char) key + ": " + entry.getValue());
			}
			
			// Ñ se muestra por separado para evitar problemas
			if (enneCount > 0) {
				System.out.println("Conteo de ñ: " + enneCount);
			}
		} catch (FileNotFoundException e) {
			System.err.println("Fichero " + rutaFichero + " no encontrado");
			
			return -1;
		} catch (IOException e) {
			System.err.println("El fichero " + rutaFichero + " no se pudo leer");
			
			return -1;
		}
		
		return 0;
	}
	
	private boolean isLetter(int charInt) {
		// Mayúsculas
		if ((charInt >= 97 && charInt <= 123) || charInt == 209) {
			return true;
		}
		
		// Repetimos de nuevo en minúsculas
		charInt -= 32;
		
		if ((charInt >= 97 && charInt <= 123) || charInt == 209) {
			return true;
		}
		
		// Acentos y ñ
		switch (charInt) {
			// Minúsculas
			case 225:
			case 233:
			case 105:
			case 243:
			case 250:
			// ñ
			case 209:
			
			// Mayúsculas
			case 193:
			case 201:
			case 205:
			case 211:
			case 218:
			// Ñ
			case 241:
				return true;
			default:
				return false;
		}
	}
}
