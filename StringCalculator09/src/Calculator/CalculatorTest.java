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
}
