package Queue;

public class Driver_QueueProblems {
	public static void main(String[] args){
//		Deque d = new Deque(5);
//		d.insertFront(5);
//		d.insertFront(4);
//		d.insertFront(3);
//		d.displayDeque();
//		System.out.println("rear:" + d.getRear());
//		d.displayDeque();
//		d.insertRear(2);
//		d.insertRear(1);
//		d.insertFront(0);
//		d.displayDeque();
//		System.out.println("Front: " + d.getFront());
//		d.displayDeque();
		
		CircularQueue cq = new CircularQueue(5);
		cq.insert(5);
		cq.insert(6);
		cq.insert(7);
		cq.insert(8);
		cq.insert(8);
		cq.insert(10);
		cq.displayQueue();
		
		
	}
}
