package LinkedlistProblems;

import java.util.HashSet;

/**
 * 
 * @author Prakash
 *
 */
public class Triplet {
	private void tripletInList(Node ptr1, Node ptr2, Node ptr3, int n){
		Node p1 = ptr1;
		Node p2 = ptr2; 
		Node p3 = ptr3;
		boolean found = false;
		
//		/* looping through each list. Complexity: O(n^3)*/
//		while(p1!=null){
//			p2 = ptr2;
//			while(p2!=null){
//				p3 = ptr3;
//				while(p3!=null){
//					if(p1.d + p2.d + p3.d == n){
//						System.out.println("Triplets are : " + p1.d + ", " + p2.d + ", "+ p3.d);
//						return;
//					}
//					p3 = p3.next;
//				}
//				p2 = p2.next;
//			}
//			p1 = p1.next;
//		}
//		System.out.println("No triplets found.");
		
		/*A bit optimized. Complexity: O(n^2)*/
		HashSet<Integer> hSet = new HashSet<>();
		while(p3!=null){
			hSet.add(p3.d);
			p3 = p3.next;
		}
		
		while(p1 != null){
			p2 = ptr2;
			while(p2!=null){
				int tempSum = p1.d + p2.d;
				if(hSet.contains(n-tempSum)){
					System.out.println("Triplets are : " + p1.d + ", " + p2.d + ", "+ (n - p1.d - p2.d));
					return;
				}
				p2 = p2.next;
			}
			p1 = p1.next;
		}
		System.out.println("No triplets found.");
	}
}
