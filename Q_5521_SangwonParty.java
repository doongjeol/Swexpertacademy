package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_5521_SangwonParty {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // �׽�Ʈ���̽�
		
		// �Է�
		for(int t=0 ; t<T ; t++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st1.nextToken());
			int M = Integer.parseInt(st1.nextToken()); // ģ�� ģ���� ���� ��
			int[][] friend = new int[M][2];
			for(int i=0 ; i<M ; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for(int j=0 ; j<2 ; j++) {
					friend[i][j] = Integer.parseInt(st2.nextToken());
				}
			}
		}
		
	}
}
