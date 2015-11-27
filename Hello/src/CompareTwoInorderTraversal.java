import java.util.Iterator;
import java.util.Stack;

public class CompareTwoInorderTraversal {

	public static void main(String[] args) {

	}

	public static boolean compare(Node root1, Node root2) {

		InOrderIterator inFirst = new InOrderIterator(root1);
		InOrderIterator inSecond = new InOrderIterator(root2);
		while(inFirst.hasNext() && inSecond.hasNext())
		{
			if(inFirst.next().val != inSecond.next().val)
				return false;
		}
		return !inFirst.hasNext() && !inSecond.hasNext();
	}

	public static class InOrderIterator implements Iterator<Node> {
		public Node root;
		public Stack<Node> stack;

		public InOrderIterator(Node root) {

			this.root = root;
			stack = new Stack<Node>();
			while (root != null) {
				stack.push(root);
				root = root.left;
			}

		}

		@Override
		public boolean hasNext() {

			return !stack.isEmpty();
		}

		@Override
		public Node next() {
			Node temp = stack.pop();
			Node n = temp.right;
			while (n != null) {
				stack.push(n);
				n = n.left;
			}
            return temp;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}

	}

	public static class Node {
		int val;
		Node left;
		Node right;

		public Node(int val) {
			this.val = val;
		}
	}

}
