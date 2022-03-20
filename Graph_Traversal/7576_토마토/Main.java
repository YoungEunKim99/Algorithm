package test;
import java.util.*;
import java.io.*;

class Point{
	int i;
	int j;
	public Point(int i,int j) {
		this.i=i;
		this.j=j;
	}
}

public class Main{
	static int M;
	static int N;
	static int[][] map;
	static int unripe;

	
	public static void bfs() {
		Queue<Point> q=new LinkedList<>();
		int[] di= {0,1,0,-1};
		int[] dj= {1,0,-1,0};
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==1) {
					q.offer(new Point(i,j));
				}
				else if(map[i][j]==0) {
					unripe++;
				}
			}
		}
		int day=0;
		while(!q.isEmpty()) {
			
			
			for(int i=q.size();i>0;i--) {
				Point currentPoint=q.poll();
				for(int k=0;k<4;k++) {
					int ni=currentPoint.i+di[k];
					int nj=currentPoint.j+dj[k];
					
					if(ni<0||nj<0||ni>=N||nj>=M) {
						continue;
					}
					if(map[ni][nj]==0) {
						map[ni][nj]=1; unripe--;
						q.offer(new Point(ni,nj));
					}
					
				}
			}
			
			day++;
		}
		
		
		if(unripe!=0) {
			System.out.println(-1);
		}
		else {
			System.out.println(day-1);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		map=new int[N][M];
	
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				
			}
		}
		bfs();
	}
}