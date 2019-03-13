package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1873_SanghoBattleField {
	static int H, W, N, curX, curY;
	static String temp = "";
	static char gamemap[][], gameaction[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st ;
		
		for(int i=0 ; i<T ; i++) {
			// 게임 맵 입력
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			gamemap = new char[H][W];
			for(int j=0; j<H ; j++) {
				temp = br.readLine();
				for(int k=0; k<W ; k++) {
					gamemap[j][k] = temp.charAt(k);
					if(gamemap[j][k] == '^' || gamemap[j][k] == 'v' ||
					   gamemap[j][k] == '<' || gamemap[j][k] == '>' ) {
						curX = j;
						curY = k;
					}
				}
			}
			
			// 게임 동작 입력
			N = Integer.parseInt(br.readLine());
			gameaction = new char[N];
			temp = br.readLine();
			for(int j=0 ; j<N ; j++) {
				gameaction[j] = temp.charAt(j);
			}
			
			move();
			
			// 출력
			System.out.print("#"+ (i+1) + " ");
			for(int a=0; a<H ; a++) {
				for(int b=0; b<W ; b++) 
					System.out.print(gamemap[a][b]);
				System.out.println();
			}
		}
	}
	
	public static void move() {
		for(int i=0; i<N ; i++) {
			switch(gameaction[i]) {
			// U 일 때 : 위로 이동
			case 'U' :
				if(curX-1<0 ||
				   gamemap[curX-1][curY] == '#' || gamemap[curX-1][curY] == '*' || gamemap[curX-1][curY] == '-') {
					gamemap[curX][curY] = '^';
				} else {
					gamemap[curX][curY] = '.';
					gamemap[curX-1][curY] = '^';
					curX = curX-1;
				}
				break;
			// D 일 때 : 아래로 이동
			case 'D' :
				if(curX+1>=H ||
				   gamemap[curX+1][curY] == '#' || gamemap[curX+1][curY] == '*' || gamemap[curX+1][curY] == '-') {
					gamemap[curX][curY] = 'v';
				} else {
					gamemap[curX][curY] = '.';
					gamemap[curX+1][curY] = 'v';
					curX = curX+1;
				}
				break;
			// L 일 때 : 왼쪽으로 이동
			case 'L' :
				if(curY-1<0 || 
				   gamemap[curX][curY-1] == '#' || gamemap[curX][curY-1] == '*' || gamemap[curX][curY-1] == '-') {
					gamemap[curX][curY] = '<';
				} else {
					gamemap[curX][curY] = '.';
					gamemap[curX][curY-1] = '<';
					curY = curY-1;
				}
				break;
			// R 일 때 : 오른쪽으로 이동
			case 'R' :
				if(curY+1>=W ||
				   gamemap[curX][curY+1] == '#' || gamemap[curX][curY+1] == '*' || gamemap[curX][curY+1] == '-') {
					gamemap[curX][curY] = '>';
				} else {
					gamemap[curX][curY] = '.';
					gamemap[curX][curY+1] = '>';
					curY = curY+1;
				}
				break;
			// S 일 때 : Shoot
			case 'S' :
				switch(gamemap[curX][curY]) {
				case '^' :
					for(int j=curX-1; j>=0 ; j--) {
						if(gamemap[j][curY] == '#') break;
						 else if(gamemap[j][curY] == '*') {
							gamemap[j][curY] = '.';
							break;
						}
					}
					break;
				case 'v' :
					for(int j=curX+1; j<H ; j++) {
						if(gamemap[j][curY] == '#') break;
						else if(gamemap[j][curY] == '*') {
							gamemap[j][curY] = '.';
							break;
						}
					}
					break;
				case '<' :
					for(int j=curY-1; j>=0 ; j--) {
						if(gamemap[curX][j] == '#') break;
						else if(gamemap[curX][j] == '*') {
							gamemap[curX][j] = '.';
							break;
						}
					}
					break;
				case '>' :
					for(int j=curY+1; j<W ; j++) {
						if(gamemap[curX][j] == '#')	break;
						else if(gamemap[curX][j] == '*') {
							gamemap[curX][j] = '.';
							break;
						} 
					}
					break;
				}
				break;
			}
		}
	}
}
