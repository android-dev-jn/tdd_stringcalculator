package Calculator;

public class Calculator {

	public static int add() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int add(String string) {
		if (string.equals("")) {
			return 0;
		} else {
			return Integer.parseInt(string);
		}
	}
}
