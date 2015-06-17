package Util;

import java.util.ArrayList;

public class UtilTraitements {

	/**
	 * Transforme une ArrayList en tableau de la même taille
	 * 
	 * @param array : ArrayList à tranformer
	 * @return tableau d'Object
	 */
	public static Object[] ToTableau(ArrayList<?> array){
		Object[] tab = new Object[array.size()];
		for (int i = 0 ; i < array.size() ; i++){
			tab[i] = array.get(i);
		}
		return tab;
	}
	
	/**
	 * Transforme un tableau en ArrayList de la même taille
	 * 
	 * @param tab : tableau à tranformer
	 * @return ArrayList d'Object
	 */
	public static ArrayList<?> ToTableau(Object[] tab){
		ArrayList<Object> array = new ArrayList<Object>();
		for (int i = 0 ; i < tab.length ; i++){
			array.add(tab[i]);
		}
		return array;
	}
}
