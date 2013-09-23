package findLargestFourElements;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 *
 * @author Jaime Guajardo
 *
 */
public class FindLargestFourElementsTest {

	@Test
	// Test list that's null. Should throw exception.
	public void test0() {
		try {
			FindLargestFourElements.getTopFourElements(null);
			assertTrue(false);
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	// Test list smaller than size four. Should throw exception.
	public void test1() {
		try {
			FindLargestFourElements.getTopFourElements(new ArrayList<Integer>());
			assertTrue(false);
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	// Testing list: 5, 4, 3, 2. Result should be ordered list.
	public void test2() throws Exception {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);

		ArrayList<Integer> orderedList = new ArrayList<Integer>();
		orderedList.add(2);
		orderedList.add(3);
		orderedList.add(4);
		orderedList.add(5);
		assertEquals(FindLargestFourElements.getTopFourElements(list), orderedList);
	}
	
	@Test
	// Testing list: 5, 4, 3, 7 of size 4.
	public void test3() throws Exception {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(7);

		ArrayList<Integer> orderedList = new ArrayList<Integer>();
		orderedList.add(3);
		orderedList.add(4);
		orderedList.add(5);
		orderedList.add(7);
		assertEquals(FindLargestFourElements.getTopFourElements(list), orderedList);
	}
	
	
	@Test
	// Testing list: 5, 4, 3, 7, 1, 10 of size 6.
	public void test4() throws Exception {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(7);
		list.add(1);
		list.add(10);

		ArrayList<Integer> orderedList = new ArrayList<Integer>();
		orderedList.add(4);
		orderedList.add(5);
		orderedList.add(7);
		orderedList.add(10);
		assertEquals(FindLargestFourElements.getTopFourElements(list), orderedList);
	}
	
	@Test
	// Testing list: 5, 5, 5, 7, 1, 10 of size 6 with duplicate values.
	public void test5() throws Exception {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(5);
		list.add(5);
		list.add(7);
		list.add(1);
		list.add(10);

		ArrayList<Integer> orderedList = new ArrayList<Integer>();
		orderedList.add(5);
		orderedList.add(5);
		orderedList.add(7);
		orderedList.add(10);
		assertEquals(FindLargestFourElements.getTopFourElements(list), orderedList);
	}
}
