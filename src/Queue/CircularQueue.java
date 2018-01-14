package Queue;

public class CircularQueue {
	int arr[];
	private int size;
	private int front, rear;
	private int MAX = 100;
	public CircularQueue(int size){
		this.size = size;
		this.arr = new int[size];
		this.front = 0;
		this.rear = 0;
	}
	
	public boolean isEmpty(){
		if(front == 0 && rear == 0)
			return true;
		else 
			return false;
	}
	public boolean isFull(){
		if(rear == size - 1)
			return true;
		else
			return false;
	}
	
	public void insert(int d){
		if(isFull()){
			System.err.println("Circular Queue is full");
			return;
		}
		
		/*Initially empty*/
		if(front == 0 && rear == 0){
			front = 0;
			rear = 0;
		}else{
		}
		arr[rear] = d;
	}
	
	public int remove(){
		if(isEmpty()){
			System.err.println("The Circular Queue is Empty!");
			return -1;
		}
		
		/* if contain only one element*/
		if ((front + 1)%size == rear){
			int val = arr[front];
			front = 0;
			rear = -1;
			return val;
		}
		
		if(rear == 0){
			rear = size - 1;
		}else{
			rear = rear - 1;
		}
		return arr[rear];
	}

	public void displayQueue() {
		// TODO Auto-generated method stub
		int i = front;
		while(i!=rear){
			
		}
		
	}
}
