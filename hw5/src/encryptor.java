import java.util.Map;
/**
 * class to encrypt the text
 */
public class encryptor {
	private Map<Character, Map<Character, Character>> map;
	private String key;
	private String keystream = "";
	private String plain_text;
	private String cipher_text = "";
	/**
	 * constructor to initialize the map, key and text
	 * @param _map
	 * @param _key
	 * @param text
	 */
	public encryptor(Map<Character, Map<Character, Character>> _map, String _key, String text) {
		map = _map;
		key = _key;
		plain_text = text;
	}
	/**
	 * method to encrypt the text
	 */
	public void encrypt() {
		// do not edit this method
		generate_keystream();
		generate_cipher_text();
	}
	/**
	 * method to generate the keystream
	 */
	private void generate_keystream() {
		for(int i = 0; i < plain_text.length(); i++){
			keystream += key.charAt(i%key.length());
		}
	}
	/**
	 * method to generate the cipher text
	 */
	private void generate_cipher_text() {
		for (int i = 0; i < plain_text.length(); i++){
			cipher_text += map.get(plain_text.charAt(i)).get(keystream.charAt(i));
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
	 * method to get the cipher text
	 * @return cipher_text
	 */
	public String get_cipher_text() {
		return cipher_text;
	}
}
