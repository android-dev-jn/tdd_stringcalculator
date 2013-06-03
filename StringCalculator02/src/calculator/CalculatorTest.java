package calculator;

import static org.junit.Assert.*;

import org.junit.*;

public class CalculatorTest {
	@Test
	public void shouldReturnZero() {
		assertEquals(0, Calculator.add(""));
	}
	@Test
	public void shouldReturnNumbe(){
		assertEquals(3, Calculator.add("3"));
	}
	@Test
	public void shouldReturnSumOfNumber(){
		assertEquals(4, Calculator.add("1,3"));
	}
	@Test
	public void handleNewLines(){
		assertEquals(6, Calculator.add("1,2\n3"));
	}
	@Test
	public void handleNegative() {
		assertEquals(-3, Calculator.add("-3"));
	}
	@Test
	public void handleLagerThanThousand() {
		assertEquals(2, Calculator.add("1001+2"));
	}
}
