package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_2817_SumOfThePartialSequence {
	static int N ;
	static int K ;
	static int[] array;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i=0; i<T ; i++) {
			result = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			array = new int[N];
			
			StringTokenizer number = new StringTokenizer(br.readLine());
			for(int j=0 ; j<N ; j++) {
				array[j] = Integer.parseInt(number.nextToken());
			}
			
			solution(0,0);
			System.out.println("#"+(i+1)+" "+result);
		}
	}
	
	public static void solution(int position, int nowValue) {
		for(int i = position; i<N ; i++) {
			int tempValue = nowValue + array[i];
			// 더한 값이 K 보다 작다면 다음 값 더하기
			if(tempValue < K) {
				solution(i+1, tempValue);
			} else if(tempValue == K) {
				result ++;
			}
		}
	}
}
