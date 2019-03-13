package swexpertacademy;

import java.util.Scanner;
import java.util.Stack;
public class Q_1218_BracketsAnswer2 {
	static char bracket[];
	static char s[];
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Stack stack;
		for(int i=0; i<10; i++){
			int N=Integer.parseInt(sc.nextLine()); 
			String tmp=sc.nextLine(); 
			bracket= new char[N]; 
			stack = new Stack();
			for(int a=0; a<N; a++){ 
				bracket[a]=tmp.charAt(a);
			} 
			// Å½»ö 
			for(int a=0; a<N; a++){ 
				if(bracket[a]=='(' || bracket[a]=='[' || bracket[a]=='{' || bracket[a]=='<') {
					stack.push(bracket[a]);
				} else{
					if(stack.empty()) {
						break;
					} else {
						if( (char)stack.peek() == '(' && bracket[a] == ')' ||
							(char)stack.peek() == '[' && bracket[a] == ']' ||
							(char)stack.peek() == '{' && bracket[a] == '}' ||
							(char)stack.peek() == '<' && bracket[a] == '>'){
							stack.pop();
						} else {
							break;
						}
					}
				}
			}
			// ÆÇº° 
			if(stack.empty()) 
				System.out.println("#"+(i+1)+" 1");
			else {
				System.out.println("#"+(i+1)+" 0");
			}
		} 
	}
}
