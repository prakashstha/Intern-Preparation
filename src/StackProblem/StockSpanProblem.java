package StackProblem;

/**
 * The stock span problem is a financial problem where we have a series of n daily price quotes 
 * for a stock and we need to calculate span of stock’s price for all n days. 
 * The span Si of the stock’s price on a given day i is defined as the maximum number of 
 * consecutive days just before the given day, for which the price of the stock on the current day is 
 * less than or equal to its price on the given day.
 * @author Prakash
 *
 */
public class StockSpanProblem {
	/**
	 * 
	 * @param price series of stock prices
	 * @param n number of days/stock prices
	 * @param S span values
	 */
	public void calculateSpan(int price[], int n, int S[]){
		S[0] = 1;
		for (int i = 1; i<n; i++){
			int temp_S = 1;
			for (int j = i - 1; j>=0; j--){
				if(price[j]<=price[i]){
					temp_S++;
				}else{
					break;
				}
			}
			S[i] = temp_S;
		}
	}
	
	public void calculateSpan1(int price[], int n, int S[]){
		S[0] = 1;
		
		MyStack<Integer> hStck = new MyStack<>();
		hStck.push(0);
		
		for (int i = 1; i<n; i++){
			while(!hStck.isEmpty() && price[hStck.peek()]<=price[i]){
				hStck.pop();
			}
			S[i] = hStck.isEmpty()?(i + 1):(i - hStck.peek());
			hStck.push(i);
		}
	}
	
	
}
