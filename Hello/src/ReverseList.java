

 
public class ReverseList {
	
	public static void main(String[] args) {
		
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		reverseBetween(node, 2, 3);
		
	}
	
	public static  ListNode reverseBetween(ListNode a, int m, int n) {
	    
	    ListNode head = a;
	    ListNode ptr = null;
	    ListNode curr = a;
	    ListNode next = null;
	    
	    int i = 1;
	    while(i < m)
	    {
	        ptr = curr;
	        curr = curr.next;
	        i++;
	    }
	    
	    ListNode first = ptr;
	    ptr = ptr.next;
	    ListNode start = curr;
	    curr = curr.next;
	    

	    while(curr != null && i <= n)
	    {
	        next = curr.next;
	        curr.next = ptr;
	        ptr = curr;
	        curr = next;
	        i++;
	    }
	    
	    first.next = ptr;
	    start.next = curr;
	    
	    return head;
	}
	
	static class ListNode {
	      public int val;
	      public ListNode next;
	      ListNode(int x) { val = x; next = null; }
	 }
}
