package StringCalculator; 

import static org.junit.Assert.assertEquals; 
import org.junit.Test;  

public class CalculotorTest {

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculotor.add(""));
	}
}