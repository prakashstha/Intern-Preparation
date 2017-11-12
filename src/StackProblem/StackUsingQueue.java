package StackProblem;

import Queue.MyQueue;

public class StackUsingQueue{
	MyQueue<Integer> queue = new MyQueue<>();
	
	public void push(int val){
		
		int s = queue.size();
		queue.add(val);
		for (int i = 0; i<s; i++){
			int d = queue.remove();
			queue.add(d);
		}
		
		
	}
	
	public int pop(){
		if(queue.isEmpty()){
			throw new IllegalArgumentException("Stack is empty!");
		}
		return queue.remove();
	}
	
	public boolean isEmpty(){
		return queue.isEmpty();
	}
	
}
