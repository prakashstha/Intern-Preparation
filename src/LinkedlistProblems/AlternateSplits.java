package LinkedlistProblems;

/**
 * Write a function AlternatingSplit() that takes one list and divides up its nodes to 
 * make two smaller lists ‘a’ and ‘b’. The sublists should be made from alternating elements 
 * in the original list.
 * 
 * @author Prakash
 */
public class AlternateSplits {
	
	/**
	 * @param head
	 */
	private void alternateSplit(Node head){
		if (head == null || head.next == null){
			return;
		}
		
		Node ptr1 = head;
		Node ptr2 = head.next;
		
		/*Storing heads for two list*/
		Node list1 = ptr1;
		Node list2 = ptr2;
		
		ptr1.next = ptr2.next;
		ptr1 = ptr1.next;
		
		while(ptr1 !=null && ptr1.next!=null){
			Node next = ptr1.next;
			ptr1.next = next.next;
			ptr2.next = next;
			
			/*Move to next node*/
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		
		Node temp = new Node(2);
		temp.displayList(list1);
		temp.displayList(list2);
	}
}
