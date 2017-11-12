package LinkedlistProblems;

import java.util.Stack;

/**
 * Implement a function to check if a linked list is a palindrome
 * 
 * @author Prakash
 */
public class CheckPalindrome {
	/**
	 * 2.6. Implement a function to check if a linked list is a palindrome
	 * * <ul>
	 * 		<li> Get the reverse of linked list </li>
	 * 		<li> Compare reverse linked list with original</li>
	 * 		<li> If they are same --> palindrome, otherwise --> not-palindrome</li>
	 * </ul>
	 * @param head
	 */
	public boolean isPalindrome1(Node head){
		if(head == null){
			return false;
		}
		
		if(head.next == null){
			return true;
		}
		
		ReverseList rl = new ReverseList();
		Node revList = rl.reverseList(head);
		while(head != null || revList != null){
			if(head.d != revList.d){
				return false;
			}
			head = head.next;
			revList = revList.next;
		}
		return true;
	}
	
	/**
	 * Using STACK
	 * <ul>
	 * 		<li> Use slow and fast pointer to reach the middle of the linked list. </li>
	 * 		<li> Put the first half elements of linked list to the STACK </li>
	 * 		<li> Compare the first half from the stack with the second half of the linked list.</li>
	 * </ul>
	 * @param head
	 * @return
	 */
	public boolean isPalindrome2(Node head){
		if(head == null){
			return false;
		}
		
		if(head.next == null){
			return true;
		}
	
		Stack<Integer> stck = new Stack<>();
		Node fastPtr = head.next;
		Node slowPtr = head;
		stck.push(slowPtr.d);
		int len = 2;
		while(fastPtr.next != null){
			
			slowPtr = slowPtr.next;
			stck.push(slowPtr.d);
			if(fastPtr.next.next!=null){
				fastPtr = fastPtr.next.next;
				len = len + 2;
			}else{
				fastPtr = fastPtr.next;
				len = len + 1;
			}
			System.out.println(slowPtr.d + ": " + fastPtr.d);
		}
		System.out.println("LEngth: " + len);
		
		if(len%2 != 0){
			stck.pop();
		}
		slowPtr = slowPtr.next;
		while(!stck.isEmpty() || slowPtr != null){
			if(stck.pop() != slowPtr.d)
				return false;
			
			slowPtr = slowPtr.next;
		}
		if(stck.isEmpty() && slowPtr == null)
			return true;
		return false;
	}
}
