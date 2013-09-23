package TreeDiamater;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFindTreeDiameter {

	@Test
	public void test1() {
		//       40
		//   30     65
		//  22 38  78
		FindTreeDiameter.Node root = new FindTreeDiameter.Node(40);
		root.left = new FindTreeDiameter.Node(30);
		root.left.left = new FindTreeDiameter.Node(22);
		root.left.right = new FindTreeDiameter.Node(38);
		root.right = new FindTreeDiameter.Node(65);
		root.right.left = new FindTreeDiameter.Node(78);
		assertEquals(5, FindTreeDiameter.diameterOfTree(root));
	}

}
