package LinkedlistProblems;


public class MergeSort {
	/**
	 * Sort the linked list using MergeSort
	 * @param head
	 * @return
	 */
	public Node mergeSort(Node head){
		if(head == null || head.next == null){
			return head;
		}
		
		Node slowPtr = head;
		Node fastPtr = head;
		while(fastPtr != null && fastPtr.next != null){
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		
		Node nextOfMid = slowPtr.next;
		slowPtr.next = null;
		
		Node left = mergeSort(head);
		Node right = mergeSort(nextOfMid);
		Node sorted = sortedMerge(left, right);
		return sorted;
		
	}
	
	/**
	 * Merge two sorted list
	 * @param left
	 * @param right
	 * @return
	 */
	private Node sortedMerge(Node left, Node right) {
		// TODO Auto-generated method stub
		if(left == null){
			return right;
		}
		if(right == null){
			return left;
		}
		
		Node res = null;
		if(left.d<=right.d){
			res = left;
			res.next = sortedMerge(left.next, right);
		}else{
			res = right;
			res.next = sortedMerge(left, right.next);
		}
		
		return null;
	}
	/**
	 * Merge two sorted list, but result in reverse order
	 * @param left
	 * @param right
	 * @return
	 */
	private Node sortedMergeReverse(Node left, Node right) {
		// TODO Auto-generated method stub
		if(left == null){
			return right;
		}
		if(right == null){
			return left;
		}
		
		Node res = null;
		Node temp;
		if(left.d<=right.d){
			res = sortedMergeReverse(left.next, right); 
			left.next = null;
			res.next = left;
		}else{
			res = sortedMergeReverse(left, right.next);
			right.next = null;
			res.next = right;
		}
		
		return res;
	}
}
