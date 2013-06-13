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
}
