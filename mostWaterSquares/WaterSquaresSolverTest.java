package mostWaterSquares;

import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;

public class WaterSquaresSolverTest {
	@Test
	public void testFindVolume_1() {
		boolean[][] arr = new boolean[][]
		{
		{true, false, false},
		{true, false, true},
		{true, false, true}
		};
		assertEquals(2, WaterSquaresSolver.findVolume(arr, 0, 2, 0, 1));
	}
	
	@Test
	public void testFindVolume_2() {
		boolean[][] arr = new boolean[][]
		{
		{true, false, false, false, true},
		{true, true, true, false, true},
		{true, true, true, false, true}
		};
		assertEquals(5, WaterSquaresSolver.findVolume(arr, 0, 4, 0, 0));
	}
	
	@Test
	public void testFindVolume_3() {
		boolean[][] arr = new boolean[][]
		{
		{true, false, false, false, true},
		{true, true, true, false, true},
		{true, true, true, false, true}
		};
		assertEquals(5, WaterSquaresSolver.findLargestVolumeWater(arr));
	}
	
	@Test
	public void testFindVolume_4() {
		boolean[][] arr = new boolean[][]
		{
		{false, false, false, false, true},
		{true, false, false, false, true},
		{true, false, true, false, true}
		};
		assertEquals(5, WaterSquaresSolver.findLargestVolumeWater(arr));
	}
	
	@Test
	public void testFindVolume_5() {
		boolean[][] arr = new boolean[][]
		{
		{true, false, false, false, false},
		{true, false, false, false, true},
		{true, false, true, false, true}
		};
		assertEquals(5, WaterSquaresSolver.findLargestVolumeWater(arr));
	}
	
	@Test
	public void testFindVolume_6() {
		boolean[][] arr = new boolean[][]
		{
		{true, true, false, false, false, false, false, false, false, false ,false, false, false },
		{true, true, false, false, false, false, false, true,  true,  false ,false, false, false},
		{true, true, false, false, true,  true,  true,  false, true,  false, false, false, true}
		};
		assertEquals(8, WaterSquaresSolver.findLargestVolumeWater(arr));
	}
}
