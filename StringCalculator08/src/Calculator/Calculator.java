package Calculator;

public class Calculator {

	public static int add() {
		return 0;
	}

	public static int add(String string) {
		int result = 0;
		if (string.equals("")) {
			// do nothing
		} else {
			result = Integer.parseInt(string);
		}		
		return result;
	}

}
