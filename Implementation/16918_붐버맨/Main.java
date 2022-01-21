package test;
import java.io.*;
import java.util.*;

public class Main {
	static int R;
	static int C;
	static int N;
	static char[][] board;
	static int[][] time;
	static int[] di= {0,1,0,-1};//¿À ¾Æ·¡ À§ ¿Þ
	static int[] dj= {1,0,-1,0};
	
	public static void plusSecond() {
		N--;
		for(int i=0;i<R;i++) {//+1ÃÊ
			for(int j=0;j<C;j++) {
				if(board[i][j]=='O') {
					time[i][j]++;
				}
			}
		}
	}
	
	public static void explosion() {
		plusSecond();
		if(N==0) return;
		
		while(true) {
			
			plusSecond();
			for(int i=0;i<R;i++) {//³ª¸ÓÁö °ø°£¿¡ ÆøÅº ¼³Ä¡
				for(int j=0;j<C;j++) {
					if(board[i][j]=='.') {
						board[i][j]='O';
					}
				}
			}
			if(N==0) break; 
			
			plusSecond();
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(time[i][j]==3) {
						board[i][j]='.';//¼³Ä¡µÈ Áö 3ÃÊ Áö³­ ÆøÅº ÅÍÁü
						time[i][j]=0;
						
						for(int k=0;k<4;k++) {//±ÙÃ³ 4°÷ ÆøÅº ÅÍÁü
							int x=j+dj[k];
							int y=i+di[k];
							
							if(x>=0&&y>=0&&x<C&&y<R) {
								if(time[y][x]!=3) {
									board[y][x]='.';
									time[y][x]=0;
								}
							}
						}
						
					}
				}
			}
			if(N==0) break;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		board=new char[R][C];
		time=new int[R][C];
		for(int i=0;i<R;i++) {
			board[i]=br.readLine().toCharArray();
		}
		explosion();
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				sb.append(board[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
		
	}
	
}