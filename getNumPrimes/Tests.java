package getNumPrimes;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void test1() {
		assertEquals(1, GetNumPrimes.getNumPrimes(2));
	}

	@Test
	public void test2() {
		assertEquals(25, GetNumPrimes.getNumPrimes(100));
	}
	
	@Test
	public void test3() {
		assertEquals(78498, GetNumPrimes.getNumPrimes(1000000));
	}
}
