package findLargestFourElements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Finds largest four numbers in list in O(N) time.
 * @author Jaime Guajardo
 *
 */
public class FindLargestFourElements {

	public static LinkedList<Integer> getTopFourElements(ArrayList<Integer> list) throws Exception {
		if (list == null || list.size() < 4) {
			throw new Exception("Error: Size less than 4.");
		}
		LinkedList<Integer> topFourElements = getFirstFourOrdered(list);
		for (int i = 4; i < list.size(); i++) {
			Integer num = list.get(i);
			// If number is greater than smallest number, removeFirst and place in correct position.
			if (num > topFourElements.getFirst()) {
				topFourElements.removeFirst();
				putNumInCorrectPosition(num, topFourElements);
			}
		}
		return topFourElements;
	}

	// Gets first four elements of list ordered in ascending order.
	private static LinkedList<Integer> getFirstFourOrdered(ArrayList<Integer> list) {
		LinkedList<Integer> firstFourOrdered = new LinkedList<Integer>(list.subList(0, 4));
		Collections.sort(firstFourOrdered);
		return firstFourOrdered;
	}

	// Places number in correct position to maintain list order.
	private static void putNumInCorrectPosition(Integer num, LinkedList<Integer> topFourList) {
		for (int i = 0; i < topFourList.size(); i++) {
			Integer currentNum = topFourList.get(i);
			if (num <= currentNum) {
				topFourList.add(i, num);
				return;
			}
		}
		topFourList.addLast(num);	
	}
}
