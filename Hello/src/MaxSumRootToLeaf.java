
public class MaxSumRootToLeaf {

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
		root.right.left.left = new Node(9);
		// System.out.println(readBinaryTree(root));
		System.out.println(maxSumRootToLeaf(root));
	}

	private static int maxSumRootToLeaf(Node root) {


		if (root == null) {
			return 0;
		}

		Node maxNode = null;
		Max max = new Max(0,maxNode);
		getMaxVal(root,max,0);

		return max.max_sum;
	}

	private static void getMaxVal(Node root, Max max,int curr) {

		if(root == null)
			return;
		
		curr += root.val;
		
		if(root.left == null && root.right == null)
		{
			if(curr > max.max_sum)
			{	
				max.max_sum = curr;
               	max.max_node = root;	
			}
		
		}
		
	    getMaxVal(root.left, max,curr);
	    getMaxVal(root.right, max,curr);
	
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
