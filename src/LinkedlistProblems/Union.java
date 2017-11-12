package LinkedlistProblems;

import java.util.HashSet;
/**
 * 
 * @author Prakash
 *
 */

public class Union {
	/**
	 * Create a new list with the union of two provided list.
	 * @param m
	 * @param n
	 * @return
	 */
	private Node union(Node m, Node n){
		HashSet<Integer> hSet = new HashSet<>();
		Node union = null;
		
		while(m != null){
			if(!hSet.contains(m.d)){
				hSet.add(m.d);
				Node newNode = new Node(m.d);
				newNode.next = union;
				union = newNode;
			}
			m = m.next;
		}
		
		while(n!=null){
			if(!hSet.contains(n.d)){
				Node newNode = new Node(n.d);
				newNode.next = union;
				union = newNode;
			}
			n = n.next;
		}
		return union;
	}
}
