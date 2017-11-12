package LinkedlistProblems;

import java.util.HashSet;


/**
 * Detect the present of loop in given linked list by modifying the structure of 
 * linked list i.e., adding visited flag in the Node implementation.
 * @author Prakash
 *
 */
public class DetectLoop {
	/**
	 * @param head
	 * @return
	 */
	public boolean isLoopPresent(Node head){
		while(head !=null){
			if(head.isVisited){
				System.out.println(head.hashCode());
				return true;
			}else{
				System.out.println(head.hashCode());
				head.isVisited = true;
			}
			head = head.next;
		}
		return false;
	}
	
	/**
	 * Using Hashing
	 * @param head
	 * @return
	 */
	public boolean isLoopPresent1(Node head){
		HashSet<Integer> addrSet = new HashSet<>();
		while(head != null){
			if(addrSet.contains(head.hashCode())){
				return true;
			}
			addrSet.add(head.hashCode());
			head = head.next;
		}
		return false;
	}
}
