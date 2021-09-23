package org.madrid.ad.ut01.ficheros.interfaces;

/**
 * 
 * @author Carlos Tessier
 * @date 18/09/2021
 * @version 1.0
 * @license GPLv3
 *
 */
public interface InterfazFicherosTexto {

	/**
	 * 	
	 * Método que lee un fichero txt	  
	 *
	 * @param rutaFichero
	 */
	public void leer(String rutaFichero);
	
	/**
	 * 	
	 * Método que cuenta en número de caracteres de un fichero txt	  
	 *
	 * @param rutaFichero
	 */
	public int contarCaracteres(String rutaFichero);
	
	
	/**
	 * 	
	 * Método que cuenta en número de líneas de un fichero txt	  
	 *
	 * @param rutaFichero
	 */
	public int contarLineas(String rutaFichero);
	
	/**
	 * 	
	 * Método que cuenta en número de palabras de un fichero txt	  
	 *
	 * @param rutaFichero
	 */
	public int contarPalabras(String rutaFichero);
	
	/**
	 * 	
	 * Método que cuenta y muestra el número total de palabras pentavocálicas 
	 *
	 * @param rutaFichero
	 */
	public int palabrasPentavocalica(String rutaFichero);
	
	/**
	 * 	
	 * Obtener y mostrar la palabra más larga, su número de letras y su posición
	 *  (número de orden en la secuencia de palabras).
	 *  Si hay más de una se toma la primera. 
	 *  Nota: El número de orden o posición de la palabra en el texto es el lugar que ocupa,
	 *  una vez contadas todas.   
	 *
	 * @param rutaFichero
	 */
	public int palabraMasLarga(String rutaFichero);
	
	/**
	 * 	
	 * Método Obtener la frecuencia de las 5 vocales 
	 * (número de veces que se repite cada vocal).  
	 *
	 * @param rutaFichero
	 */
	
	public int frecuenciaVocales(String rutaFichero);
	

	/**
	 * 	
	 * Método Obtener la frecuencia de las 27 letras del alfabeto 
	 * y muestra el resultado en orden descendente de frecuencia.  
	 *
	 * @param rutaFichero
	 */
	public int frecuenciaLetras(String rutaFichero);
	
	
	
	

}
