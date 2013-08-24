package mostWaterSquares;

import java.awt.Point;
import java.util.ArrayList;

/*
 * Given an array where an occupied element in an array is considered land,
 * find the largest area between two land point's that can contain water.
 * 
 * Ex: 
 * X = land, . = water that is contained in valleys.
 * 
 * XX
 * XX......X             Answer will be 9
 * XX..XXX.X...X     
 */
public class WaterSquaresSolver {

	public static class Pair {
		public Point first, second;

		public Pair(Point first, Point second) {
			this.first = first;
			this.second = second;
		}
	}

	public static int findLargestArea(boolean[][] arr) {
		// Find local maximums
		ArrayList<Pair> pairs = findMaximumPairs(arr);
		return findLargestArea(pairs, arr);
	}

	static int findLargestArea(ArrayList<Pair> pairs, boolean[][] arr) {
		int max = -1;
		for (Pair pair : pairs) {
			int result = findArea(pair, arr);
			if (result > max) {
				max = result;
			}
		}
		return max;
	}

	static int findArea(Pair pair, boolean[][] arr) {
		int area = 0;
		int smallestHeight = Math.min(pair.first.y, pair.second.y);
		for (int row = arr.length - smallestHeight; row < arr.length; row++) {
			for (int col = pair.first.x + 1; col < pair.second.x; col++) {
				if (!arr[row][col]) {
					area++;
				}
			}
		}
		return area;
	}

	// TODO: Fix method, and break it apart.
	private static ArrayList<Pair> findMaximumPairs(boolean[][] arr) {
		ArrayList<Pair> list = new ArrayList<Pair>();
		Point prev = null, next = null;
		for (int i = 1; i < arr[0].length - 1; i++) {
			int prevHeight = findHeight(arr, i);
			int nextHeight = findHeight(arr, i + 1);
			// First drop found.
			if (nextHeight < prevHeight) {
				prev = new Point(i, prevHeight);
				for (int j = i + 2; j < arr[0].length; j++) {
					nextHeight = findHeight(arr, j);
					if (nextHeight >= 1) {
						next = new Point(i, nextHeight);
						list.add(new Pair(prev, next));
						i = j;
					}
				}
			}
		}
		return null;
	}

	private static int findHeight(boolean[][] arr, int i) {
		int count = 0;
		for (int j = arr.length - 1; j >= 0; j++) {
			if (!arr[j][i]) {
				break;
			}
			count++;
		}
		return count;
	}

}
