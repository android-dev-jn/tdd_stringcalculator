package Calculator;

public class Calculator {
	
	static int[] numbers = new int[1000];

	public static int add() {
		return 0;
	}

	public static int add(String string) {
		int result = 0;
		if (string.equals("")) {
			// do nothing
		} else {
			String[] tokens = string.split(",");
			for (int i = 0 ; i <tokens.length; i ++) {
				numbers[i] = Integer.parseInt(tokens[i]);
				result += numbers[i];
			}	
			
		}
		return result;
	}

}
