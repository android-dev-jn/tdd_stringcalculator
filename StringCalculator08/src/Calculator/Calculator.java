package Calculator;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Calculator {

	static int[] numbers = new int[1000];
	static ArrayList<String> delimiters = new ArrayList<String>();

	public static int add() {
		return 0;
	}

	public static int add(String string) {
		int result = 0, numberOfNegative = 0;
		String msg = "negatives not allowed: ", delimiter = "";;
		ArrayList<String> tokensA = new ArrayList<String>();
		ArrayList<String> tokensB = new ArrayList<String>();
		if (string.equals("")) {
			// do nothing
		} else {
			String input = string;
			if (string.contains("//") && string.contains("\n")) {
				input = string.substring(string.indexOf("\n") + 1);
			}
			if (string.contains("//[") && string.contains("]\n")) {
				
				delimiter = string.substring(3, string.indexOf("]\n"));
				System.out.println("delimiter: " + delimiter);
				delimiters.add(delimiter);				
			}
			System.out.println("input: " + input);
			delimiters.add(new String(","));
			delimiters.add(new String("\n"));
			delimiters.add(new String(";"));
			String[] firstToken = input.split(delimiters.get(0)), tokens;
			for (int i = 0; i < firstToken.length; i++) {
				tokensA.add(firstToken[i]);
			}

			for (int i = 1; i < delimiters.size(); i++) {
				tokensB = new ArrayList<String>();
				for (int j = 0; j < tokensA.size(); j++) {
					tokens = tokensA.get(j).split(Pattern.quote(delimiters.get(i)));
					for (int x = 0; x < tokens.length; x++) {
						tokensB.add(tokens[x]);
					}
				}
				tokensA = new ArrayList<String>();
				for (int j = 0; j < tokensB.size(); j++) {
					tokensA.add(new String(tokensB.get(j)));
				}
			}
			for (int i = 0; i < tokensA.size(); i++) {
				numbers[i] = Integer.parseInt(tokensA.get(i));
				if (numbers[i] <= 1000)
					result += numbers[i];
				if (numbers[i] < 0) {
					numberOfNegative++;
					msg += String.valueOf(numbers[i]);
				}
			}
			if (numberOfNegative != 0) {
				throw new NumberFormatException(msg);
			}
		}
		return result;
	}

}
