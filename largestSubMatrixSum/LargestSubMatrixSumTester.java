package largestSubMatrixSum;

import static org.junit.Assert.*;

import org.junit.Test;

@SuppressWarnings("deprecation")
public class LargestSubMatrixSumTester {

	@Test
	public void test_sum_1() {
		assertEquals(0, LargestSubMatrixSumSolver.sum(
				new int[][] {{0, 10, -10},
							 {20, -20, 0}}));
	}
	
	@Test
	public void test_subMatrix_1() {
		assertEquals(new int[][] {{-20}},
				LargestSubMatrixSumSolver.getSubMatrix(
				new int[][] {{0, 10, -10},
							 {20, -20, 0}}, 1, 1, 1, 1));
	}

	@Test
	public void test_subMatrix_2() {
		assertEquals(new int[][] {{-20, 0}},
				LargestSubMatrixSumSolver.getSubMatrix(
				new int[][] {{0, 10, -10},
							 {20, -20, 0}}, 1, 2, 1, 1));
	}
	
	@Test
	public void test_subMatrix_3() {
		assertEquals(new int[][] {{10, -10}, {-20, 0}},
				LargestSubMatrixSumSolver.getSubMatrix(
				new int[][] {{0, 10, -10},
							 {20, -20, 0}}, 2, 2, 1, 0));
	}
	
	@Test
	public void test_findLargestContainingIndex_1() {
		assertEquals(new int[][] {{0}, {20}},
				LargestSubMatrixSumSolver.findLargestContainingIndex(
				new int[][] {{0, 10, -10},
							 {20, -20, 0}}, 0, 0));
	}
	
	@Test
	public void test_findLargestContainingIndex_2() {
		assertEquals(new int[][] {{10}},
				LargestSubMatrixSumSolver.findLargestContainingIndex(
				new int[][] {{0, 10, -10},
							 {20, -20, 0}}, 1, 0));
	}
	
	@Test
	public void test_findLargest_1() {
		assertEquals(new int[][] {{0, 10},
								  {20, -20},
								  {0, 50}},
				LargestSubMatrixSumSolver.findLargest(
				new int[][] {{0, 10, -10},
							 {20, -20, 0},
							 {0, 50, -10}}));
	}
}
