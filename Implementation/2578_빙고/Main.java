package beakjoon;
import java.io.*;
import java.util.*;
public class Main {
	static int[][] board=new int[5][5];
	static int[][] moderator=new int[5][5];
	static boolean[] horizontal=new boolean[5];
	static boolean[] vertical=new boolean[5];
	static boolean[] diagonal=new boolean[2];
	static int bingo=0;
	
	public static void checkVertical() {
		for(int i=0;i<5;i++) {
			int sum=0;
			if(!vertical[i]) {
				for(int j=0;j<5;j++) {
					sum+=board[j][i];
				}
				if(sum==0) {
					vertical[i]=true;
					bingo++;
				}
			}
		}
	}
	
	public static void checkHorizontal() {
		for(int i=0;i<5;i++) {
			int sum=0;
			if(!horizontal[i]) {
				for(int node:board[i]) {
					sum+=node;
				}
				if(sum==0) {
					horizontal[i]=true;
					bingo++;
				}
			}
		}
	}
	
	public static void checkDiagonal() {
		if(!diagonal[0]) {
			if(board[0][4]+board[1][3]+board[2][2]+board[3][1]+board[4][0]==0) {
				diagonal[0]=true;
				bingo++;
			}
		}
		if(!diagonal[1]) {
			if(board[0][0]+board[1][1]+board[2][2]+board[3][3]+board[4][4]==0) {
				diagonal[1]=true;
				bingo++;
			}
		}
	}
	
	public static int bingGo() {
			int stop=0;
			for(int i=0;i<5;i++) {
				for(int j=0;j<5;j++) {
					//find number
					outerloop:
	                 for(int k=0;k<5;k++) {
						for(int l=0;l<5;l++) {
							if(board[k][l]==moderator[i][j]) {
								board[k][l]=0;
								break outerloop;
							}
						}
					}
					
					if(i!=0) {
						checkVertical();
						checkHorizontal();
						 checkDiagonal();
					}
					if(bingo>=3) {
						return i*5+j+1;
					}
					
				}
			}
			return 0;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0;i<5;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<5;j++) {
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<5;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<5;j++) {
				moderator[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		bw.write(String.valueOf(bingGo()));
		bw.flush();
		bw.close();
	}		
}