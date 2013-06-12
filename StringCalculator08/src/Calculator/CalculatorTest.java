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
		assertEquals(1, Calculator.add("1"));
	}
	@Test
	public void handleDelimiter(){
		assertEquals(3, Calculator.add("1,2"));
	}
	@Test
	public void handleNewLine(){
		assertEquals(6, Calculator.add("1,2\n3"));
	}
	@Test
	public void handleNewDelimiter(){
		assertEquals(3, Calculator.add("//;\n1;2"));
	}
	@Test
	public void handleNegativeNumber(){
		Exception e1=null;
		try {
			Calculator.add("-1,-2");
		} catch (Exception e) {
			e1=e;			
		}
		assertEquals("negatives not allowed: -1-2", e1.getMessage());
	}
	@Test
	public void handleLargerThanThousand(){
		assertEquals(2, Calculator.add("1001,2"));
	}
}
