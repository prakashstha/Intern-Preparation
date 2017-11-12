package StackProblem;
/**
 * In a party of N people, only one person is known to everyone. 
 * Such a person may be present in the party, if yes, (s)he doesn’t 
 * know anyone in the party. We can only ask questions like “does A know B? “. 
 * Find the stranger (celebrity) in minimum number of questions.
 * @author Prakash
 */
public class CelebrityProblem {
	/**
	 * Method 1: Brute force method. O(n^2)
	 * @param p
	 * @return
	 */
	public int findCelebrity(int p[][]){
		boolean isCelebrity;
		for (int i = 0; i<p.length; i++){
			isCelebrity = true;
			for (int j = 0; j<p[0].length; j++){
				if(knows(p, i, j)){
					isCelebrity = false;
					break;
				}
			}
			if(isCelebrity){
				for (int j = 0; j<p.length; j++){
					if(!knows(p, j, i)){
						isCelebrity = false;
						break;
					}
				}
			}
			if (isCelebrity)
				return i;
		}
		return -1;
	}
	
	
	public boolean knows(int p[][], int i, int j){
		if(p[i][j] == 1)
			return true;
		else
			return false;
	}
	/**
	 * Complexity: O(n)
	 * @param p
	 * @return
	 */
	public int findCelebrity1(int p[][]){
		MyStack<Integer> stck = new MyStack<>();
		for (int i = 0; i<p.length; i++){
			stck.push(i);
		}
		
		while(stck.size()>1){
			int i = stck.pop();
			int j = stck.pop();
			if(knows(p, i, j)){
				stck.push(j);
			}else{
				stck.push(i);
			}
		}
		
		//check if last element is celebrity or not.
		int k = stck.pop();
		for (int i = 0; i<p.length; i++){
			if(i == k)
				continue;
			
			if(knows(p, k, i) || !knows(p, i, k))
				return -1;
		}
		return k;
	}
}
