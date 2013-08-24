package mostWaterSquares;

import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.util.ArrayList;

import mostWaterSquares.WaterSquaresSolver.Pair;

import org.junit.Test;

public class WaterSquaresSolverTest {

	@Test
	public void testFindArea_1() {
		boolean[][] arr = new boolean[][]
				{
				{true, false, false},
				{true, false, true},
				{true, false, true}
				};
		Point first = new Point(0, 3);
		Point second = new Point(2, 2);
		Pair pair = new Pair(first, second);
		assertEquals(2, WaterSquaresSolver.findArea(pair, arr));
	}
	
	@Test
	public void testFindArea_2() {
		boolean[][] arr = new boolean[][]
				{
				{true, false, false, false, true},
				{true, false, false, false, true},
				{true, false, true, false, true}
				};
		Point first = new Point(0, 3);
		Point second = new Point(4, 3);
		WaterSquaresSolver.Pair pair = new WaterSquaresSolver.Pair(first, second);
		assertEquals(8, WaterSquaresSolver.findArea(pair, arr));
	}
	
	@Test
	public void testFindArea_3() {
		boolean[][] arr = new boolean[][]
				{
				{true, true},
				{true, true},
				{true, true}
				};
		Point first = new Point(0, 3);
		Point second = new Point(1, 3);
		WaterSquaresSolver.Pair pair = new WaterSquaresSolver.Pair(first, second);
		assertEquals(0, WaterSquaresSolver.findArea(pair, arr));
	}
	
	@Test
	public void testFindHeight_1() {
		boolean[][] arr = new boolean[][]
				{
				{true, false, true, false, true},
				{true, true, true, false, true},
				{true, true, true, false, true}
				};
		assertEquals(3, WaterSquaresSolver.findHeight(arr, 0));
	}
	@Test
	public void testIsDropping_1() {
		boolean[][] arr = new boolean[][]
				{
				{true, false, true, false, true},
				{true, true, true, false, true},
				{true, true, true, false, true}
				};
		assertEquals(2, WaterSquaresSolver.isDropping(arr, 0));
	}
	
	@Test
	public void testIsDropping_2() {
		boolean[][] arr = new boolean[][]
				{
				{true, false, false, false, true},
				{true, true, true, false, true},
				{true, true, true, false, true}
				};
		assertEquals(2, WaterSquaresSolver.isDropping(arr, 0));
	}

	//@Test
	public void testFindMaximumPairs_1() {

		boolean[][] arr = new boolean[][]
				{
				{true, false, false, false, true},
				{true, false, false, false, true},
				{true, false, true, false, true}
				};
		Point first = new Point(0, 3);
		Point second = new Point(2, 1);
		Point third = new Point(4, 3);
		ArrayList<Pair> pairs = WaterSquaresSolver.findMaximumPairs(arr);
		assertEquals(2, pairs.size());
		assertEquals(first, pairs.get(0).first);
		assertEquals(second, pairs.get(0).second);
		assertEquals(first, pairs.get(1).first);
		assertEquals(third, pairs.get(1).second);
	}

}
