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
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 갯수
		
		// 입력
		for(int t=1 ; t<=T ; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 지하 터널 지도의 세로 크기
			M = Integer.parseInt(st.nextToken()); // 지하 터널 지도의 가로 크기
			R = Integer.parseInt(st.nextToken()); // 맨홀 뚜껑이 위치한 장소의 x
			C = Integer.parseInt(st.nextToken()); // 맨홀 뚜껑이 위치한 장소의 y
			L = Integer.parseInt(st.nextToken()); // 시간
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
		// 처음위치를 노드에 In
		q.add(new Pair(R,C,1));
		visited[R][C] = true;
		
		while(!q.isEmpty()) {
			// 먼저 넣은 노드
			Pair node = q.poll();
			// 탐색한 횟수가 지정한 시간보다 길면 빠져나오기
			if(node.count>L) break;
			result++;
			switch(map[node.x][node.y]) {
			case 1 : // + 모양
				// 상하좌우 이동하면서 검사
				for(int i=0;i<4;i++) {
					int nodeX = node.x+dir[i][0];
	                int nodeY = node.y+dir[i][1];
	                // map의 크기보다 작거나 클 경우 넘어가기
	                if(nodeX<0 || nodeY<0 || nodeX>=N || nodeY>=M) continue;
	                // 방문하였었거나 map의 터널이 없는 경우 넘어가기
	                if(visited[nodeX][nodeY] || map[nodeX][nodeY]==0) continue;
	                // 길이 있으면 q에 새로 넣고 방문하였다고 만들어주기
	                if(check(nodeX,nodeY,i)) {
	                   q.add(new Pair(nodeX,nodeY,node.count+1));
	                   visited[nodeX][nodeY] = true;
	                }
	             }
				break;
			case 2 : // | 모양
				// 상하 이동하면서 검사
				for(int i=0;i<4;i+=2) {
					int nodeX = node.x+dir[i][0];
	                int nodeY = node.y+dir[i][1];
	                // map의 크기보다 작거나 클 경우 넘어가기
	                if(nodeX<0 || nodeY<0 || nodeX>=N || nodeY>=M) continue;
	                // 방문하였었거나 map의 터널이 없는 경우 넘어가기
	                if(visited[nodeX][nodeY] || map[nodeX][nodeY]==0) continue;
	                // 길이 있으면 q에 새로 넣고 방문하였다고 만들어주기
	                if(check(nodeX,nodeY,i)) {
	                   q.add(new Pair(nodeX,nodeY,node.count+1));
	                   visited[nodeX][nodeY] = true;
	                }
	             }
				break;
			case 3 : // ㅡ 모양
				// 좌우 이동하면서 검사
				for(int i=1;i<4;i+=2) {
					int nodeX = node.x+dir[i][0];
	                int nodeY = node.y+dir[i][1];
	                // map의 크기보다 작거나 클 경우 넘어가기
	                if(nodeX<0 || nodeY<0 || nodeX>=N || nodeY>=M) continue;
	                // 방문하였었거나 map의 터널이 없는 경우 넘어가기
	                if(visited[nodeX][nodeY] || map[nodeX][nodeY]==0) continue;
	                // 길이 있으면 q에 새로 넣고 방문하였다고 만들어주기
	                if(check(nodeX,nodeY,i)) {
	                   q.add(new Pair(nodeX,nodeY,node.count+1));
	                   visited[nodeX][nodeY] = true;
	                }
	             }
				break;
			case 4 : // └ 모양
				// 상우 이동하면서 검사
				for(int i=1;i<3;i++) {
					int nodeX = node.x+dir[i][0];
	                int nodeY = node.y+dir[i][1];
	                // map의 크기보다 작거나 클 경우 넘어가기
	                if(nodeX<0 || nodeY<0 || nodeX>=N || nodeY>=M) continue;
	                // 방문하였었거나 map의 터널이 없는 경우 넘어가기
	                if(visited[nodeX][nodeY] || map[nodeX][nodeY]==0) continue;
	                // 길이 있으면 q에 새로 넣고 방문하였다고 만들어주기
	                if(check(nodeX,nodeY,i)) {
	                   q.add(new Pair(nodeX,nodeY,node.count+1));
	                   visited[nodeX][nodeY] = true;
	                }
	             }
				break;
			case 5 : // ┌ 모양
				// 우하 이동하면서 검사
				for(int i=0;i<2;i++) {
					int nodeX = node.x+dir[i][0];
	                int nodeY = node.y+dir[i][1];
	                // map의 크기보다 작거나 클 경우 넘어가기
	                if(nodeX<0 || nodeY<0 || nodeX>=N || nodeY>=M) continue;
	                // 방문하였었거나 map의 터널이 없는 경우 넘어가기
	                if(visited[nodeX][nodeY] || map[nodeX][nodeY]==0) continue;
	                // 길이 있으면 q에 새로 넣고 방문하였다고 만들어주기
	                if(check(nodeX,nodeY,i)) {
	                   q.add(new Pair(nodeX,nodeY,node.count+1));
	                   visited[nodeX][nodeY] = true;
	                }
	             }
				break;
			case 6 : // ┐ 모양
				// 하좌 이동하면서 검사
				for(int i=0;i<4;i+=3) {
					int nodeX = node.x+dir[i][0];
	                int nodeY = node.y+dir[i][1];
	                // map의 크기보다 작거나 클 경우 넘어가기
	                if(nodeX<0 || nodeY<0 || nodeX>=N || nodeY>=M) continue;
	                // 방문하였었거나 map의 터널이 없는 경우 넘어가기
	                if(visited[nodeX][nodeY] || map[nodeX][nodeY]==0) continue;
	                // 길이 있으면 q에 새로 넣고 방문하였다고 만들어주기
	                if(check(nodeX,nodeY,i)) {
	                   q.add(new Pair(nodeX,nodeY,node.count+1));
	                   visited[nodeX][nodeY] = true;
	                }
	             }
				break;
			case 7 : // ┛
				// 상좌 이동하면서 검사
				for(int i=2;i<4;i++) {
					int nodeX = node.x+dir[i][0];
	                int nodeY = node.y+dir[i][1];
	                // map의 크기보다 작거나 클 경우 넘어가기
	                if(nodeX<0 || nodeY<0 || nodeX>=N || nodeY>=M) continue;
	                // 방문하였었거나 map의 터널이 없는 경우 넘어가기
	                if(visited[nodeX][nodeY] || map[nodeX][nodeY]==0) continue;
	                // 길이 있으면 q에 새로 넣고 방문하였다고 만들어주기
	                if(check(nodeX,nodeY,i)) {
	                   q.add(new Pair(nodeX,nodeY,node.count+1));
	                   visited[nodeX][nodeY] = true;
	                }
	             }
				break;
			}
		}
	}
	
	// 터널 타입이 서로 연결되어있는지 여부
    private static boolean check(int x, int y, int i) {
        int type = map[x][y];
        switch(i) {
        case 0: // 아래쪽으로 길이 있어야 함 (1, 2, 4, 7)
           if(type==3||type==5||type==6) return false;
           break;
        case 1: // 오른쪽으로 길이 있어야 함 (1, 3, 6, 7)
           if(type==2||type==4||type==5) return false;
           break;
        case 2: // 위쪽으로 길이 있어야 함 (1, 2, 5, 6)
           if(type==3||type==4||type==7) return false;
           break;
        case 3: // 왼쪽으로 길이 있어야 함 (1, 3, 4, 5)
           if(type==2||type==6||type==7) return false;
           break;
        }
        
        return true;
     }
	
	// 탐색할 노드
	static class Pair {
		private int x, y, count;
		public Pair(int x, int y, int count) {
			this.x = x; 
			this.y = y; 
			this.count = count; 
		}
		
	}
}
