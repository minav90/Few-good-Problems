import java.util.Comparator;
import java.util.PriorityQueue;


public class MergeKSinglyList {

	public static void main(String[] args) {
		
		Node list[] = new Node[3];
		Node node1 = new Node(5);
		node1.next = new Node(9);
		node1.next.next = new Node(15);
		list[0] = node1;
		
		Node node2 = new Node(4);
		node2.next = new Node(6);
		node2.next.next = new Node(19);
		list[1] = node2;
		
		Node node3 = new Node(7);
		node3.next = new Node(18);
		node3.next.next = new Node(25);
		list[2] = node3;
		
		Node finalnode = merge(list);
		while(finalnode != null)
		{
			System.out.print(finalnode.val + " ");
			finalnode = finalnode.next;
		}
	}
	
	public static Node merge(Node[] list)
	{
		Node dummy = new Node(0);
		PriorityQueue<Node> pq = new PriorityQueue<Node>(list.length,new Comparator<Node>() {
			
			public int compare(Node a, Node b)
			{
				return a.val - b.val;
			}
		});
		
		Node tail = dummy;
		for(Node node: list)
		{
			pq.offer(node);
		}
		
		while(!pq.isEmpty())
		{
			Node temp = pq.poll();
			tail.next = temp;
			tail = temp;
			if(temp.next != null)
			{
				pq.offer(temp.next);
			}
		}
		return dummy.next;
	}
	
	static class Node
	{
		public Node(int i) {
          val = i;
		}
		int val;
		Node next;
	}
}
