
public class MaxPossibleSumBTWTwoNode {

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
            
			Max m = new Max();
			maxPossibleSum(root,m);
			System.out.println(m.max);
			

		}

	

		private static int maxPossibleSum(Node root, Max m) {

			if(root == null)
			{
				return 0;
			}
			
			if(root.left == null && root.right == null)
			{
				return root.val;
			}
			
			int lVal = maxPossibleSum(root.left, m);
			int rVal = maxPossibleSum(root.right, m);
			
			if(root.left != null && root.right != null)
			{
				m.max = max(m.max,(lVal + rVal + root.val));
				
				return max(lVal,rVal) + root.val;
			}
			
			return root.left == null ? rVal + root.val : lVal + root.val;
		}

		public static int max(int a,int b)
		{
			return a>b?a:b;
		}
		
		static class Max
		{
			int max;
			
		}


		static class Node {
			int val;
			Node left;
			Node right;

			Node(int val) {
				this.val = val;
			}
		}

	
}
