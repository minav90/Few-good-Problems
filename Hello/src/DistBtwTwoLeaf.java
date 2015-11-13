
public class DistBtwTwoLeaf {
	



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
		//System.out.println(maxSumRootToLeaf(root));
		System.out.println(distBtwTwoLeaf(root,6,1));
	}
	

	private static int distBtwTwoLeaf(Node root, int i, int j) {

		Distance d = new Distance(-1, -1, 0);
		
		Node node = distFromLCA(root,i,j,d,0);
		
		if(d.d1 != -1 && d.d2 != -1)
		{
			return d.dist;
		}
		
		if(d.d1 != -1)
		{
			return findLevel(node,j,0);
		}
		
		if(d.d2 != -1)
		{
			return findLevel(node,i,0);
		}
		
		return -1;
	}
	
	private static int findLevel(Node node, int j, int level) {

		if(node == null)
			return 0;
		
		if(node.val == j)
			return level;
		
		int l = findLevel(node.left,j,level+1);
		return l != -1 ? l : findLevel(node.right,j,level+1); 
	}


	private static Node distFromLCA(Node root, int n1, int n2, Distance d,int level) {

		if(root == null)
		{
			return null;
		}
		
		if(root.val == n1)
		{
		    d.d1 = level;
		    return root;
		}
		
		if(root.val == n2)
		{
		    d.d2 = level;	
		    return root;
		}
		
		
		Node ldis = distFromLCA(root.left,n1,n2,d,level+1);
		Node rdis = distFromLCA(root.right,n1,n2,d,level+1);
		
		if(ldis != null && rdis != null)
		{
			d.dist = d.d1 + d.d2 - 2*level;
			return root;
		}
		
		return (ldis != null)? ldis: rdis;
		
	}

	static class Distance
	{
		int d1;
		int d2;
		int dist;

		public Distance(int d1, int d2, int dist) {
			this.d1 = d1;
			this.d2 = d2;
			this.dist = dist;
		}
		
		
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
