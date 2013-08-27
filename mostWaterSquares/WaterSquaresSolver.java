package mostWaterSquares;


/*
 * Given an array where a 1 is considered land, and a 0 is considered empty space,
 * find the largest volume of water contained between two points of land.
 * 
 * Ex: 
 * Given array:
 * 1100000000000
 * 1100000010000
 * 1100111010001 
 * 
 * where 1 = land, 0 = empty space, . = water
 * 
 * 1100000000000
 * 11......10000             Answer will be 8
 * 11..111.1...1    
 */
public class WaterSquaresSolver {

	static int findLargestVolumeWater(boolean [][] arr) {
		int[] heightArr = getHeightArray(arr);
		int maxVolume = 0;
		for (int col1 = 0; col1 < heightArr.length; col1++) {
			for (int col2 = col1 + 1; col2 < heightArr.length; col2++) {
				if (heightArr[col2] >= heightArr[col1]) {
					int row1 = arr.length - heightArr[col1];
					int row2 = arr.length - heightArr[col2];
					int volume = findVolume(arr, col1, col2, row1, row2);
					// Max volume found for this height.
					if (volume > maxVolume) {
						maxVolume = volume;
						break;
					}
				}
			}
		}
		
		for (int col1 = heightArr.length - 1; col1 >= 0; col1--) {
			for (int col2 = col1 - 1; col2 >= 0; col2--) {
				if (heightArr[col2] >= heightArr[col1]) {
					int row1 = arr.length - heightArr[col1];
					int row2 = arr.length - heightArr[col2];
					int volume = findVolume(arr, col1, col2, row1, row2);
					// Max volume found for this height.
					if (volume > maxVolume) {
						maxVolume = volume;
						break;
					}
				}
			}
		}
		return maxVolume;
	}

	static int findVolume(boolean[][] arr, int col1, int col2, int row1, int row2) {
		int volume = 0;
		int minCol = col1;
		int maxCol = col2;
		int minRow = row1;
		if (col2 < col1) {
			minCol = col2;
			maxCol = col1;
		}
		if (row2 > row1) {
			minRow = row2;
		}
		for (; minCol <= maxCol; minCol++) {
			for (int j = minRow; j < arr.length; j++) {
				if (!arr[j][minCol]) {
					volume++;
				}
			}
		}
		return volume;
	}

	private static int[] getHeightArray(boolean[][] arr) {
		int[] heightArray = new int[arr[0].length];
		for (int i = 0; i < arr[0].length; i++) {
			heightArray[i] = findHeight(arr, i);
		}
		return heightArray;
	}

	static int findHeight(boolean[][] arr, int i) {
		int count = 0;
		for (int j = arr.length - 1; j >= 0; j--) {
			if (!arr[j][i]) {
				break;
			}
			count++;
		}
		return count;
	}

}
