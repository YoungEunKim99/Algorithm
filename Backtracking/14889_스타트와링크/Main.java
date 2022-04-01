package test;
import java.util.*;
import java.io.*;
 

public class Main {
	static int N;
	static int diff=Integer.MAX_VALUE;
	static int[][] map;
	static boolean[] visited;
	
	public static void solve(int depth) {
		if(depth==N/2) {
			int teamStart = 0;
			int teamLink = 0;
	 
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					
					if (visited[i] && visited[j]) {
						teamStart += map[i][j];
						teamStart += map[j][i];
					}
					else if ((!visited[i]) && (!visited[j])) {
						teamLink += map[i][j];
						teamLink += map[j][i];
					}
				}
			}
			
			
			diff=Math.min(diff, Math.abs(teamStart-teamLink));
		}
		else {
			for(int i=0;i<N;i++) {
				if(visited[i]) {
					continue;
				}
				visited[i]=true;
				solve(depth+1);
				visited[i]=false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		visited=new boolean[N];
		
		for(int i=0;i<N;i++) {			
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		solve(0);			
		
		System.out.println(diff);
	}
}