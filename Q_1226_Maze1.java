package swexpertacademy;

import java.io.IOException;
import java.util.Scanner;

public class Q_1226_Maze1 {
	static int[][] maze;
	static int startI = 0;
	static int startJ = 0;
	static int endI = 0;
	static int endJ = 0;
	static final int PATHWAY = 0;
	static final int WALL = 1;
	static final int BLOCKED = 4; // visited�̸� �ⱸ������ ��� ���� cell
	static final int PATH = 5; // visited�̸� ���� �ⱸ�� ���� ��ΰ� �� ���ɼ��� �ִ� cell
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int numberT = 0;
		maze = new int[16][16];
		String mazeNum = "";
		
		// �Է�
		for(int i=0; i<10 ; i++) {
			numberT = sc.nextInt();
			sc.nextLine();
			for(int j=0; j<16 ; j++) {
				mazeNum = sc.nextLine();
				for(int k=0; k<16 ; k++) {
					maze[j][k] = mazeNum.charAt(k) - 48;
					if(maze[j][k] == 2) {
						startI = j;
						startJ = k;
					} else if(maze[j][k] == 3) {
						endI = j;
						endJ = k;
					}
				}
			}
			//���
			System.out.print("#"+numberT+" ");
			if(findMazePath(startI, startJ)) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
		
	}
	
	public static boolean findMazePath(int x, int y) {
		// x, y ��ǥ�� ��ȣ�� �����ΰ�
		if(x<0 || y<0 || x>=16 || y>=16) {
			return false;
		}
		// ���� �ƴѰ��
		else if(maze[x][y] == WALL || maze[x][y] == BLOCKED) {
			if(findMazePath(x, y+1) || findMazePath(x, y-1) || findMazePath(x+1, y) || findMazePath(x-1, y)) {
				return true;
			}
		}
		// ���������� �������� ���
		else if(x == endI && y == endJ) {
			maze[x][y] = PATH;
			return true;
		}
		else {
			maze[x][y] = PATH; // �ϴ� �湮������ PATH_COLOR
			// ���� ��ġ�� ��,��,��,���� ������������ �˻�
			if(findMazePath(x, y+1) || findMazePath(x, y-1) || findMazePath(x+1, y) || findMazePath(x-1, y)) {
				return true;
			}
			// ������������ ���� ��ΰ� ����
			maze[x][y] = BLOCKED;
			return false;
		}
		
		return false;
	}
}
