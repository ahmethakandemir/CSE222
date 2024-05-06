import java.util.Map;
import java.util.Iterator;
/**
 * class to decrypt the text
 */
public class decryptor {
	private Map<Character, Map<Character, Character>> map;
	private String key;
	private String keystream = "";
	private String plain_text = "";
	private String cipher_text;
	/**
	 * constructor to initialize the map, key and text
	 * @param _map
	 * @param _key
	 * @param text
	 */
	public decryptor(Map<Character, Map<Character, Character>> _map, String _key, String text) {
		map = _map;
		key = _key;
		cipher_text = text;
	}
	/**
	 * method to decrypt the text
	 */
	public void decrypt() {
		// do not edit this method
		generate_keystream();
		generate_plain_text();
	}
	/**
	 * method to generate the keystream
	 */
	private void generate_keystream() {
		for(int i = 0; i < cipher_text.length(); i++){
			keystream += key.charAt(i%key.length());
		}
	}
	/**
	 * method to generate the plain text
	 */
	private void generate_plain_text() {
		// You must use map.get(x).keySet() with an iterator in this method
		for (int i = 0; i < cipher_text.length(); i++){
			Iterator<Character> keySetIterator = map.get(keystream.charAt(i)).keySet().iterator();
			while(keySetIterator.hasNext()){
				Character itChar = keySetIterator.next();
				if(map.get(keystream.charAt(i)).get(itChar).equals(cipher_text.charAt(i))){
					plain_text += itChar;
				}
			}
		}
	}
	/**
	 * method to get the keystream
	 * @return keystream
	 */
	public String get_keystream() {
		return keystream;
	}
	/**
	 * method to get the plain text
	 * @return	plain_text
	 */
	public String get_plain_text() {
		return plain_text;
	}
}
