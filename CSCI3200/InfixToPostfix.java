//--------------------------------------------------------------
// Group Members: Daniel Mondok, Braeden Baldwin & Xavier Alvarenga
// Date: October 24, 2025
// Course: Data Structures and Algorithm Analysis (CSCI 3200)
// Project Description: Project 2 converts an infix expression to a postfix expression using a stack to handle operator precedence.
//--------------------------------------------------------------
package CSCI3200;

import java.util.*;

public class InfixToPostfix {
	public static void main(String[] args) {

		Scanner userinput = new Scanner(System.in);
		//while loop that prompts user until exit
		while (true) {
			System.out.print("Enter an infix expression (or enter 0 to end): ");
			String userinfix = userinput.nextLine();

			//if a user enters 0, exit the loop
			if (userinfix.equals("0")) {
				System.out.println("\nGoodbye!");
				break;
			}
			//creates object of ConvertInfixtoPostfix
			ConvertInfixToPostfix user_convert = new ConvertInfixToPostfix();
			String postfix = user_convert.convertToPostfix(userinfix);

			System.out.println("The postfix expression of " + userinfix + " = " + postfix);
		}
		userinput.close();
	}

}