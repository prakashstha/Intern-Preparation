package LinkedlistProblems;

/**
 * Check if two lists are identical based on their content.
 * @author Prakash
 *
 */
public class CheckIdentical {
	/**
	 * @param list1
	 * @param list2
	 * @return
	 */
	private boolean areIdentical(Node list1, Node list2){
		if(list1 == null && list2 == null){
			return true;
		}else if(list1 == null || list2 == null){
			return false;
		}
		
		if(list1.d == list2.d){
			return areIdentical(list1.next, list2.next);
		}else{
			return false;
		}
		
	}
}
