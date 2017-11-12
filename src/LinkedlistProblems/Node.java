package LinkedlistProblems;


public class Node{
	Node next = null;
	int d;
	boolean isVisited = false;
	public Node(int data){
		this.d = data;
	}
	
	public void appendToTail(int d){
		Node end = new Node(d);
		Node n = this;
		while(n.next != null){
			n = n.next;
		}
		n.next = end;
	}
	
	public Node getMiddle(Node ptr){
		Node fastPtr = ptr.next;
		Node slowPtr = ptr;
		while(fastPtr.next != null){
			slowPtr = slowPtr.next;
			if(fastPtr.next.next == null)
				fastPtr = fastPtr.next;
			else
				fastPtr = fastPtr.next.next;
		}
		return slowPtr;
	}
	
	public void printReverse(Node head){
		if(head == null)
			return;
		
		printReverse(head.next);
		System.out.println(head.d);
	}
	
	public void displayList(Node head){
		while(head!=null){
			if(head.next != null)
				System.out.print(head.d + "-->");
			else
				System.out.print(head.d);
			head = head.next;
		}
		System.out.println();
	}
}