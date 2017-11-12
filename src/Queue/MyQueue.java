package Queue;


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
	public void add(T data){
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
	
	public T remove(){
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
