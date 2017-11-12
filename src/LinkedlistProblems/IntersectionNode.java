package LinkedlistProblems;

import java.util.HashSet;

/**
 * Intersection in the linkedlist.
 * @author Prakash
 *
 */
public class IntersectionNode {
	public Node interSectionNode(Node list1, Node list2){
		
		/* 1. Using hash set*/
//		HashSet<Integer> hSet = new HashSet<>();
//		while(list1!=null){
//			hSet.add(list1.hashCode());
//			list1 = list1.next;
//		}
//		
//		while(list2 !=null){
//			if(hSet.contains(list2.hashCode())){
//				return list2;
//			}
//			list2 = list2.next;
//		}
//		while(list1 != null || list2 != null){
//			
//			if(list1.hashCode() == list2.hashCode()){
//				return list1;
//			}
//
//			if(hSet.contains(list1.hashCode())) 
//			{
//				return list1;
//			}
//			if(hSet.contains(list2.hashCode())){
//				return list2;
//			}
//			hSet.add(list1.hashCode());
//			hSet.add(list2.hashCode());
//			list1 = list1.next;
//			list2 = list2.next;
//		}
		
		/*Using length
		 * 	1) Get count of the nodes in first list, let count be c1.
			2) Get count of the nodes in second list, let count be c2.
			3) Get the difference of counts d = abs(c1 – c2)
			4) Now traverse the bigger list from the first node till d nodes so that from here onwards both the lists have equal no of nodes.
			5) Then we can traverse both the lists in parallel till we come across a common node. (Note that getting a common node is done by comparing the address of the nodes)
		*/
		Node ptr1 = list1;
		Node ptr2 = list2;
		int len1 = 0,len2 =0;
		while(list1!= null){
			len1++;
			list1 = list1.next;
		}
		while(list2!= null){
			len2++;
			list2 = list2.next;
		}
		int lenDif = Math.abs(len1-len2);
		Node tempx = null;
		Node tempy = null;
		if(len1>len2){
			tempx = ptr1;
			tempy = ptr2;
		}else{
			tempx = ptr2;
			tempy = ptr1;
		}
		
		while(lenDif !=0){
			tempx = tempx.next;
			lenDif--;
		}
		
		while(tempx != null || tempy!= null){
			if(tempx.hashCode() == tempy.hashCode()){
				return tempx;
			}
			tempx = tempx.next;
			tempy = tempy.next;
		}
		
		
		return null;
		
	}

/**
 * Create a new list with the intersection of two provided list.
 * @param m
 * @param n
 * @return
 */
private Node intersection(Node m, Node n){
	HashSet<Integer> hSet = new HashSet<>();
	while(m != null){
		hSet.add(m.d);
		m = m.next;
	}
	Node interSection = null;
	while(n!=null){
		if(hSet.contains(n.d)){
			Node newNode = new Node(n.d);
			newNode.next = interSection;
			interSection = newNode;
		}
		n = n.next;
	}
	
	return interSection;
}
}
