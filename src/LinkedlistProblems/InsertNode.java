package LinkedlistProblems;

/**
 * Node insertion in the linked list.
 * @author Prakash
 *
 */

public class InsertNode {
	/**
	 * Insert a node in the sorted linked list in sorted order.
	 * @param head
	 * @param val
	 * @return
	 */
	public Node sortedInsert(Node head, int val){
		Node newNode = new Node(val);
		
		/* if list of empty or if need to add at head position*/
		if(head == null || head.d>=val){
			newNode.next = head;
			return newNode;
		}
		
		Node prev = head;
		Node temp = head.next;
		
		/* look for appropriate position to add*/
		while(temp!=null){
			if(temp.d>=val){
				newNode.next = temp;
				prev.next = newNode;
				break;
			}
			prev = temp;
			temp = temp.next;
			
		}
		
		/*if need to add at the end of the list*/
		if(temp == null){
			prev.next = newNode;
		}
		return head;
	}
}
