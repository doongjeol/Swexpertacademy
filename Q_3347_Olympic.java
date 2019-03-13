package swexpertacademy;

import java.util.Scanner;

public class Q_3347_Olympic {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] A = new int[N];
		int[] B = new int[M];
		
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
				for(int i=0; i<M; i++) {
			B[i] = sc.nextInt();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(A[i]<=B[j]) {
					System.out.println(i);
				}
			}
		}
	}
}