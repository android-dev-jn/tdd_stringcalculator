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
			int result = 0;
			String[] tokens = string.split(",");
			for (int i = 0; i < tokens.length; i ++) {
				result += Integer.parseInt(tokens[i]);
			}
			return result;
		}		
	}

}
