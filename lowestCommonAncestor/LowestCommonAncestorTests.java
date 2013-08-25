package lowestCommonAncestor;

import static org.junit.Assert.*;

import org.junit.Test;

public class LowestCommonAncestorTests {

	@Test
	public void test_findAncestor_1() {
		BinaryTree<String> tree = new BinaryTree<String>();
		BinaryTree<String> left = new BinaryTree<String>();
		BinaryTree<String> right = new BinaryTree<String>();
		
		tree.makeRoot("1");
		left.makeRoot("2");
		right.makeRoot("3");
		tree.attachLeft(left);
		tree.attachRight(right);
		assertEquals("1",LowestCommonAncestorSolver.findLowestAncestor(tree, "2", "3"));
	}
	
	@Test
	public void test_findAncestor_2() {
		BinaryTree<String> tree = new BinaryTree<String>();
		BinaryTree<String> left = new BinaryTree<String>();
		BinaryTree<String> leftSubtree = new BinaryTree<String>();
		
		tree.makeRoot("3");
		left.makeRoot("2");
		leftSubtree.makeRoot("1");
		left.attachLeft(leftSubtree);
		tree.attachLeft(left);
		assertEquals("3",LowestCommonAncestorSolver.findLowestAncestor(tree, "2", "1"));
	}

}
