import java.util.ArrayList;

public class SmallCount {
	
	public static void main(String[] args) {
		
		int arr [] = new int[]{ 84, 2, 37, 3, 67, 82, 19, 97, 91, 63, 27, 6, 13, 90, 63, 89, 100, 60, 47, 96, 54, 26, 64, 50, 71, 16, 6, 40, 84, 93, 67, 85, 16, 22, 60 };
		ArrayList<Integer> num = new ArrayList<Integer>();
		for(int a : arr)
		{
			num.add(a);
		}
		System.out.println(countInversions(num));
		
	}
	
	public static int countInversions(ArrayList<Integer> a) {
	    
	    Node root = null;
	    Count c = new Count();
	    for(int i = a.size()-1;i>=0;i--)
	    {
	       root = insert(root,a,i,1,0,c);
	    }
	    return c.val;
	}
	
	public static Node insert(Node root,ArrayList<Integer> a,int ind,int L,int small,Count c)
	{
	    if(root == null)
	    {
	        root = new Node(a.get(ind),L,small);
	        return root;
	    }
	    if(a.get(ind) < root.val)
	    {
	        root.left = insert(root.left,a,ind,1,0,c);
	    }
	    else
	    {
	        c.val = c.val + root.L;
	        root.right = insert(root.right,a,ind,1,root.L,c);
	    }
	    return root;
	}
	static class Count
	{
	    int val;
	}
	static class Node
	{
	    int val;
	    int L;
	    int small;
	    Node left;
	    Node right;
	    Node(int val,int L,int small)
	    {
	        this.val = val;
	        this.L = L;
	        this.small = small;
	    }
	}
	
}
