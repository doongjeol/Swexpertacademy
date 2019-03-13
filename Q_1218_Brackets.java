package swexpertacademy;

import java.util.Scanner;
import java.util.Stack;

public class Q_1218_Brackets {
	static int num = 0;
	static char[] brackets ;
	static Stack stack;
	static int isValid = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String bracketsString = "";
		brackets = new char[num];
		stack = new Stack();
		
		for(int i=0; i<10 ; i++) {
			num = sc.nextInt();
			sc.nextLine();
			bracketsString = sc.nextLine();
			for(int j=0; j<num ; j++) {
				brackets[j] = bracketsString.charAt(j);
			}
			inspect();
			System.out.println("#"+i+" "+isValid);
		}
		
	}
	
	public static void inspect() {
		for(int i=0; i<num ; i++) {
			if(brackets[i]=='(' || brackets[i]=='{' || brackets[i]=='[' || brackets[i]=='<' ) {
				stack.push(brackets[i]);
			}
			
			if(brackets[i] == ')') {
				if(stack.peek().equals('(') ) {
					stack.pop();
				}
			} else if(brackets[i] == '}') {
				if(stack.peek().equals('{') ) {
					stack.pop();
				}
			} else if(brackets[i] == ']') {
				if(stack.peek().equals('[') ) {
					stack.pop();
				}
			} else if(brackets[i] == '>') {
				if(stack.peek().equals('<') ) {
					stack.pop();
				}
			}
		}
		if(stack.empty()) {
			isValid = 1;
		} else {
			isValid = 0;
		}
	}
}
