package Queue;

/**
 * <p>
 * 	 Linked list implementation for queue. The following two main operations are implemented 
 * 	 efficiently. In a Queue data structure, we maintain two pointers, front and rear. The 
 * 	 front points the first item of queue and rear points to last item.
 * </p>
 * <ul>
 * 	 <li> enQueue() This operation adds a new node after rear and moves rear to the next node. </li>
 *	 <li> deQueue() This operation removes the front node and moves front to the next node. </li>
 * </ul>
 * @author Prakash
 * @param <T>
 */
public class MyQueue<T>{
	private int size = 0;
	class QueueNode<T>{
		T data;
		QueueNode<T> next;
		public QueueNode(T data){
			this.data = data;
		}
	}
	
	QueueNode<T> first; 
	QueueNode<T> last;
	public void enqueue(T data){
		QueueNode<T> newNode = new QueueNode<T>(data);
		/* queue is empty*/
		if(last == null){
			last = newNode;
			first = newNode;
		}else{
			last.next = newNode;
			last = newNode;
		}
		size++;
	}
	
	public T dequeue(){
		/* queue is empty */
		if(first == null) throw new IllegalStateException("Queue is empty!!");
		
		T itm = first.data;
		first = first.next;
		size--;
		return itm;
	}
	
	public T peek(){
		if(first == null) throw new IllegalStateException("Queue is empty!!");
		
		return first.data;
	}
	
	public boolean isEmpty(){
		if(first == null || last == null)
			return true;
		return false;
	}
	
	public int size(){
		return size;
	}
	
	
	
}
