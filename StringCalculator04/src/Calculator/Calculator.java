package Calculator;

public class Calculator {

	private static String[] delimiters;
	private static String afterRemoveDelimiter;

	public static int add() {
		return 0;
	}

	public static int add(String str) {
		int sum = 0;
		if (str.isEmpty()) {
			sum = 0;
		} else {
			try {
				if (str.contains("-")) {
					throw new Exception("contain '-'");
				} else {
					delimiters = findDelimiter(str);

					if (delimiters[0] == null) { // if not found other dilimiter
						delimiters[0] = new String(",");
						afterRemoveDelimiter = str;
					} else {
						afterRemoveDelimiter = str
								.substring(str.indexOf("\n") + 1);
					}

					if (afterRemoveDelimiter.contains("\n")) {
						System.out.println("assign: " + afterRemoveDelimiter);
						afterRemoveDelimiter = afterRemoveDelimiter.replaceAll(
								"\n", delimiters[0]);
					}

					System.out.println("afterReome: " + afterRemoveDelimiter);
					System.out.println("delimiter: " + delimiters[0]);

					String[] tokens = afterRemoveDelimiter.split(delimiters[0]);

					for (String number : tokens) {
						if (Integer.parseInt(number) <= 1000) {
							sum += Integer.parseInt(number);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sum;
	}

	private static String[] findDelimiter(String text) {
		String[] delimiters = new String[1000];
		if (text.contains("//") && text.contains("\n")) {
			delimiters[0] = new String(String.valueOf(text.charAt(2)));
			return delimiters;
		}
		if (text.contains("//[") && text.contains("]\n")) {
			String delimeterString = text.substring(text.indexOf("//[") + 3,
					text.indexOf("]\n")+1);
			System.out.println("delimiter: " + delimeterString);
			
			System.out.println(text.charAt(text.indexOf("//[")+3) + " : " + text.charAt(text.indexOf("]\n")));

			if (delimeterString.length() != 0) {
				delimiters[0] = new String(String.valueOf(delimeterString
						.charAt(0)));
			}
		}
		return delimiters;
	}

}
