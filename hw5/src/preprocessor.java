/**
 * This class is used to preprocess a string. The string is first converted to uppercase and then all non-alphabetic characters are removed.
 */
public class preprocessor {
	private String initial_string;
	private String preprocessed_string;
	/**
	 * constructor to initialize the initial_string
	 * @param str
	 */
	public preprocessor(String str) {
		initial_string = str;
	}
	/**
	 * method to preprocess the string
	 */
	public void preprocess() {
		// do not edit this method
		capitalize();
		clean();
	}
	/**
	 * method to capitalize the string
	 */
	private void capitalize() {
		if(preprocessed_string == null){
			preprocessed_string = initial_string.toUpperCase();
		}
		else{
			preprocessed_string = preprocessed_string.toUpperCase();
		}
	}
	/**
	 * method to remove all non-alphabetic characters
	 */
	private void clean() {
		StringBuilder tempPreprocessed_string = new StringBuilder();
		if (preprocessed_string == null){
			for(int i = 0; i < initial_string.length(); i++){
				char ch = initial_string.charAt(i);
				if((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)){
					tempPreprocessed_string.append(ch);
				}
			}
		}
		else{
			for(int i = 0; i < preprocessed_string.length(); i++){
				char ch = preprocessed_string.charAt(i);
				if((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)){
					tempPreprocessed_string.append(ch);
				}
			}
		}
		preprocessed_string = tempPreprocessed_string.toString();
	}
	/**
	 * method to get the preprocessed string
	 * @return preprocessed_string
	 */
	public String get_preprocessed_string() {
		return preprocessed_string;
	}
}