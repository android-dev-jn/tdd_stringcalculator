package Calculator;

import static org.junit.Assert.*;

import org.junit.*;

public class CalculatorTest {
	
	@Test
	public void shouldReturnZeroOnNone() {
		assertEquals(0, Calculator.add());
	}

	@Test
	public void shouldReturnZeroOnEmptyString() {
		assertEquals(0, Calculator.add(""));
	}
	
	@Test
	public void shouldReturnNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void shouldReturnZeroOnNull() {
		assertEquals(null, Calculator.add(null));
	}

	@Test
	public void shouldReturnZeroOnTwoNumber() {
		assertEquals(3, Calculator.add("1,2"));
	}
	
	@Test
	public void shoudHandleNewLines() {
		assertEquals(6, Calculator.add("1\n2,3"));
	}
	
	@Test
	public void shoudHandleEnd() {
		assertEquals(1, Calculator.add("1\n,"));
	}
	
	@Test
	public void supportAllDelimiter() {
		assertEquals(6, Calculator.add("1;2,3"));
	}
	
	@Test
	public void supportNegative() {
		assertEquals(6, Calculator.add("1;2,-3"));
	}
}
