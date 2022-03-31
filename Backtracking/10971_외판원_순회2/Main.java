package test;
import java.util.*;
import java.io.*;
 

public class Main {

	static int N;
	static int[][] map;
	static boolean[] visited;
	static long minCost=Integer.MAX_VALUE;
	
	public static void solve(int start,int current,int depth,int cost) {
		if(depth==N) {
			if(map[current][start]!=0) {
				minCost=Math.min(minCost,cost+map[current][start]);
			}
		}
		else {
			for(int i=0;i<N;i++) {
				if(visited[i]) {
					continue;
				}
				if(map[current][i]==0) {
					continue;
				}
				
				visited[i]=true;
				cost+=map[current][i];
				
				solve(start,i,depth+1,cost);
				
				cost-=map[current][i];
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
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i=0;i<N;i++) {	
			visited[i]=true;
			solve(i,i,1,0);
			visited[i]=false;
		}
		
		System.out.println(minCost);
	}
}