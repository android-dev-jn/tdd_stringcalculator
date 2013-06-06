package Calculator;

public class Calculator {

	private static String[] delimiters;
	private static String afterRemoveDelimiter;

	public static int add() {
		return 0;
	}

	public static int add(String str) {
		int result = 0;
		if (str.isEmpty()) {
			result = 0;
		} else {
			try {
				if (str.contains("-")) {
					throw new Exception("negatives not allowed");
				} else {
					// passed negative case
				}

				delimiters = findDelimiter(str);
				if (delimiters[0] == null) {
					delimiters[0] = new String(",");
					afterRemoveDelimiter = str;
				} else {
					afterRemoveDelimiter = str.substring(str.indexOf("\n") + 1);
				}
				
				if (afterRemoveDelimiter.contains("\n")) {
					afterRemoveDelimiter = afterRemoveDelimiter.replaceAll(
							"\n", delimiters[0]);
				}
				System.out.println("input1: " + afterRemoveDelimiter);
				afterRemoveDelimiter = afterRemoveDelimiter.replace(delimiters[0], ",");
				
				System.out.println("input2: " + afterRemoveDelimiter);

				String[] tokens = afterRemoveDelimiter.split(",");
				
				System.out.println("main: " + delimiters[0]);

				for (String number : tokens) {
					System.out.println("Number: " + number);
					if (Integer.parseInt(number) <= 1000) {
						
						result += Integer.parseInt(number);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	private static String[] findDelimiter(String text) {
		String[] delimiters = new String[1000];
		if (text.contains("//[")) {
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

}
