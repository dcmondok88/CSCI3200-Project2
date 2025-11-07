//--------------------------------------------------------------
// Group Members: Daniel Mondok, Braeden Baldwin & Xavier Alvarenga
// Date: October 24, 2025
// Course: Data Structures and Algorithm Analysis (CSCI 3200)
// Project Description: Project 2 converts an infix expression to a postfix expression using a stack to handle operator precedence.
//--------------------------------------------------------------
package CSCI3200;

import java.util.Stack;

public class ConvertInfixToPostfix {
    
    public String convertToPostfix (String input){
		char current;
		String result = "";
		Stack<String> stack = new Stack<String>();
		
		
		for(int i = 0; i < input.length();i++) {
			current = input.charAt(i);
			if(checkPrecedence(current)==-1 && !isParenthesis(current) && current!=' ') { //skips over any whitespace
				result+=(current + " "); //adds operand to the result
			}
			else {
				if(current=='(') {
					stack.push(Character.toString(current)); //pushes '(' into the stack
				}
				else if (checkPrecedence(current)>0) {
					//pops any higher or equal precedence operators from the stack
					while(!stack.isEmpty() && !stack.peek().equals("(") && (checkPrecedence(stack.peek().charAt(0)) >= checkPrecedence(current))) {
						result+=(stack.pop() + " ");
					}
					stack.push(Character.toString(current)); //pushes the current operator
				}
				else if (current==')') {
					//pops until '(' is found
					while(!stack.isEmpty() && (!(stack.peek().charAt(0)=='('))) {
						result+=(stack.pop() + " ");
					}
					stack.pop(); //once '(' is found, '(' is removed
				}
			}
		}
		
		while(!stack.isEmpty()) {
			result += (stack.pop() + " "); //adds any remaining operators
		}
		
		return result;
	}
	
	public static int checkPrecedence(char operator) { //returns operator precedence or not (if it's not an operator, -1 is returned)
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2; 
            default:
                return -1; //not a valid operator
        }
	}
	
	public static boolean isParenthesis(char paren) {
		switch(paren) {
		case '(':
		case ')':
			return true; //is a parenthesis
		default:
			return false; //not a parenthesis
		}
	}
}
