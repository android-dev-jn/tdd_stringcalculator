package Calcaulator;

public class Calculator {

	public static int add() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static Object add(String string) {
		if (string.equals("")) {
			return 0;
		} else {
			String input = string;
			String delimiter = ",";
			if (string.contains("//") && string.contains("\n")) {
				input = string.substring(string.indexOf("\n") + 1);
				delimiter = string.substring(2, string.indexOf("\n"));
			}
			if (input.contains("\n")) {
				input = input.replace("\n", delimiter);
			}
			int result = 0;
			String[] tokens = input.split(delimiter);
			for (int i = 0; i < tokens.length; i ++) {
				result += Integer.parseInt(tokens[i]);
			}
			return result;
		}		
	}

}
