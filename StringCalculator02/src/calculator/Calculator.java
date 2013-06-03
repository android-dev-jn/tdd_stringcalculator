package calculator;

public class Calculator {

	public static int add(String str) {
		if (str.equals("")){
			return 0;
		}else{
			String tmp = str.replaceAll("[^0-9.-]", ",");
			String[] tokens = tmp.split(",");
			int sum = 0, number;
			System.out.println(str);
			for (int i = 0; i < tokens.length; i ++) {
				number = Integer.parseInt(tokens[i]);
				if (number <= 1000){
					sum += number;
					System.out.println(number);
				}
			}
			return sum;
		}		
	}

}
