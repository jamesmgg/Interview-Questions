package mostWaterSquares;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class Tests {

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
		WaterSquaresSolver.Pair pair = new WaterSquaresSolver.Pair(first, second);
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

}
