package Calculator;

public class Calculator {

	public static Object add() {
		return 0;
	}

	public static Object add(String str) {
		if (str == null)
			return null;
		if (str.equals(""))
			return 0;

		String tmp = str.replaceAll("[^0-9.-]", ",");
		int result = 0;

		String[] tokens = tmp.split(",");
		if (tokens.length == 1) {
			return Integer.parseInt(tokens[0]);
		} else {
			for (int i = 0; i < tokens.length; i++) {
				result += Integer.parseInt(tokens[i]);
			}
		}
		return result;

	}

}
