package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer; 

public class Q_1953_ArrestAbsconder {
	
	static int N, M, R, C, L, result;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // �׽�Ʈ ���̽� ����
		
		// �Է�
		for(int t=1 ; t<=T ; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // ���� �ͳ� ������ ���� ũ��
			M = Integer.parseInt(st.nextToken()); // ���� �ͳ� ������ ���� ũ��
			R = Integer.parseInt(st.nextToken()); // ��Ȧ �Ѳ��� ��ġ�� ����� x
			C = Integer.parseInt(st.nextToken()); // ��Ȧ �Ѳ��� ��ġ�� ����� y
			L = Integer.parseInt(st.nextToken()); // �ð�
			map = new int[N][M];
			
			for(int i=0; i<N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) 
					map[i][j] = Integer.parseInt(st.nextToken());
				
			}
			
			result = 0;
			visited = new boolean[N][M];
			detect();
			System.out.print("#" + t +" " + result + "\n");
		}
		
	}
	
	public static void detect() {
		Queue<Pair> q = new LinkedList<>();
		// ó����ġ�� ��忡 In
		q.add(new Pair(R,C,1));
		visited[R][C] = true;
		
		while(!q.isEmpty()) {
			// ���� ���� ���
			Pair node = q.poll();
			// Ž���� Ƚ���� ������ �ð����� ��� ����������
			if(node.count>L) break;
			result++;
			switch(map[node.x][node.y]) {
			case 1 : // + ���
				// �����¿� �̵��ϸ鼭 �˻�
				for(int i=0;i<4;i++) {
					int nodeX = node.x+dir[i][0];
	                int nodeY = node.y+dir[i][1];
	                // map�� ũ�⺸�� �۰ų� Ŭ ��� �Ѿ��
	                if(nodeX<0 || nodeY<0 || nodeX>=N || nodeY>=M) continue;
	                // �湮�Ͽ����ų� map�� �ͳ��� ���� ��� �Ѿ��
	                if(visited[nodeX][nodeY] || map[nodeX][nodeY]==0) continue;
	                // ���� ������ q�� ���� �ְ� �湮�Ͽ��ٰ� ������ֱ�
	                if(check(nodeX,nodeY,i)) {
	                   q.add(new Pair(nodeX,nodeY,node.count+1));
	                   visited[nodeX][nodeY] = true;
	                }
	             }
				break;
			case 2 : // | ���
				// ���� �̵��ϸ鼭 �˻�
				for(int i=0;i<4;i+=2) {
					int nodeX = node.x+dir[i][0];
	                int nodeY = node.y+dir[i][1];
	                // map�� ũ�⺸�� �۰ų� Ŭ ��� �Ѿ��
	                if(nodeX<0 || nodeY<0 || nodeX>=N || nodeY>=M) continue;
	                // �湮�Ͽ����ų� map�� �ͳ��� ���� ��� �Ѿ��
	                if(visited[nodeX][nodeY] || map[nodeX][nodeY]==0) continue;
	                // ���� ������ q�� ���� �ְ� �湮�Ͽ��ٰ� ������ֱ�
	                if(check(nodeX,nodeY,i)) {
	                   q.add(new Pair(nodeX,nodeY,node.count+1));
	                   visited[nodeX][nodeY] = true;
	                }
	             }
				break;
			case 3 : // �� ���
				// �¿� �̵��ϸ鼭 �˻�
				for(int i=1;i<4;i+=2) {
					int nodeX = node.x+dir[i][0];
	                int nodeY = node.y+dir[i][1];
	                // map�� ũ�⺸�� �۰ų� Ŭ ��� �Ѿ��
	                if(nodeX<0 || nodeY<0 || nodeX>=N || nodeY>=M) continue;
	                // �湮�Ͽ����ų� map�� �ͳ��� ���� ��� �Ѿ��
	                if(visited[nodeX][nodeY] || map[nodeX][nodeY]==0) continue;
	                // ���� ������ q�� ���� �ְ� �湮�Ͽ��ٰ� ������ֱ�
	                if(check(nodeX,nodeY,i)) {
	                   q.add(new Pair(nodeX,nodeY,node.count+1));
	                   visited[nodeX][nodeY] = true;
	                }
	             }
				break;
			case 4 : // �� ���
				// ��� �̵��ϸ鼭 �˻�
				for(int i=1;i<3;i++) {
					int nodeX = node.x+dir[i][0];
	                int nodeY = node.y+dir[i][1];
	                // map�� ũ�⺸�� �۰ų� Ŭ ��� �Ѿ��
	                if(nodeX<0 || nodeY<0 || nodeX>=N || nodeY>=M) continue;
	                // �湮�Ͽ����ų� map�� �ͳ��� ���� ��� �Ѿ��
	                if(visited[nodeX][nodeY] || map[nodeX][nodeY]==0) continue;
	                // ���� ������ q�� ���� �ְ� �湮�Ͽ��ٰ� ������ֱ�
	                if(check(nodeX,nodeY,i)) {
	                   q.add(new Pair(nodeX,nodeY,node.count+1));
	                   visited[nodeX][nodeY] = true;
	                }
	             }
				break;
			case 5 : // �� ���
				// ���� �̵��ϸ鼭 �˻�
				for(int i=0;i<2;i++) {
					int nodeX = node.x+dir[i][0];
	                int nodeY = node.y+dir[i][1];
	                // map�� ũ�⺸�� �۰ų� Ŭ ��� �Ѿ��
	                if(nodeX<0 || nodeY<0 || nodeX>=N || nodeY>=M) continue;
	                // �湮�Ͽ����ų� map�� �ͳ��� ���� ��� �Ѿ��
	                if(visited[nodeX][nodeY] || map[nodeX][nodeY]==0) continue;
	                // ���� ������ q�� ���� �ְ� �湮�Ͽ��ٰ� ������ֱ�
	                if(check(nodeX,nodeY,i)) {
	                   q.add(new Pair(nodeX,nodeY,node.count+1));
	                   visited[nodeX][nodeY] = true;
	                }
	             }
				break;
			case 6 : // �� ���
				// ���� �̵��ϸ鼭 �˻�
				for(int i=0;i<4;i+=3) {
					int nodeX = node.x+dir[i][0];
	                int nodeY = node.y+dir[i][1];
	                // map�� ũ�⺸�� �۰ų� Ŭ ��� �Ѿ��
	                if(nodeX<0 || nodeY<0 || nodeX>=N || nodeY>=M) continue;
	                // �湮�Ͽ����ų� map�� �ͳ��� ���� ��� �Ѿ��
	                if(visited[nodeX][nodeY] || map[nodeX][nodeY]==0) continue;
	                // ���� ������ q�� ���� �ְ� �湮�Ͽ��ٰ� ������ֱ�
	                if(check(nodeX,nodeY,i)) {
	                   q.add(new Pair(nodeX,nodeY,node.count+1));
	                   visited[nodeX][nodeY] = true;
	                }
	             }
				break;
			case 7 : // ��
				// ���� �̵��ϸ鼭 �˻�
				for(int i=2;i<4;i++) {
					int nodeX = node.x+dir[i][0];
	                int nodeY = node.y+dir[i][1];
	                // map�� ũ�⺸�� �۰ų� Ŭ ��� �Ѿ��
	                if(nodeX<0 || nodeY<0 || nodeX>=N || nodeY>=M) continue;
	                // �湮�Ͽ����ų� map�� �ͳ��� ���� ��� �Ѿ��
	                if(visited[nodeX][nodeY] || map[nodeX][nodeY]==0) continue;
	                // ���� ������ q�� ���� �ְ� �湮�Ͽ��ٰ� ������ֱ�
	                if(check(nodeX,nodeY,i)) {
	                   q.add(new Pair(nodeX,nodeY,node.count+1));
	                   visited[nodeX][nodeY] = true;
	                }
	             }
				break;
			}
		}
	}
	
	// �ͳ� Ÿ���� ���� ����Ǿ��ִ��� ����
    private static boolean check(int x, int y, int i) {
        int type = map[x][y];
        switch(i) {
        case 0: // �Ʒ������� ���� �־�� �� (1, 2, 4, 7)
           if(type==3||type==5||type==6) return false;
           break;
        case 1: // ���������� ���� �־�� �� (1, 3, 6, 7)
           if(type==2||type==4||type==5) return false;
           break;
        case 2: // �������� ���� �־�� �� (1, 2, 5, 6)
           if(type==3||type==4||type==7) return false;
           break;
        case 3: // �������� ���� �־�� �� (1, 3, 4, 5)
           if(type==2||type==6||type==7) return false;
           break;
        }
        
        return true;
     }
	
	// Ž���� ���
	static class Pair {
		private int x, y, count;
		public Pair(int x, int y, int count) {
			this.x = x; 
			this.y = y; 
			this.count = count; 
		}
		
	}
}
