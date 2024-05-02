public class preprocessor {
	private String initial_string;
	private String preprocessed_string;
		
	public preprocessor(String str) {
		initial_string = str;
	}

	public void preprocess() {
		// do not edit this method
		capitalize();
		clean();
	}
	
	private void capitalize() {
		if(preprocessed_string == null){
			preprocessed_string = initial_string.toUpperCase();
		}
		else{
			preprocessed_string = preprocessed_string.toUpperCase();
		}
	}

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
	
	public String get_preprocessed_string() {
		return preprocessed_string;
	}
}