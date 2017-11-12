package LinkedlistProblems;

/**
 * 2.2 Return Kth to Last: IMplement an algorithm to find the kth to last element of a singly linked list.
 * @author Prakash
 *
 */
public class Kth2Last {
	/**
	 * @param args
	 */
	public void printKthNode(Node head,  int k){
		Node ptr = head;
		int len = 0;
		while(ptr != null){
			len++;
			ptr = ptr.next;
		}
		if(len<k){
			return;
		}
		
		ptr = head;
		for(int i = 0; i<len - k; i++){
			ptr = ptr.next;
		}
		
		System.out.println(ptr.d);
		
	}
}
