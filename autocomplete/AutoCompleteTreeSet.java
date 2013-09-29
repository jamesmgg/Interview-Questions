package autocomplete;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet autocomplete implementation.
 * 
 * @author Jaime Guajardo
 *
 */
public class AutoCompleteTreeSet extends TreeSet<String> {
	private static final long serialVersionUID = 1L;

	public List<String> findCompletions(String prefix) {
		LinkedList<String> completions = new LinkedList<String>();
		Set<String> tailSet = super.tailSet(prefix);
		for (String tail : tailSet) {
			if (tail.startsWith(prefix)) {
				completions.add(tail);
			} else if (isTailPrefixGreater(tail, prefix)) {
				// Reaching this point means, all words with same prefix have been found.
				break;
			}
		}
		return completions;
	}
	
	private boolean isTailPrefixGreater(String tail, String prefix) {
		return tail.substring(0, prefix.length()).compareTo(prefix) > 0;
	}
}