package Calculator;


public class Calculator {

	private static String[] delimiters;
	private static int[] numbers;

	public static int add() {
		return 0;
	}

	public static int add(String str) {
		int result = 0;
		int numberOfNegative = 0;
		String message = "negatives not allowed: ";
		if (str.isEmpty()) {
			result = 0;
		} else {

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
					throw new RuntimeException(message);
				}
		}
		return result;
	}

	private static String[] findDelimiter(String text) {
		if (text.contains("//[") && text.contains("]\n")) {
			String delimeterString = text.substring(text.indexOf("//[") + 3,
					text.indexOf("]\n"));
			
			if (delimeterString.contains("][")) {
				delimeterString = delimeterString.replace("][", ",");
				delimiters = delimeterString.split(",");				
			} else {
				delimiters = new String[1];
				delimiters[0] = new String(delimeterString);
			}
		} else if (text.contains("//") && text.contains("\n")) {
			delimiters = new String[1];
			delimiters[0] = new String(String.valueOf(text.charAt(2)));
			return delimiters;
		}
		return delimiters;
	}
	
	private static int[] findNumbers(String input, String[] delimiters) {
		int[] result = new int[1000];
		String afterRemoveDelimiter = "";
				
		if (delimiters == null) {
			delimiters = new String[1];
			delimiters[0] = new String(",");
			afterRemoveDelimiter = input;
		} else {
			afterRemoveDelimiter = input.substring(input.indexOf("\n") + 1);
		}
		
		if (afterRemoveDelimiter.contains("\n")) {
			afterRemoveDelimiter = afterRemoveDelimiter.replaceAll(
					"\n", delimiters[0]);
		}
		
		for (int i = 0 ; i < delimiters.length; i ++) {
			afterRemoveDelimiter = afterRemoveDelimiter.replace(delimiters[i], ",");
		}
		
		String[] tokens = afterRemoveDelimiter.split(",");
				
		for (int i = 0; i < tokens.length; i ++) {
			result[i] = Integer.parseInt(tokens[i]);
		}
		return result;
	}

}
