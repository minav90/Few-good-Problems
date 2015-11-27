

public class FindClosestToVal {

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
		System.out.println(findClosest(root,12));
		
	}
	
	private static int findClosest(Node root, int x) {

		if(root == null)
			return -1;
		if(root.val == x)
		   return root.val;
		
		if(x- root.val > 0)
		{
			if(root.right != null)
			{
				int rightVal = findClosest(root.right, x);
				return Math.abs(rightVal - x) > Math.abs(root.val - x) ? root.val : rightVal;
			}
			else
				return root.val;
		}
		else
		{
			if(root.left != null)
			{
				int leftVal = findClosest(root.left, x);
				return Math.abs(leftVal - x) > Math.abs(root.val - x) ? root.val : leftVal;
			}
			else
				return root.val;
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
