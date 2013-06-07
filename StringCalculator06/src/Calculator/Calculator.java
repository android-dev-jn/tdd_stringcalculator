package Calculator;


public class Calculator {

	private static String[] delimiters;
	private static int[] numbers;
	private static int numberOfNegative = 0;

	public static int add() {
		return 0;
	}

	public static int add(String str) {
		System.out.println("Ban dau: " + str);
		int result = 0;
		String message = "negatives not allowed: ";
		if (str.isEmpty()) {
			result = 0;
		} else {
			try {
				// Find delimiter
				delimiters = findDelimiter(str);
				// Filter number from the string
				numbers = findNumbers(str, delimiters);
				
				// Compute sum of the number				
				if (numbers.length != 0){
					for (int number : numbers) {
						if (number < 0) {
							message += String.valueOf(number);
							numberOfNegative ++;
						}
						if (number <= 1000) {
							result += number;							
						}
					}
				}
				
				// Handle negative case
				if (numberOfNegative != 0) {
					throw new Exception(message);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	private static String[] findDelimiter(String text) {
		String[] delimiters = new String[1000];
		if (text.contains("//[") && text.contains("]\n")) {
			System.out.println("Handle longer than one char");
			String delimeterString = text.substring(text.indexOf("//[") + 3,
					text.indexOf("]"));
			System.out.println("delimiter: " + delimeterString);

			if (delimeterString.length() != 0) {
				delimiters[0] = new String(delimeterString);
			}
		} else if (text.contains("//") && text.contains("\n")) {
			delimiters[0] = new String(String.valueOf(text.charAt(2)));
			return delimiters;
		}
		return delimiters;
	}
	
	private static int[] findNumbers(String input, String[] delimiters) {
		int[] result = new int[1000];
		String afterRemoveDelimiter = "";
		
		System.out.println(1);
		
		if (delimiters[0] == null) {
			delimiters[0] = new String(",");
			afterRemoveDelimiter = input;
		} else {
			afterRemoveDelimiter = input.substring(input.indexOf("\n") + 1);
		}
		System.out.println(2);
		
		if (afterRemoveDelimiter.contains("\n")) {
			afterRemoveDelimiter = afterRemoveDelimiter.replaceAll(
					"\n", delimiters[0]);
		}
		System.out.println(3);
		afterRemoveDelimiter = afterRemoveDelimiter.replace(delimiters[0], ",");
		
		System.out.println(4 + ": " + delimiters[0]);

		String[] tokens = afterRemoveDelimiter.split(",");
		
		System.out.println(5);
		
		for (int i = 0; i < tokens.length; i ++) {
			result[i] = Integer.parseInt(tokens[i]);
		}
		System.out.println(6);
		return result;
	}

}
