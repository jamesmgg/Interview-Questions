package domHierarchy;

import java.util.LinkedList;

public class DomHierarchy {

	public static class Node {
		public Node firstChild;
		public Node nextSibling;

		public boolean hasFirstChild() {
			return firstChild != null;
		}

		public boolean hasSibling() {
			return nextSibling != null;
		}
	}

	public int countDescendants(Node ancestor) {
		LinkedList<Node> queue = new LinkedList<Node>();
		int numDescendants = 0;
		if (ancestor != null && ancestor.hasFirstChild()) {
			// If ancestor has descendants, push first one in.
			queue.push(ancestor.firstChild);
			numDescendants++;
		}

		while (!queue.isEmpty()) {
			Node front = queue.pop();
			if (front.hasSibling()) {
				queue.push(front.nextSibling);
				numDescendants++;
			}
			if (front.hasFirstChild()) {
				queue.push(front.firstChild);
				numDescendants++;
			}
		}

		return numDescendants;
	}
}
