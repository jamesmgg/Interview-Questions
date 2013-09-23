package solvePostFix;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class TestSolvePostFix {

	@Test
	public void testPerformOperation1() {
		String op = "+";
		LinkedList<String> stack = new LinkedList<String>();
		stack.add("5");
		stack.add("1");
		double val;
		try {
			val = SolvePostFix.performOperation(op, stack);
			assertEquals(6, val, 0);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testPerformOperation2() {
		String op = "*";
		LinkedList<String> stack = new LinkedList<String>();
		stack.add("5");
		stack.add("2");
		double val;
		try {
			val = SolvePostFix.performOperation(op, stack);
			assertEquals(10, val, 0);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	// Divide by zero case.
	@Test
	public void testPerformOperation3() {
		String op = "/";
		LinkedList<String> stack = new LinkedList<String>();
		stack.add("5");
		stack.add("0");
		double val;
		try {
			val = SolvePostFix.performOperation(op, stack);
			assertTrue(false);
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	// Test 5 + 8
	@Test
	public void testSolve1() {
		String eq = "5 8 +";
		double val;
		try {
			val = SolvePostFix.solve(eq);
			assertEquals(13, val, 0);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	// Test 2 * (5 + 8)
	@Test
	public void testSolve2() {
		String eq = "2 5 8 + *";
		double val;
		try {
			val = SolvePostFix.solve(eq);
			assertEquals(26, val, 0);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

}
