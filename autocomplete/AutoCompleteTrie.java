package autocomplete;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class AutoCompleteTrie {
	private static class TrieNode {
		private Character character;
		private HashMap<Character, TrieNode> children;
		
		public TrieNode(Character c) {
			character = c;
			children = new HashMap<Character, TrieNode>();
		}
		
		public Character getNodeValue() {
			return character;
		}
		
		public Collection<TrieNode> getChildren() {
			return children.values();
		}
		
		public Set<Character> getChildreNodeValues() {
			return children.keySet();
		}
		
		public void add(char c) {
			if (!children.containsKey(c)) {
				children.put(c, new TrieNode(c));
			}
 		}
		
		public TrieNode getChildrenNode(char c) {
			return children.get(c);
		}
		
		public boolean contains(char c) {
			return children.containsKey(c);
		}
		
		public int hashCode() {
			return character.hashCode();
		}
		
		public boolean equals(Object obj) {
			if (!(obj instanceof TrieNode)) {
				return false;
			}
			TrieNode that = (TrieNode) obj;
			return character.equals(that.character);
		}
	}
	
	private final TrieNode rootNode;
	
	public AutoCompleteTrie() {
		rootNode = new TrieNode(null);
	}

	public void add(String word) {
		addRecursively(rootNode, word);
	}

	private void addRecursively(TrieNode node, String word) {
		if (word.isEmpty()) {
			return;
		}
		char firstChar = word.charAt(0);
		node.add(firstChar);
		addRecursively(node.getChildrenNode(firstChar), word.substring(1));
	}

	public List<String> findCompletions(String prefix) {
		LinkedList<String> completions = new LinkedList<String>();
		findCompletionsHelper(rootNode, completions, prefix, "");
		return completions;
	}

	private void findCompletionsHelper(TrieNode root, LinkedList<String> completions, String prefix, String word) {
		if (prefix.isEmpty()) {
			String append = "";
			if (root.getNodeValue() != null) {
				append += root.getNodeValue();
			}
			if (root.getChildren().isEmpty()) {
				completions.add(word + append);
			} else {
				// else still contains children.
				for (TrieNode child : root.getChildren()) {
					findCompletionsHelper(child, completions, prefix, word + append);
				}
			}
		} else {
			Character c = prefix.charAt(0);
			if (root.getNodeValue() == null) {
				for (TrieNode child : root.getChildren()) {
					findCompletionsHelper(child, completions, prefix, word);
				}
			}
			else if (root.getNodeValue().equals(c)) {
				for (TrieNode child : root.getChildren()) {
					findCompletionsHelper(child, completions, prefix.substring(1), word + c);
				}
			}
		}
		
	}
}
