package domHierarchy;

import static org.junit.Assert.*;

import org.junit.Test;

import domHierarchy.DomHierarchy.Node;

public class Tests {

	@Test
	public void test1() {
		//<a>
		//  <p> </p>
		//</a>
		Node root = new Node();
		root.firstChild = new Node();
		DomHierarchy dom = new DomHierarchy();
		assertEquals(1, dom.countDescendants(root));
	}

	@Test
	public void test2() {
		//<a>
		//  <p> </p>
		//  <a></a>
		//</a>
		//<a> </a>
		Node root = new Node();
		root.firstChild = new Node();
		root.firstChild.nextSibling = new Node();
		root.nextSibling = new Node();
		DomHierarchy dom = new DomHierarchy();
		assertEquals(2, dom.countDescendants(root));
	}
	
	@Test
	public void test3() {
		//<a>
		//</a>
		Node root = new Node();
		DomHierarchy dom = new DomHierarchy();
		assertEquals(0, dom.countDescendants(root));
	}
	
	@Test
	public void test4() {
		//<a>
		//  <p> </p>
		//  <a>
		//    <p> </p>
		//  </a>
		//</a>
		//<a> </a>
		Node root = new Node();
		root.firstChild = new Node();
		root.firstChild.nextSibling = new Node();
		root.firstChild.nextSibling.firstChild = new Node();
		root.nextSibling = new Node();
		DomHierarchy dom = new DomHierarchy();
		assertEquals(3, dom.countDescendants(root));
	}
	
	
	@Test
	public void test5() {
		// null
		DomHierarchy dom = new DomHierarchy();
		assertEquals(0, dom.countDescendants(null));
	}
}
