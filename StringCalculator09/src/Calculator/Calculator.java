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
			int result = 0, numberOfNegative = 0;
			int[] numbers = new int[1000];
			String delimiter = ",", input = string, msg = "negatives not allowed: ";
			if (string. contains("//") && string.contains("\n")) {
				delimiter = string.substring(2,3);
				input = string.substring(4);
			}
			if (input.contains("\n")) {
				input = input.replace("\n", ",");
			}
			System.out.println(delimiter);
			
			String[] tokens = input.split(delimiter);
			for (int i = 0; i < tokens.length; i ++) {
				numbers[i] = Integer.parseInt(tokens[i]);
				result += numbers[i];
				if (numbers[i] < 0) {
					numberOfNegative ++;
					msg += String.valueOf(numbers[i]);
				}
			}
			if (numberOfNegative != 0) {
				throw new NumberFormatException(msg);
			}
			return result;
		}
	}
}
