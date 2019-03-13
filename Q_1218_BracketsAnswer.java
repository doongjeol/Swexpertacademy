package swexpertacademy;

import java.util.Scanner;
public class Q_1218_BracketsAnswer {
	static char stack[];
	static char s[];
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in); 
		for(int i=0; i<10; i++){
			int N=Integer.parseInt(sc.nextLine()); 
			String tmp=sc.nextLine(); 
			stack= new char[N]; 
			s= new char[N]; 
			for(int a=0; a<N; a++){ 
				stack[a]=tmp.charAt(a);
			} 
			// Å½»ö 
			int idx=0;
			int cnt=0;
			for(int a=0; a<N; a++){ 
				if(idx<0) break; 
				if(a==0) s[idx]=stack[0]; 
				else{	 
					if((s[idx]=='(' && stack[a]==')') || (s[idx]=='<' && stack[a]=='>') || (s[idx]=='{' && stack[a]=='}') || (s[idx]=='[' && stack[a]==']')) {
						s[idx]=0; idx--; 
						continue; 
					} else{
						idx++;
						s[idx]=stack[a];
						cnt++; 
					}
				}
			}
			// ÆÇº° 
			if(idx==-1) 
				System.out.println("#"+(i+1)+" 1");
			else
				System.out.println("#"+(i+1)+" 0"); 
		} 
	}
}
