package StackProblem;

/**
 * Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element 
 * for an element x is the first greater element on the right side of x in array. Elements for which 
 * no greater element exist, consider next greater element as -1.
 * Examples:
 * <ul>
 * 	<li> a) For any array, rightmost element always has next greater element as -1.</li>
 * 	<li> b) For an array which is sorted in decreasing order, all elements have next greater element as -1.</li>
 * 	<li> c) For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.</li>
 * </ul>
 * @author Prakash
 *
 */
public class NextGreaterElement {
	public void findNextGreaterElement(int a[], int res[]){
		for(int i = 0; i<a.length; i++){
			res[i] = -1;
			for(int j = i+1; j<a.length; j++){
				if(a[j]>a[i]){
					res[i] = a[j];
					break;
				}
			}
		}
	}
	
	public void findNextGreaterElement1(int a[], int res[]){
		MyStack<Integer> hStack = new MyStack<>();
		hStack.push(0);
		for(int i = 1; i<a.length; i++){
			int next = a[i];
			while(!hStack.isEmpty() && a[hStack.peek()]<next){
				res[hStack.pop()] = next;
			}
			hStack.push(i);			
		}
		while(!hStack.isEmpty()){
			res[hStack.pop()] = -1;
		}
	}
}
