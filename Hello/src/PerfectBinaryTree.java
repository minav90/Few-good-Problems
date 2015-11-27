
public class PerfectBinaryTree {

	public static void main(String[] args) {

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
		root.right.left.left = new Node(25);
		root.right.left.right = new Node(26);
		root.right.right.left = new Node(27);
		root.right.right.right = new Node(28);

		int height = height(root);
		System.out.print(root.val + " ");
		System.out.print(root.left.val + " ");
		System.out.print(root.right.val + " ");
		for (int i = 1; i < height; i++) {
			printPerfectBinaryTree(root.left, root.right, i);
		}

	}

	private static int height(Node root) {

		if (root == null)
			return 0;

		return max(height(root.left),height(root.right)) + 1;
	}

	private static int max(int left, int right) {
		return left > right ? left : right;
	}

	private static void printPerfectBinaryTree(Node root, Node root2, int index) {

		if (root == null || root2 == null)
			return;

		if (index == 0) {
			System.out.print(root.val + " ");
			System.out.print(root2.val + " ");
			return;
		}

		printPerfectBinaryTree(root.left, root2.right,index - 1);
		printPerfectBinaryTree(root.right, root2.left,index - 1);

	}

	static class Node {
		int val;
		Node left;
		Node right;

		Node(int val) {
			this.val = val;
		}
	}

	static class Max {
		int max_sum;
		Node max_node;

		public Max(int max_sum, Node max_node) {
			this.max_sum = max_sum;
			this.max_node = max_node;
		}

	}

}
