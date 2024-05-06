import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Iterator;
/**
 * class to create a map for the alphabet
 */
public class alphabet {
	private Set<Character> english_alphabet = new LinkedHashSet<Character>();
	private Map<Character, Map<Character, Character>> map = new HashMap<Character, Map<Character, Character>>();
	/**
	 * constructor that fills the english_alphabet and map
	 */
	public alphabet() {
		// do not edit this method
		fill_english_alphabet();
		fill_map();
	}
	/**
	 * method to fill english_alphabet
	 */
	private void fill_english_alphabet() {
		// do not edit this method
		for (char c : "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()) {
			english_alphabet.add(c);
		}
	}
	/**
	 * method to fill the map 
	 */
	private void fill_map() {
		// You must use the "english_alphabet" variable in this method, to fill the
		// "map" variable.
		// You can define 1 or 2 iterators to iterate through the set items.
		/**
		 * shifted variable is used to count which row will be filled so alphabet can start from that column
		 */
		int shifted = 0;
		/**
		 * an enhanced for loop to iterate through map's character variable
		 */
		for (char outer: english_alphabet){
			/**
			 * in shiftedAlphabet set, alphabet is shifted "shifted" times at each iteration
			 */
			Set<Character> shiftedAlphabet = new LinkedHashSet<Character>();
			int i = 0;
			/**
			 * fill the alphabet by skipping some letter to insert them to the end, if shifted == 2, it will start filling with "C"
			 */
			for(char ch: english_alphabet){
				if (i >= shifted){
					shiftedAlphabet.add(ch);
				}
				i++;
			}
			i = 0;
			/**
			 * fill the rest, if shifted == 2, shiftedAlphabet will end with, "Y", "Z", "A", "B". 
			 */
			for(char ch: english_alphabet){
				if(i < shifted){
					shiftedAlphabet.add(ch);
				}
				i++;
			}
			shifted++;
			Map<Character,Character> tempMap = new HashMap<Character,Character>();
			Iterator<Character> english_alIterator = english_alphabet.iterator();
			Iterator<Character> shiftedIterator = shiftedAlphabet.iterator();
			while(english_alIterator.hasNext()){
				tempMap.put(english_alIterator.next(), shiftedIterator.next());
			}
			map.put(outer, tempMap);
		}
	}
	/**
	 * funciton to print map
	 */
	public void print_map() {
		// do not edit this method
		System.out.println("*** Viegenere Cipher ***\n\n");
		System.out.println("    " + english_alphabet);
		System.out.print("    ------------------------------------------------------------------------------");
		for (Character k : map.keySet()) {
			System.out.print("\n" + k + " | ");
			System.out.print(map.get(k).values());
		}
		System.out.println("\n");
	}
	/**
	 * getter for the map
	 * @return map
	 */
	public Map<Character,Map<Character, Character>> get_map() {
		return map;
	}
}