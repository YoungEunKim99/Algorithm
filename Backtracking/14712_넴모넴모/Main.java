package test;
import java.util.*;
import java.io.*;
 

public class Main {

	static int N;
	static int M;
	static boolean[][] map;
	static int cnt=0;
	
	public static void solve(int row, int col) {
		if(row==N) {
			for(int i=0;i<N-1;i++) {
				for(int j=0;j<M-1;j++) {
					if(map[i][j]&&map[i][j+1]&&map[i+1][j]&&map[i+1][j+1]) {
						return;
					}
				}
			}
			cnt++;
		}
		else {
			int nextCol=(col==M-1) ? 0:col+1;
			int nextRow=(nextCol==0) ? row+1:row;
			
			map[row][col]=true;
			solve(nextRow,nextCol);
			map[row][col]=false;
			solve(nextRow,nextCol);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new boolean[N][M];
		solve(0,0);
		System.out.println(cnt);
	}
}