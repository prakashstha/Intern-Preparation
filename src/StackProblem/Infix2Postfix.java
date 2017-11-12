package StackProblem;

/**
 * Infix to Postfix Conversion using Stack 
 * @author Prakash
 */
public class Infix2Postfix {
	/**
	 * Infix to Postfix Conversion using Stack
	 * @param exp infix expression
	 * @return postfix expression
	 */
	public String infixToPostfix(String exp){
		MyStack<Character> stck = new MyStack<>();
		StringBuilder pstFixStr = new StringBuilder();
		for(int i = 0; i<exp.length(); i++){
			char ch = exp.charAt(i);
			
			if( ch == '('){
				stck.push(ch);
				continue;
			}else if(ch == ')'){
				char close_char = stck.pop();
				while(close_char != '('){
					pstFixStr.append(close_char);
					close_char = stck.pop();
				}
				continue;
			}
			
			
			if (Character.isLetterOrDigit(ch)){
				pstFixStr.append(ch);
			}else{
				if(stck.isEmpty() ||  precedence(ch) >= precedence(stck.peek())){
					stck.push(ch);
					continue;
				}else{
					while(!stck.isEmpty() && precedence(ch) <= precedence(stck.peek())){
						pstFixStr.append(stck.pop());
					}					
					stck.push(ch);

				}
			}
		}
		
		while(!stck.isEmpty()){
			pstFixStr.append(stck.pop());
		}
		
		return pstFixStr.toString();
	}
	
	private int precedence(char ch){
		switch (ch){
			case '+':
			case '-':
				return 1;
			case '*':
			case '/':
				return 2;
			case '^':
				return 3;
		}
		return -1;
	}
}
