package autocomplete;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class Tests {

	@Test
	public void testTreeSet1() {
		AutoCompleteTreeSet treeSet = new AutoCompleteTreeSet();
		treeSet.add("ha");
		treeSet.add("hello");
		treeSet.add("hi");
		treeSet.add("bye");
		ArrayList<String> expectedResponse = new ArrayList<String>();
		expectedResponse.add("ha");
		expectedResponse.add("hello");
		expectedResponse.add("hi");
		assertEquals(expectedResponse, treeSet.findCompletions("h"));
	}
	
	@Test
	public void testTreeSet2() {
		AutoCompleteTreeSet treeSet = new AutoCompleteTreeSet();
		treeSet.add("ha");
		treeSet.add("hello");
		treeSet.add("hi");
		treeSet.add("bye");
		ArrayList<String> expectedResponse = new ArrayList<String>();
		expectedResponse.add("hello");
		assertEquals(expectedResponse, treeSet.findCompletions("he"));
	}
	
	@Test
	public void testAutoCompleteTrie1() {
		AutoCompleteTrie trie = new AutoCompleteTrie();
		trie.add("hello");
		trie.add("hi");
		trie.add("ha");
		ArrayList<String> expectedResponse = new ArrayList<String>();
		expectedResponse.add("hello");
		assertEquals(expectedResponse, trie.findCompletions("he"));
	}
	
	@Test
	public void testAutoCompleteTrie2() {
		AutoCompleteTrie trie = new AutoCompleteTrie();
		trie.add("hello");
		trie.add("hi");
		trie.add("ha");
		ArrayList<String> expectedResponse = new ArrayList<String>();
		expectedResponse.add("hello");
		expectedResponse.add("ha");
		expectedResponse.add("hi");
		assertEquals(expectedResponse, trie.findCompletions(""));
	}

}
