package Queue;

/**
 * <p>
 * 		<strong>Deque or Double Ended Queue</strong> is a generalized version of 
 * 		Queue data structure that allows insert and delete at both ends.  
 * 		The program below implements deque using circular array.
 * </p>
 * <i> Operations on Deque:</i> Mainly the following four basic operations are performed on queue:
 * <ul>
 * 		<li> <i>insetFront():</i> Adds an item at the front of Deque. </li>
 * 		<li> <i>insertRear():</i> Adds an item at the rear of Deque. </li>
 * 		<li> <i>deleteFront():</i> Deletes an item from front of Deque.</li>
 * 		<li> <i>deleteRear():</i> Deletes an item from rear of Deque. </li>
 * 		
 * </ul>
 * In addition to above operations, following operations are also supported.
 * <ul>
 * 		<li> <i>getFront():</i> Gets the front item from queue. </li>
 * 		<li> <i>getRear():</i> Gets the last item from queue. </li>
 * 		<li> <i>isEmpty():</i> Checks whether Deque is empty or not. </li>
 * 		<li> <i>isFull():</i> Checks whether Deque is full or not. </li>
 * </ul>
 * @author Prakash
 *
 */
public class Deque {
	static final int MAX = 100;
	int arr[];
	int front;
	int rear;
	int size;
	
	public Deque(int size){
		this.arr = new int[MAX];
		this.size = size;
		this.front = -1;
		this.rear = -1;
		
	}
	
	/**
	 * Check if the Deque is full or not.
	 * @return
	 */
	public boolean isFull(){
		
		if((rear + 1)%5 == front)
			return true;
		else
			return false;
	}
	
	/**
	 * Check if the Deque is empty or not.
	 * @return
	 */
	public boolean isEmpty(){
		if(front == -1 && rear == -1)
			return true;
		else
			return false;
	}
	
	/**
	 * Insert the data to the front of Deque.
	 * @param d
	 */
	public void insertFront(int d){
		if(isFull()){
			System.err.println("The deque is full");
			return;
		}
		
		/* Initially the deque is empty.*/
		if(front == -1){
			front = 0;
			rear = 0;
		}else if (front == 0){
			front = size - 1;
		}else{
			front--;
		}
		arr[front] = d;
	}
	
	
	/**
	 * Insert the data to the rear of Deque.
	 * @param d
	 */
	public void insertRear(int d){
		if(isFull()){
			System.err.println("The deque is full");
			return;
		}
		/*Initially the deque is empty*/
		if(rear == -1){
			front = 0;
			rear = 0;
		}/* if rear points to end of the array */
		else if(rear == size - 1){
			rear = 0;
		}else{
			rear = rear + 1;
		}
		arr[rear] = d;
	}
	
	/**
	 * Get and remove the data from the front of Deque
	 * @return
	 */
	public int getFront(){
		if(isEmpty()){
			System.err.println("The deque is empty!!");
			return -1;
		}
		int d = arr[front];
		/* if the Deque has only one element.*/
		if(front == rear){
			front = -1;
			rear = -1;
		/* if front is at the end of Deque*/
		}else if(front == size - 1){
			front = 0;
		}else{
			front = front + 1;
		}
		return d;
	}
	
	/**
	 * Get and remove the data from the rear of Deque.
	 * @return
	 */
	public int getRear(){
		if(isEmpty()){
			System.err.println("The deque is empty!!");
			return -1;
		}
		int d = arr[rear];
		
		if(front == rear){ // if deque contains only one element
			front = -1;
			rear = -1;
		}else if(rear == 0){ // if rear points to last index of deque
			rear = size - 1;
		}else{
			rear = rear - 1;
		}
		
		return d;
	}
	
	public void displayDeque(){
		int i = front;
		while(i != rear){
			System.out.print( arr[i] + ",");
			i = (i+1)%size;
			
		}
		System.out.print(arr[i] + "\n");
	}
	
}
