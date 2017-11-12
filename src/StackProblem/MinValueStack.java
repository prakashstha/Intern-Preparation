package StackProblem;


/**
 * Design a stack that supports getMin() in O(1) time with extract stack requirement
 * @author Prakash
 */
public class MinValueStack{
	class StackNode{
		int data;
		StackNode next;
		public StackNode(int val){
			this.data = val;
		}
	}
	
	StackNode s1;
	StackNode s2;
	
	public void push(int val){
		if(s1 == null){
			s1 = new StackNode(val);
			s2 = new StackNode(val);
		}else{
			StackNode newNode = new StackNode(val);
			newNode.next = s1;
			s1 = newNode;
			
			if(s2.data < val){
				StackNode newNode1 = new StackNode(s2.data);
				newNode1.next = s2;
				s2 = newNode1;
			}else{
				StackNode newNode1 = new StackNode(val);
				newNode1.next = s2;
				s2 = newNode1;
			}
		}
	}
	
	public int pop(){
		StackNode res = s1;
		s1 = s1.next;
		s2 = s2.next;
		return res.data;
	}
	
	public int getMin(){
		if(s2 == null){
			System.err.println("Auxilary stack empty!");
			return -1;
		}
	  return s2.data;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (s1 == null)
			return true;
		else
			return false;
	}
	
}


