package calculator;

import static org.junit.Assert.*;
import org.junit.*;

public class CalculatorTest {
	@Test
	public void handleNonInput() {
		assertEquals(0, Calculator.add(""));
	}
	@Test
	public void handleNumber() {
		assertEquals(3, Calculator.add("3"));
	}
	@Test
	public void handleMoreThanOne() {
		assertEquals(3, Calculator.add("1,2"));
	}
	@Test
	public void handleNewLines() {
		assertEquals(6, Calculator.add("1\n2,3"));
	}
	
	@Test
	public void handleOtherDelimiter() {
		assertEquals(3, Calculator.add("//[;]\n1;2"));
	}

}
