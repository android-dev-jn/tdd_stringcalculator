package Calculator;
import org.junit.*;
import static org.junit.Assert.*;

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
		assertEquals(6, Calculator.add("//;\n1;-2;3"));
	}
	@Test
	public void handleMultiNegativeNumber(){
		assertEquals(0, Calculator.add("//;\n-1;-2;3"));
	}
	@Test
	public void handleLargerThanThousand(){
		assertEquals(5, Calculator.add("//;\n1001;2;3"));
	}
	@Test
	public void handleMultiDilimiter(){
		assertEquals(6, Calculator.add("//[***]\n1***2***3"));
	}
}
