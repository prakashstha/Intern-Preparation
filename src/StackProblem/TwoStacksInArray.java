package StackProblem;

/**
 * Implement two stacks in an array. 
 * 1. Divide the space in two halves
 * 2. A space efficient implementation, which is implemented below.
 * @author Prakash
 */
public class TwoStacksInArray{
	int n; // size of the array;
	int a[];
	int top1;
	int top2;
	
	public TwoStacksInArray(int n){
		this.n = n;
		a = new int[n];
		top1 = -1;
		top2 = n;
	}
	
	public void push1(int val){
		top1++;
		if(top1>=top2){
			System.err.println("Stack1 is full.");
			return;
		}
		
		a[top1] = val;
		
	}
	
	public void push2(int val){
		top2--;
		if(top1>=top2){
			System.err.println("Stack2 is full.");
			return;
		}
		a[top2] = val;
	}
	
	public int pop1(){
		if(top1 < 0){
			System.err.println("Stack1 is empty.");
			return -1;
		}
		
		return a[top1--];
	}
	public int pop2(){
		if(top2 == n){
			System.err.println("Stack1 is empty.");
			return -1;
		}
		
		return a[top2++];
	}
	
	public boolean isStack1Empty(){
		if(top1<0)
			return true;
		else
			return false;
	}
	
	public boolean isStack2Empty(){
		if(top2 >= n)
			return true;
		else
			return false;
	}
	
	
}
