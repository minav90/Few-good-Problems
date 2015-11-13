import java.util.ArrayList;


public class PrintAtKLevel {

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

		int parent[] = new int[100];
		Info i =new Info();
		printAtKLevel(root,parent,i,2,0);

	}

	private static void printAtKLevel(Node root, int parent[],Info i, int k,int pathLen) {

		if (root == null) {
			return;
		}
		
		parent[pathLen] = root.val;
		pathLen++;

		if (root.left == null && root.right == null) {
			int temp = pathLen - k - 1;
			if (temp >= 0 && !i.visited.contains(parent[temp])) {
				System.out.println(parent[temp]);
				i.visited.add(parent[temp]);
			}
		}
		
		printAtKLevel(root.left, parent,i, k,pathLen);
		printAtKLevel(root.right, parent,i, k,pathLen);

	}

	static class Info {
		ArrayList<Node> parent = new ArrayList<Node>();
		ArrayList<Integer> visited = new ArrayList<Integer>();
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
