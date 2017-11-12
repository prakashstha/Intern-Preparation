package StackProblem;

/**
 * Design a stack that supports getMin() in O(1) time with O(1) space
 * @author Prakash
 *
 */
public class MinValueStack1{
	class StackNode{
		int data;
		StackNode next;
		public StackNode(int val){
			this.data = val;
		}
	}
	
	StackNode s1;
	int min;
	
	public void push(int val){
		if(s1 == null){
			s1 = new StackNode(val);
			min = val;
		}else{
			if(val<min){
				int stckVal = 2 * val - min;
				min = val;
				StackNode newNode = new StackNode(stckVal);
				newNode.next = s1;
				s1 = newNode;
			}else{
				StackNode newNode = new StackNode(val);
				newNode.next = s1;
				s1 = newNode;
			}
		}
	}
	
	public int pop(){
		int res = s1.data;
		s1 = s1.next;
		
		if (res >= min){
			return res;
		}else{
			min =  2 * min - res;
			return (min+res)/2;
		}
	}
	
	public int getMin(){
		return min;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (s1 == null)
			return true;
		else
			return false;
	}
	
}
