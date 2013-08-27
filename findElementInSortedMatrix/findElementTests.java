package findElementInSortedMatrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class findElementTests {

	@Test
	public void testFindElement_1() {
		int arr[][] = new int[][] { {5,  10, 12},
									{8,  12, 18},
									{13, 20, 25}};
		assertEquals(true, FindElementInMatrix.findElement(arr, 18));
	}
	
	@Test
	public void testFindElement_2() {
		int arr[][] = new int[][] { {5,  10, 12},
									{8,  12, 18},
									{13, 20, 25}};
		assertEquals(true, FindElementInMatrix.findElement(arr, 13));
	}

	@Test
	public void testFindElementIterative_1() {
		int arr[][] = new int[][] { {5,  10, 12},
									{8,  12, 18},
									{13, 20, 25}};
		assertEquals(true, FindElementInMatrix.findElementIterative(arr, 13));
	}
	
	@Test
	public void testFindElementIterative_2() {
		int arr[][] = new int[][] { {5,  10, 12},
									{8,  12, 18},
									{13, 20, 25}};
		assertEquals(true, FindElementInMatrix.findElementIterative(arr, 20));
	}

	@Test
	public void testFindElementIterative_3() {
		int arr[][] = new int[][] { {5,  10, 12},
									{8,  12, 18},
									{13, 20, 25}};
		assertEquals(true, FindElementInMatrix.findElementIterative(arr, 25));
	}
}
