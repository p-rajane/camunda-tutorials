package tutorial;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JUnit5Assertion {

	@BeforeEach
	public void beforeEach() {
		System.out.print("each action");
	}
	
	@Test
	public void testAssertionName() {
		String name = "Pramod";
		assertEquals(name, "Pramod");
	}
	
	@Test
	public void testAssertionAddress() {
		String address = "Mumbai";
		assertEquals(address, "Mumbai");
	}
}
