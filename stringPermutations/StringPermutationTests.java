package stringPermutations;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class StringPermutationTests {

	@Test
	public void test_1() {
		String str = "ab";
		List<String> list = new ArrayList<String>();
		list.add("ab");
		list.add("ba");
		assertEquals(list, StringPermutationsSolver.getPermutationsRecursive(str));
	}
	
	@Test
	public void test_2() {
		String str = "abc";
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("acb");
		list.add("bac");
		list.add("bca");
		list.add("cab");
		list.add("cba");
		assertEquals(list, StringPermutationsSolver.getPermutationsRecursive(str));
	}

}
