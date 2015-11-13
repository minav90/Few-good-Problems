public class CountSingleSubTree {

	public static void main(String[] args) {

		Node root = new Node(5);
		root.left = new Node(4);
		root.right = new Node(5);
		root.left.left = new Node(5);
		root.left.right = new Node(5);
		root.right.right = new Node(5);
		Count c = new Count(0);
		countSingleTree(root, c);
		System.out.println(c.count);

	}

	private static Node countSingleTree(Node root, Count c) {

		if (root == null)
			return null;
		if (root.left == null && root.right == null) {
			c.count++;
			return root;
		}

		countSingleTree(root.left, c);
		countSingleTree(root.right, c);
		
		
		if (root.left != null && root.right != null) {
			if (root.left.val == root.right.val && root.left.val == root.val) {
				c.count++;
				return root;
			} else
				return null;
		}

		if (root.left != null && root.left.val == root.val) {
			c.count++;
			return root;
		}

		if (root.right != null && root.right.val == root.val) {
			c.count++;
			return root;
		}

		return null;
	}

	static class Count {
		int count;

		public Count(int count) {
			this.count = count;
		}

	}

	static class Node {
		int val;
		Node left;
		Node right;

		public Node(int val) {
			this.val = val;
		}

	}

}
