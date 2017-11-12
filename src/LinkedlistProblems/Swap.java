package LinkedlistProblems;

/**
 * 
 * @author Prakash
 *
 */
public class Swap {
	/**
	 * Given two keys/values, swap nodes with these values.
	 * @param x first key
	 * @param y second key
	 * @param head
	 * @return
	 */
	public Node swap(int x, int  y, Node head){
		
		boolean isXhead = false;
		
		/* if head is to be swapped */
		if(head.d == x){
			isXhead = true;
		}else if(head.d == y){
			isXhead = true;
			int temp = x;
			x = y;
			y = temp;
		}
		
		/* store previous nodes of both x, and y*/
		Node px = null, py = null;
		Node temp =head;
		while(temp.next!=null){
			if(temp.next.d == x){
				px = temp;
			}
			
			if(temp.next.d == y){
				py = temp;
			}
			temp = temp.next;
		}
		
		/*if head is to be swapped*/
		if(isXhead){
			Node newHead = py.next;
			Node nextOfy = py.next.next;
			py.next.next = head.next;
			head.next = nextOfy;
			py.next = head;
			return newHead;
		}else{
			Node tempx = px.next; //Node with x
			Node tempy = py.next; //Node with y
			
			Node nextOfY = tempy.next;
			px.next = tempy;
			tempy.next = tempx.next;
			py.next = tempx;
			tempx.next = nextOfY;
			return head;
		}
	}
	
	/**
	 * Swap the node values pairwise
	 * 1-->3-->4-->8 ==>> 3-->1-->8-->4
	 * @param m
	 */
	private void swapPairWise(Node m) {
		// TODO Auto-generated method stub
		while(m!=null &&m.next != null){
			int temp = m.d;
			m.d = m.next.d;
			m.next.d = temp;
			m = m.next.next;
		}
	}
	/**
	 * Recursive pair wise swap
	 * @param m
	 */
	private void swapPairWise1(Node m){
		if(m == null || m.next == null)
			return;
		
		int temp = m.d;
		m.d = m.next.d;
		m.next.d = temp;
		swapPairWise1(m.next.next);
	}
	
}
