package org.madrid.ad.ut01.ficheros;

import org.madrid.ad.ut01.ficheros.interfaces.InterfazFicherosTexto;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Alberto Jiménez
 * @date 2021-9-27
 * @version v1
 * @license GPLv3
 */
public class FicherosTexto implements InterfazFicherosTexto{
	/*
	 * Alberto Jiménez
	 */
	
	/**
	 * Ejercicio 2
	 * Lee el fichero caracter a caracter y lo va imprimiendo en tiempo real
	 *
	 * @param rutaFichero
	 */
	public void leerBuffered(String rutaFichero) {
		try (BufferedReader reader = new BufferedReader(new FileReader(rutaFichero))) {
			while (true) {
				int charInt = reader.read();
				
				// -1 indica fin de fichero
				if (charInt == -1) {
					break;
				}
				
				System.out.print((char)charInt);
			}
		} catch (FileNotFoundException e) {
			System.err.println("Fichero " + rutaFichero + " no encontrado");
		} catch (IOException e) {
			System.err.println("El fichero " + rutaFichero + " no se pudo leer");
		}
	}
	
	/**
	 * Ejercicio 4
	 * Cuenta los caracteres
	 *
	 * @param rutaFichero
	 * @return Conteo de caracteres
	 */
	public int contarCaracteresVisibles(String rutaFichero) {
		int count = 0;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(rutaFichero))) {
			while (true) {
				int charInt = reader.read();
				
				if (charInt == -1) {
					break;
				}
				
				// Los espacios y saltos no cuentan
				if ((char)charInt == ' ' || (char)charInt == '\n') {
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
	
	/**
	 * Ejercicio 6
	 * Cuenta las palabras
	 *
	 * @param rutaFichero
	 * @return Conteo de palabras
	 */
	@Override
	public int contarPalabras(String rutaFichero) {
		int count = 0;
		boolean wordStarted = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(rutaFichero))) {
			while (true) {
				int charInt = reader.read();
				
				if (charInt == -1) {
					break;
				}
				
				// Si es una letra, la palabra ha comenzado
				if (isLetter(charInt)) {
					wordStarted = true;
				} else {
					// Si no lo es y ya había comenzado una palabra, es porque tenemos otra palabra más terminada
					if (wordStarted) {
						count++;
						
						wordStarted = false;
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("Fichero " + rutaFichero + " no encontrado");
		} catch (IOException e) {
			System.err.println("El fichero " + rutaFichero + " no se pudo leer");
		}
		
		return count;
	}
	
	/**
	 * Ejercicio 8
	 * Devuelve la palabra más larga
	 *
	 * @param rutaFichero
	 * @return 0 si funciona; -1 si no
	 */
	@Override
	public int palabraMasLarga(String rutaFichero) {
		int count = 0;
		
		String word = "";
		String longestWord = "";
		
		boolean wordStarted = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(rutaFichero))) {
			while (true) {
				int charInt = reader.read();
				
				if (charInt == -1) {
					break;
				}
				
				// Si es una letra, la palabra ha comenzado
				if (isLetter(charInt)) {
					wordStarted = true;
					word += (char) charInt;
					count = 0;
				} else {
					// Si no lo es y ya había comenzado una palabra, es porque tenemos otra palabra más terminada
					if (wordStarted) {
						count++;
						
						wordStarted = false;
						
						// Comparamos
						if (word.length() > longestWord.length()) {
							longestWord = word;
						}
						
						word = "";
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("Fichero " + rutaFichero + " no encontrado");
			
			return -1;
		} catch (IOException e) {
			System.err.println("El fichero " + rutaFichero + " no se pudo leer");
			
			return -1;
		}
		
		System.out.println("La palabra más larga es '" + longestWord + "', con " + longestWord.length() + " caracteres");
		
		return 0;
	}
	
	/**
	 * Ejercicio 10
	 * Devuevle la frecuencia de cada letra del abecedario
	 *
	 * @param rutaFichero
	 * @return 0 si funciona; -1 si no
	 */
	@Override
	public int frecuenciaLetras(String rutaFichero) {
		Map<Integer, Integer> letters = new HashMap<>();
		int enneCount = 0;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(rutaFichero))) {
			while (true) {
				int charInt = reader.read();
				
				// Conversor de acentos a caracteres planos; en minúsculas y mayúsculas, respectivamente
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
	
	/**
	 * Comprueba si se trata de una letra
	 *
	 * @param charInt
	 * @return Si es una letra
	 */
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
	
	
	/*
	 * Fernando Fernández
	 */
	@Override
	public void leer(String rutaFichero) {
		
		//opcion leer ruta , no se si el ejercicio se refiere a leer la ruta o a leer el fichero
		//con lo cual hare las dos.
		
		for(int i=0;i<=rutaFichero.length()-1;i++){
			System.out.println(rutaFichero.charAt(i));
		}
		
		File fichero = new File(rutaFichero);
		//declarar fichero
		try (FileReader fr = new FileReader(fichero)) { //crear el flujo de entrada   
			int caracter;
			while ((caracter = fr.read()) != -1) //se va leyendo un carácter
			{
				System.out.print((char) caracter);
			}
		}
		catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public int contarCaracteres(String rutaFichero) {
		int cont=0;
		
		File fichero = new File(rutaFichero);
		//declarar fichero
		try (FileReader fr = new FileReader(fichero)) { //crear el flujo de entrada   
			int caracter;
			
			while ((caracter = fr.read()) != -1) //se va leyendo un carácter
			{
				cont++;
				
			}
		}
		catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
		}
		catch (IOException e) {
			System.err.println(e);
		}
		
		return cont;
	}
	
	public int contarLineas(String rutaFichero) {
		try {
			File input = new File(rutaFichero);
			Scanner iterate = new Scanner(input);
			int numLines = 0;
			while (iterate.hasNextLine()) {
				iterate.nextLine();
				numLines++;
			}
			return numLines;
		} catch (Exception ex) {
			return -1;
		}
	}
	
	public int palabrasPentavocalica(String rutaFichero) {
		File archivo = null;
		try {
			archivo = new File(rutaFichero);
			String linea;
			FileReader fr = new FileReader (archivo);
			BufferedReader br = new BufferedReader(fr);
			int i,j,a=0;
			String guardarPal ="",aux="";
			while((linea=br.readLine())!=null) {
				System.out.println(linea);System.out.println(linea.length());
				for(i=0;i<linea.length()-1;i++)
				{
					System.out.println("VALORES   : "+linea.charAt(i)+" EN POSICION  : "+i);
					
					
					if(linea.charAt(i)== ' ' || linea.charAt(i) =='\n'||  linea.charAt(i) ==',' ||  linea.charAt(i) ==';'||  linea.charAt(i) =='.' ){
						aux = guardarPal;
						guardarPal="";
						System.out.println(aux);
					}else{
						guardarPal  = guardarPal +String.valueOf(linea.charAt(i));
					}
				}
				
				
				
				
				j=0;
			}
			
			
			//System.out.println("estoy aqui    : "+i +" con este valor        :"+linea.charAt(i));
			
			
			
			
			fr.close();
		}
		catch(IOException a){
			System.out.println(a);
		}
		
		return 0;
	}
	
	@Override
	public int frecuenciaVocales(String rutaFichero) {
		int i,j;
		int cont_a = 0,cont_e = 0,cont_i = 0,cont_o = 0,cont_u = 0,
				cont_A = 0,cont_E = 0,cont_I = 0,cont_O = 0,cont_U = 0;
		try {
			File archivo = new File(rutaFichero);
			String linea;
			FileReader fr = new FileReader (archivo);
			BufferedReader br = new BufferedReader(fr);
			while((linea=br.readLine())!=null) {
				
				for(i=0;i<linea.length()-1;i++){
					switch (linea.charAt(i)) {
						case 'a':
							cont_a++;
						case 'e':
							cont_e++;
						case 'i':
							cont_i++;
						case 'o':
							cont_o++;
						case 'u':
							cont_u++;
						case 'A':
							cont_A++;
						case 'E':
							cont_E++;
						case 'I':
							cont_I++;
						case 'O':
							cont_O++;
						case 'U':
							cont_U++;
						
						
					}
				}
			}
			
			
			
			
			fr.close();
		}
		catch(IOException a){
			System.out.println(a);
			
			return -1;
		}
		
		int[] numeros = new int[10];
		String[] vocales = {"a", "e", "i", "o", "u", "A", "E", "I", "O", "U"};
		
		int array[] = {cont_a,cont_e,cont_i,cont_o,cont_u,cont_A,cont_E,cont_I,cont_O,cont_U};
		
		j = 0;
		while (j <= array.length - 1) {
			System.out.println(array[j] + "  frecuencia de cada vocal     ->" + vocales[j]);
			j++;
		}
		
		
		
		return 0;
	}
}
