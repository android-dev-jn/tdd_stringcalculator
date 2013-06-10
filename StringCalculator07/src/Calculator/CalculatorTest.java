package Calculator;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {
	
	@Test
	public void handleNonInput(){
		assertEquals(0, Calculator.add());
	}
	@Test
	public void handleEmptyString(){
		assertEquals(0, Calculator.add(""));
	}
	@Test
	public void handleSingleNumber(){
		assertEquals(3, Calculator.add("3"));
	}
	@Test
	public void handleTwoNumber(){
		assertEquals(4, Calculator.add("1,3"));
	}
	@Test
	public void handleNewLines(){
		assertEquals(6, Calculator.add("1\n2,3"));
	}
	@Test
	public void handleOtherDilimiter(){
		assertEquals(6, Calculator.add("//;\n1;2;3"));
	}	
	@Test
	public void handleNegativeNumber(){
		String msg = "";
		try {
			Calculator.add("//;\n1;-2;3");
		} catch (Exception e) {
			msg = e.getMessage();
		}
		assertEquals("negatives not allowed: -2", msg);
	}
	@Test
	public void handleMultiNegativeNumber(){
		String msg = "";
		try {
			Calculator.add("//;\n-1;-2;3");
		} catch (Exception e) {
			msg = e.getMessage();
		}
		assertEquals("negatives not allowed: -1-2", msg);
	}
	@Test
	public void handleLargerThanThousand(){
		assertEquals(5, Calculator.add("//;\n1001;2;3"));
	}
	@Test
	public void handleMultiDilimiter(){
		assertEquals(6, Calculator.add("//[***]\n1***2***3"));
	}
	@Test
	public void handleMultiKindDilimiter(){
		assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
	}
}
