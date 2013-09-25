package treeDiamater;

public class FindTreeDiameter {
	public static class Node {
		Node left, right;
		int data;
		public Node(int newData) {
			left = right = null;
			data = newData;
		}
	}

	static int diameterOfTree(Node root) {
		return findMaxHeightTree(root.left) + findMaxHeightTree(root.right) + 1;
	}

	static int findMaxHeightTree(Node root) {
		if (root == null) {
			return 0;
		} else {
			return 1 + Math.max(findMaxHeightTree(root.left), findMaxHeightTree(root.right));
		}
	}
}
