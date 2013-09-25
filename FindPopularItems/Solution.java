package findPopularItems;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * Solution for Codility.com to find the three elements that appear the most in the list. Print list
 * in descending order, and if there are any ties, print those elements by alphabetical order.
 * 
 * @author Jaime Guajardo
 *
 */
public class Solution {
	public static class ThreeLargestHashMap {
		public static class MyComparator  implements Comparator {
		    public int compare(Object o1, Object o2) {
				Entry<String, Integer> entry1 = (Entry<String, Integer>) o1;
				Entry<String, Integer> entry2 = (Entry<String, Integer>) o2;
		    
			  if (entry1.getValue().equals(entry2.getValue())) {
				  return entry1.getKey().compareTo(entry2.getKey());
			  }
		      return entry2.getValue().compareTo(entry1.getValue());
		    }

		}
		private HashMap<String, Integer> map;
		public ThreeLargestHashMap() {
			map = new HashMap<String, Integer>();
		}
		public void addToMap(String str, Integer value) {
			if (value == null) {
				return;
			}
			if (map.size() < 3) {
				map.put(str, value);
			} else {
				// If value is greater than another, find min and remove it.
				String minKey = "";
				for (Entry<String, Integer> entry : map.entrySet()) {
					if (entry.getValue() < value) {
						if (minKey == "" || entry.getValue() < map.get(minKey)) {
							minKey = entry.getKey();
						}
					}
				}
				map.remove(minKey);
				map.put(str, value);
			}
		}
		public void printOrdered() throws IOException {
			ArrayList<Entry<String,Integer>> list = new ArrayList<Entry<String,Integer>>();
			list.addAll(map.entrySet());
			Collections.sort(list, new MyComparator());
			for (Entry<String, Integer> entry : list) {
				System.out.printf(entry.getKey().trim());
			}
			

		}
	}
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		HashMap<String,Integer> map = new HashMap<String, Integer>();
		ThreeLargestHashMap threeLargestMap = new ThreeLargestHashMap();
		int num = scanner.nextInt();
		while (num >= 0) {
			String str = scanner.nextLine();
			Integer val = map.get(str);
			if (val == null) {
				map.put(str, 1);
			} else {
				map.put(str, ++val);
			}
			threeLargestMap.addToMap(str, val);
			num--;
		}
		threeLargestMap.printOrdered();
	}

}
