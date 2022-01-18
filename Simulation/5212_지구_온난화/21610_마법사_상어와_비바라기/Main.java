package test;
import java.io.*;
import java.util.*;

class Node{
	int x;
	int y;
	public Node(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

public class Main {
	static int n;
	static int m;
	static int[][] a;
	static int[][] direction;
	static Queue<Node> cloud;
	static Queue<Node> list;
	static boolean[][] visited;
	
	static int[] di= {0,-1,-1,-1,0,1,1,1};
	static int[] dj= {-1,-1,0,1,1,1,0,-1};
	//1357
	public static void magic() {
		while(!list.isEmpty()) {
			Node current=list.poll();
			for(int i=1;i<8;i+=2) {
				int nx=current.x+di[i];
				int ny=current.y+dj[i];
				if(nx>-1&&ny>-1&&nx<n&&ny<n) {
					if(a[nx][ny]>0) {
						a[current.x][current.y]++;
					}
				}
			}
			
		}
	}
	public static void move() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!visited[i][j]&&a[i][j]>=2) {
					cloud.offer(new Node(i,j));
					a[i][j]-=2;
				}
			}
		}
	}

	public static void rain() {
		for(int i=0;i<m;i++) {
			visited=new boolean[n][n];
			while(!cloud.isEmpty()) {
				Node node=cloud.poll();
			
				int x=(node.x+di[(direction[i][0]-1)]*direction[i][1])%n;
				int y=(node.y+dj[(direction[i][0]-1)]*direction[i][1])%n;
				while(true) {
					if(x<0) x=n+x;
					else break;
				}
				while(true) {
					if(y<0) y=n+y;
					else break;
				}
				
				a[x][y]++;
				visited[x][y]=true;
				list.offer(new Node(x,y));
				
				
			}
			magic();
			move();
			
		}
	}
	
	public static int calculate() {
		int sum=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				sum+=a[i][j];
			}
		}
		return sum;
	}
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		a=new int[n][n];
		list=new LinkedList<Node>();
		cloud=new LinkedList<Node>();
		direction=new int[m][2];
		
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<n;j++) {
				a[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine()," ");
			direction[i][0]=Integer.parseInt(st.nextToken());
			direction[i][1]=Integer.parseInt(st.nextToken());
		}
		cloud.offer(new Node(n-1,0));
		cloud.offer(new Node(n-1,1));
		cloud.offer(new Node((n-2),0));
		cloud.offer(new Node((n-2),1));
		rain();
		System.out.println(calculate());
	}

}
