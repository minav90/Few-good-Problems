import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;



public class BinaryTreeIterator {





	public static void main(String[] args) {
		
		BST bst = new BST();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(7);
		root.left.right.right = new Node(6);
		root.left.left.left = new Node(10);
		root.left.left.right = new Node(11);
		root.right.right = new Node(8);
		root.right.left = new Node(15);
		root.right.left.left = new Node(9);
		bst.root = root;
		Iterator<Node> iterator = bst.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next().val);
		}
	}
	
	public static class BST implements Iterable<Node>
	{
		Node root;

		@Override
		public Iterator<Node> iterator() {

			return (Iterator<Node>) (root == null ? Collections.emptyIterator() : new NodeIterator(root));
			
		}
		
	}
	
	public static class NodeIterator implements Iterator<Node>
	{

		Node start;
		LinkedList<Node> lst;
		
		
		
		public NodeIterator(Node root) {
			this.start = root;
			this.lst = new LinkedList<Node>();
			lst.add(start);
		}

		@Override
		public boolean hasNext() {
			return !lst.isEmpty();
		}

		@Override
		public Node next() {
			Node temp = lst.removeFirst();
			if(temp.left != null)
				lst.add(temp.left);
			if(temp.right != null)
				lst.add(temp.right);
			return temp;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

	public static class Node
	{
		int val;
		Node left;
		Node right;
		
		public Node(int val)
		{
			this.val = val;
		}
	}
	
}

	
