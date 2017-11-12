package StackProblem;

public class PostfixEvaluation {
	public int evaluatePostfix(String exp){
		MyStack<Integer> stck = new MyStack<>();
		for(int i = 0; i<exp.length(); i++){
			char c = exp.charAt(i);
			if(Character.isDigit(c)){
				stck.push(c - '0'); //store ASCII value.
			}else{
				int c1 = stck.pop();
				int c2 = stck.pop();
				switch(c){
				case '+':
					stck.push(c1+c2);
					break;
				case '-':
					stck.push(c2 - c1);
					break;
				case '/':
					stck.push(c2/c1);
					break;
				case '*':
					stck.push(c2*c1);
					break;
				default:
					System.err.println(c + " operation is not supported.");
				}				
			}
		}
		return stck.pop();
	}
}
