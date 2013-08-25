package lowestCommonAncestor;

/**
 * Finds lowest common ancestor in a binary search tree.
 * @author jaimeguajardo
 *
 */
public class LowestCommonAncestorSolver {

	static String findLowestAncestor(BinaryTree<String> tree, String item1, String item2) {
		// If items in different subtrees, common ancestor found.
		if (item1.compareTo(tree.data) < 0 && item2.compareTo(tree.data) > 0 
				|| item1.compareTo(tree.data) > 0 && item2.compareTo(tree.data) < 0) {
			return tree.data;
		}
		// Else if both items in same subtree and one is immediate child, ancestor found.
		else if (item1.equals(tree.left.data) || item2.equals(tree.left.data) 
				|| item1.equals(tree.right.data) || item2.equals(tree.right.data)) {
			return tree.data;
		}
		// Else both items are in same subtree.
		else {
			// Items are both in right subtree.
			if (item1.compareTo(tree.data) > 0 && item2.compareTo(tree.data) > 0) {
				return findLowestAncestor(tree.right, item1, item2);
			}
			// Items are both in left subtree.
			else {
				return findLowestAncestor(tree.left, item1, item2);
			}
		}
	}
}
