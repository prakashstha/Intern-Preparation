package StackProblem;


/**
 * Stack implementation using LinkedList
 * =====================================
 * @author Prakash
 *
 * @param <T>
 */
 
 public class MyStack<T>{
	private class StackNode<T>{
		private T data; 
		private StackNode<T> next;
		public StackNode(T data){
			this.data = data;
		}
	}
	
	private StackNode<T> top;
	private int size = 0;
	
	public void push(T data){
		if(top == null){
			top = new StackNode<T>(data);
		}else{
			StackNode<T> newNode= new StackNode<T>(data);
			newNode.next = top;
			top = newNode;
		}
		size++;
	}
	
	public T pop(){
		if(top == null) throw new IllegalArgumentException("Empty Stack!");
		
		T item = top.data;
		top = top.next;
		size--;
		return item;
	}
	
	public T peek(){
		if(top == null) throw new IllegalArgumentException("Empty Stack!");
		return top.data;
	}
	
	public boolean isEmpty(){
		if(top == null)
			return true;
		else
			return false;
	}
	
	public int size(){
		return size;
	}
	
}
