package stringPermutations;

import java.util.ArrayList;
import java.util.List;

public class StringPermutationsSolver {
	
	static List<String> getPermutationsRecursive(String str) {
		ArrayList<String> list = new ArrayList<String>();
		recursive(str, "", list);
		return list;
	}

	private static void recursive(String str, String mutation, ArrayList<String> list) {
		if (str.isEmpty()) {
			list.add(mutation);
			return;
		}
		for(int i = 0; i < str.length(); i++) {
			recursive(removeNthChar(str, i), mutation.concat("" + str.charAt(i)), list);
		}
	}

	private static String removeNthChar(String str, int n) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (i != n) {
				builder.append(str.charAt(i));
			}
		}
		return builder.toString();
	}
}
