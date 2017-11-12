package LinkedlistProblems;

/**
 * Delete operations on linkedlist.
 * 
 * @author Prakash
 */
public class DeleteOperation {
	/**
	 * Given a key/value, delete all occurrences of all the nodes with given key/value
	 * @param data
	 * @param head
	 */
	public Node deleteNode(int data, Node head){
		/* if it is head node itself to be removed. */
		Node newHead = head;
		if(head.d == data){
			newHead = head.next;
			head = null;
			return deleteNode(data, newHead);
		}
		
		/* if is the node other than the head node.*/
		Node temp = newHead, prev = null;
		while(temp != null){
			if(temp.d == data){
				prev.next = temp.next;
			}
			prev = temp;
			temp = temp.next;
			
		}
		return newHead;
	}
	
	/**
	 * Given key/value, delete the first occurrence of the key/value.
	 * @param key
	 * @param head
	 * @return
	 */
	public Node deleteFirstNode(int key, Node head){
		/*if head itself needs to be deleted*/
		if(head !=null && head.d == key){
			Node newHead = head.next;
			head = null;
			return newHead;
		}
		
		/* if it is other than the head node*/
		Node temp = head, prev = null;
		while(temp!=null && temp.d !=key){
			prev = temp;
			temp = temp.next;
		}
		/* if temp has reached the end of the list*/
		if(temp == null) return head;
		
		prev.next = temp.next;
		temp = null;
		return head;
	}
	
	/**
	 * Given the head of singly linked list and the position, delete the node at that particular
	 * position
	 * @param pos
	 * @param head
	 * @return
	 */
	public Node deleteNodeAtPosition(int pos, Node head){
		
		/* if the position corresponds to the head of list*/
		if(pos == 0){
			Node newHead = head.next;
			head = null;
			return newHead;
		}
		
		int i = 0;
		Node temp = head, prev = null;
		while(temp != null && pos != i){
			prev = temp;
			temp = temp.next;
			i++;
		}
		/* if the search has reached the end of list*/
		if(temp == null){
			return head;
		}
		
		prev.next = temp.next;
		temp = null;
		return head;
	}
	
	/**
	 * Delete nodes at alternative position starting from second node.
	 * @param head
	 */
	private void deleteAlternate(Node head){
		while(head!=null && head.next != null){
			Node next = head.next;
			head.next = next.next;
			next = null;
			head = head.next;
		}
	}
	/**
	 * Delete nodes at alternative position starting from seconde node using recursion.
	 * @param head
	 */
	private void deleteAlternate1(Node head){
		if(head == null || head.next == null){
			return;
		}
		
		Node next = head.next;
		head.next = next.next;
		next = null;
		deleteAlternate1(head.next);
	}
	
	/**
	 * Delete nodes which have a greater value on right side
	 * */
	public Node deleteLesserNode(Node head){
		/*if there is only one element*/
		if(head == null || head.next == null){
			return	head;
		}
		
		
		if(head.d < head.next.d){
			Node next = head.next;
			head = null;
			return deleteLesserNode(next);
		}
		
		Node newHead = head;
		Node current = head.next;
		Node prev = head;
		Node next = null;
		while(current.next !=null){
			next = current.next;
			if(current.d < next.d){
				prev.next = current.next;
				current = next;
			}else{
				prev = current;
				current = next;
			}
		}
		return newHead;
	}
	
	/**
	 * Delete n node after 'm'th node.
	 * @param head
	 * @param m
	 * @param n
	 */
	public void deleteNAfterM(Node head, int m, int n){
		Node t = new Node(2);
		t.displayList(head);
		
		int count = 0;
		Node test = head;
		Node temp = null;
		
		while(head != null){
			count = 0;
			System.out.println();
			while(count < m && head!=null){
				count++;
				temp = head;
				head = head.next;
			}
			
			count = 0;
			while(count< n && head!=null){
				head = head.next;
				count++;
			}
			if(temp == null || head == null){
				break;
			}
			temp.next = head.next;
			
		}
		t.displayList(test);
	}
}
