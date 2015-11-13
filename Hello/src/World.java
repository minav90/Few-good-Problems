
public class World {

	public static void main(String[] args) {

		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		node.next.next.next.next.next = new ListNode(6);
		node.next.next.next.next.next.next = new ListNode(7);
		node.next.next.next.next.next.next.next = new ListNode(8);
		node.next.next.next.next.next.next.next.next = new ListNode(9);
		ListNode main = reverse(node, 3);
		
		while(main != null)
		{
			System.out.println(main.val);
			main = main.next;
		}

	}

	public static ListNode reverse(ListNode node, int k) {

		ListNode main = null;
		ListNode head = node;
		ListNode tail = node;
		ListNode prev = null;
		int index = 0;
		boolean flag = true;
		while (tail != null) {
			index++;
			prev = tail;
			tail = tail.next;
			if (index == 3) {
				if (flag) {
					if(main == null)
						main = prev;
					prev.next = null;
					process(head, prev).next = tail;
				}
				index = 0;
				flag = !flag;
				head = tail;
			}
		}

		return main;
	}

	public static ListNode process(ListNode head, ListNode tail) {

		ListNode temp = head;
		ListNode prev = null;
		ListNode next = null;
		
		while(head != null)
		{
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		
		return temp;
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}
}
