//--------------------------------------------------------------
//Group Members: Daniel Mondok, Braeden Baldwin & Xavier Alvarenga
//Date: October 24, 2025
//Course: Data Structures and Algorithm Analysis (CSCI 3200)
//Project Description: Project 2 is meant to help convert an infix expression to a postfix expression utilizing a stack as a means to handle operator precedence.
//--------------------------------------------------------------
package CSCI3200;

import java.util.Stack;

public class ConvertInfixToPostfix {
    
    public static String convertToPostfix (String input){
		char current;
		String result = "";
		Stack<String> stack = new Stack<String>();
		
		
		for(int i = 0; i < input.length();i++) {
			current = input.charAt(i);
			if(checkPrecedence(current)==-1 && !isParenthesis(current) && current!=' ') { //skips over whitespaces
				result+=(current + " ");
			}
			else {
				if(current=='(') {
					stack.push(Character.toString(current));
				}
				else if (checkPrecedence(current)>0) {
					while(!stack.isEmpty() && !stack.peek().equals("(") && (checkPrecedence(stack.peek().charAt(0)) >= checkPrecedence(current))) {
						result+=(stack.pop() + " ");
					}
					stack.push(Character.toString(current));
				}
				else if (current==')') {
					while(!stack.isEmpty() && (!(stack.peek().charAt(0)=='('))) {
						result+=(stack.pop() + " ");
					}
					stack.pop();
				}
			}
		}
		
		while(!stack.isEmpty()) {
			result += (stack.pop() + " ");
		}
		
		return result;
	}
	
	public static int checkPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2; 
            default:
                return -1; //not a valid operator, can be used to check if the character is an operator
        }
	}
	
	public static boolean isParenthesis(char paren) {
		switch(paren) {
		case '(':
		case ')':
			return true;
		default:
			return false;
		}
	}
}
