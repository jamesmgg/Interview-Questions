package largestPalindromeInString;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void testisPalindrome_1() {
		assertTrue(LargestPalindromeSolver.isPalindrome("radar"));
	}
	
	@Test
	public void testisPalindrome_2() {
		assertTrue(LargestPalindromeSolver.isPalindrome("raar"));
	}
	
	@Test
	public void testisPalindrome_3() {
		assertFalse(LargestPalindromeSolver.isPalindrome("raab"));
	}
	
	@Test
	public void testgetLargestPalindromeAtIndex_1() {
		assertEquals("radar",LargestPalindromeSolver.getLargestPalindromeAtIndex("radar", 0));
	}

	@Test
	public void testgetLargestPalindromeAtIndex_2() {
		assertEquals("cccc",LargestPalindromeSolver.getLargestPalindromeAtIndex("ccccradaree", 0));
	}
	
	@Test
	public void testgetLargestPalindromeAtIndex_3() {
		assertEquals("radar",LargestPalindromeSolver.getLargestPalindromeAtIndex("ccccradaree", 4));
	}
	
	@Test
	public void testfindLargestPalindrome_1() {
		assertEquals("radar",LargestPalindromeSolver.findLargestPalindrome("ccccradaree"));
	}
	
	@Test
	public void testfindLargestPalindrome_2() {
		assertEquals("ccccradarcccc",LargestPalindromeSolver.findLargestPalindrome("ccccradarcccc"));
	}

}
