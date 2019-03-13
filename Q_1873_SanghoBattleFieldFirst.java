package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1873_SanghoBattleFieldFirst {
   static int H = 0;
   static int W = 0;
   static String temp = "";
   static char[][] gamemap;
   static int N = 0;
   static char[] gameaction;
   static int curX = 0;
   static int curY = 0;
   
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
            }
         }
         
         // 현재 전차 위치 저장
         saveCur();
         
         // 게임 동작 입력
         N = Integer.parseInt(br.readLine());
         gameaction = new char[N];
         temp = br.readLine();
         for(int j=0 ; j<N ; j++) {
            gameaction[j] = temp.charAt(j);
         }
         
         // 게임 움직임
         move();
         
         // 출력
         System.out.print("#"+ (i+1) + " ");
         for(int a=0; a<H ; a++) {
            for(int b=0; b<W ; b++) {
               System.out.print(gamemap[a][b]);
            }
            System.out.println();
         }
      }
   }
   
   // 현재 전차의 위치를 저장
   public static void saveCur() {
      for(int i=0; i<H ; i++) {
         for(int j=0; j<W ; j++) {
            if(gamemap[i][j] == '^' || gamemap[i][j] == 'v' || gamemap[i][j] == '<' || gamemap[i][j] == '>' ) {
               curX = i;
               curY = j;
            }
         }
      }
   }   
   
   public static void move() {
      for(int i=0; i<N ; i++) {
         // U 일 때 : 위로 이동
         if(gameaction[i] == 'U') {
            if(curX-1<0 || gamemap[curX-1][curY] == '#' || gamemap[curX-1][curY] == '*' || gamemap[curX-1][curY] == '-') {
               gamemap[curX][curY] = '^';
            } else {
               gamemap[curX][curY] = '.';
               gamemap[curX-1][curY] = '^';
               curX = curX-1;
            }
         // D 일 때 : 아래로 이동
         } else if(gameaction[i] == 'D') {
            if(curX+1>=H || gamemap[curX+1][curY] == '#' || gamemap[curX+1][curY] == '*' || gamemap[curX+1][curY] == '-') {
               gamemap[curX][curY] = 'v';
            } else {
               gamemap[curX][curY] = '.';
               gamemap[curX+1][curY] = 'v';
               curX = curX+1;
            }
         // L 일 때 : 좌로 이동
         } else if(gameaction[i] == 'L') {
            if(curY-1<0 || gamemap[curX][curY-1] == '#' || gamemap[curX][curY-1] == '*' || gamemap[curX][curY-1] == '-') {
               gamemap[curX][curY] = '<';
            } else {
               gamemap[curX][curY] = '.';
               gamemap[curX][curY-1] = '<';
               curY = curY-1;
            }
         // R 일 때 : 우로 이동
         } else if(gameaction[i] == 'R') {
            if(curY+1>=W || gamemap[curX][curY+1] == '#' || gamemap[curX][curY+1] == '*' || gamemap[curX][curY+1] == '-') {
               gamemap[curX][curY] = '>';
            } else {
               gamemap[curX][curY] = '.';
               gamemap[curX][curY+1] = '>';
               curY = curY+1;
            }
         // S 일 때 : 포탄
         } else if(gameaction[i] == 'S') {
            if(gamemap[curX][curY] == '^') {
               if(curX-1<0) {
               } else {
                  for(int j=curX-1; j>=0 ; j--) {
                     if(gamemap[j][curY] == '#') {
                        break;
                     } else if(gamemap[j][curY] == '*') {
                        gamemap[j][curY] = '.';
                        break;
                     }
                  }
               } 
            } else if(gamemap[curX][curY] == 'v') {
               if(curX+1>=H) {
               } else {
                  for(int j=curX+1; j<H ; j++) {
                     if(gamemap[j][curY] == '#') {
                        break;
                     } else if(gamemap[j][curY] == '*') {
                        gamemap[j][curY] = '.';
                        break;
                     }
                  }
               }
            } else if(gamemap[curX][curY] == '<') {
               if(curY-1<0) {
               } else {
                  for(int j=curY-1; j>=0 ; j--) {
                     if(gamemap[curX][j] == '#') {
                        break;
                     } else if(gamemap[curX][j] == '*') {
                        gamemap[curX][j] = '.';
                        break;
                     }
                  }
               }
            } else if(gamemap[curX][curY] == '>') {
               if(curY+1>=W) {
               } else {
                  for(int j=curY+1; j<W ; j++) {
                     if(gamemap[curX][j] == '#') {
                        break;
                     } else if(gamemap[curX][j] == '*') {
                        gamemap[curX][j] = '.';
                        break;
                     } 
                  }
               }
            }
         }
      }
   }
}