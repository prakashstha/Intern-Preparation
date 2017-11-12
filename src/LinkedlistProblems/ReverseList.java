package LinkedlistProblems;


public class ReverseList {
	/**
	 * This method reverse the linked list. Creating new list.
	 * @param head
	 * @return
	 */
	public Node reverseList(Node head){
		if(head == null || head.next == null){
			return head;
		}
		
		Node prev = new Node(head.d);
		Node ptr = head.next;
		while(ptr != null){
			Node current = new Node(ptr.d);
			current.next = prev;
			prev = current;
			ptr = ptr.next;
		}
		return prev;
	}
	
	private Node reverseList1(Node head){
		Node current = head;
		Node prev = null;
		Node next = null;
		while(current!=null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
	/**
	 * Reverse a Linked List in groups of given size
	 */
	private Node reverListK(Node head, int k){
		if(head == null || head.next == null){
			return head;
		}
		
		Node current = head;
		Node prev = null, next = null;
		int i = 0;
		
        /* Reverse first k nodes of linked list */
		while(current != null && i<k){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			i++;
		}
		
		head.next = reverListK(current, k);
		/* prev is now head of the list*/
		return prev;
	}
}
