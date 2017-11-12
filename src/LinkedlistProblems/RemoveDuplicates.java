package LinkedlistProblems;

import java.util.HashSet;

/**
 * Remove Duplicates.
 * @author Prakash
 *
 */
public class RemoveDuplicates {
	/**
	 * Write a removeDuplicates() function which takes a list sorted in 
	 * non-decreasing order and deletes any duplicate nodes from the list. 
	 * The list should only be traversed once.
	 * @param head
	 */
	public void sortedRemoveDuplicates(Node head){
		while(head !=null && head.next != null){
			if(head.d == head.next.d){
				head.next = head.next.next;
			}else{
				head = head.next;
			}
		}
	}
	/**
	 * 2.1. Remove Dups: Write code to remove duplicates from an unsorted linked list.
	 * Time Complexity: O(n^2)
	 * @param head head of the linked list. 
	 * @return
	 */
	public void removeDuplicates(Node head){
		Node ptr1 = head;
		Node ptr2 = null;
		while(ptr1 != null && ptr1.next != null){
			ptr2 = ptr1;
			while(ptr2.next != null){
				if(ptr1.d == ptr2.next.d){
					ptr2.next = ptr2.next.next;
				}else{
					ptr2 = ptr2.next;
				}
			}
			ptr1 = ptr1.next;
		}
	}
	/**
	 * 2.1. Remove Dups: Write code to remove duplicates from an unsorted linked list.
	 * Time Complexity: O(n)
	 * @param head head of the linked list. 
	 * @return
	 */
	public void removeDuplicates1(Node head){
		HashSet<Integer> hs = new HashSet<>();
		Node ptr = head;
		hs.add(head.d);
		
		while(ptr.next != null){
			if(hs.contains(ptr.next.d)){
				ptr.next = ptr.next.next;
			}else{
				hs.add(ptr.next.d);
				ptr = ptr.next;
			}	
		}
	}
	/**
	 * 2.1. Remove Dups: Write code to remove duplicates from an unsorted linked list.
	 * Time Complexity: O(n)
	 * Using MergeSort
	 * @param head head of the linked list. 
	 * @return
	 */
	public Node removeDuplicates2(Node head){
		MergeSort ms = new MergeSort();
		Node sorted = ms.mergeSort(head);
		
		Node ptr = sorted;
		while(ptr.next != null){
			if(ptr.d == ptr.next.d){
				ptr.next = ptr.next.next;
			}else{
				ptr = ptr.next;
			}
		}
		return sorted;
	}	
}
