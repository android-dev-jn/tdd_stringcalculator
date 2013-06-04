package calculator;

public class Calculator {

	private static String[] delimiters;
	private static String afterRemove = "";

	public static int add(String str) {
		if (str.isEmpty()) {
			return 0;
		} else {
			delimiters = findDelimiter(str);
			if (delimiters[0] == null) {
				delimiters[0] = new String(",");
				if (str.contains("\n")) {
					str = str.replaceAll("\n", delimiters[0]);
				}
				afterRemove = str;
			} else {
				afterRemove = str.substring(str.indexOf("]\n")+2);
				System.out.println("after: " + afterRemove);
			}
			
			String[] tokens = afterRemove.split(delimiters[0]);
			int sum = 0;
			for (int i = 0; i < tokens.length; i++) {
				sum += Integer.parseInt(tokens[i]);
			}
			return sum;
		}
	}

	private static String[] findDelimiter(String text) {
		String[] delimiters = new String[1000];
		if (text.contains("//[")) {
			String delimeterString = text.substring(text.indexOf("//[") + 3,
					text.indexOf("]\n"));
			System.out.println("delimiter: " + delimeterString);

			if (delimeterString.length() != 0) {
				delimiters[0] = new String(String.valueOf(delimeterString.charAt(0)));
			}
		}
		return delimiters;
	}

}
