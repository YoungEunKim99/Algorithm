package test;
import java.io.*;
import java.util.*;
class Node{
	int x;
	int y;
	public Node(int x,int y) {
		this.x=x;
		this.y=y;
	}
}

public class Main {
	static int n;
	static int l;
	static int r;
	static int[][] a;
	static ArrayList<Node> list;
	static boolean[][] visited;
	
	public static void changePopulation(int sum) {
		int avg=sum/list.size();
		for(Node n:list) {
			a[n.x][n.y]=avg;
		}
	}
	
	public static int move(){
		int moves=0;
		
		while(true) {
			boolean isMove=false;
			visited=new boolean[n][n]; 
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(!visited[i][j]) {
						int sum=bfs(i,j);
						if(list.size()>1) {
							changePopulation(sum);
							isMove=true;
							
						}
					}
				}
			}
			
			if(!isMove) return moves;
			moves++;
		}	
	}
	
	public static int bfs(int x, int y) {
		int sum=a[x][y];
		Queue<Node> q=new LinkedList<>();
		list.clear();
		
		int[] di= {0,1,0,-1};//¿À ¾Æ ¿Þ À§
		int[] dj= {1,0,-1,0};
		
		list.add(new Node(x,y));
		visited[x][y]=true;
		q.offer(new Node(x,y));
		
		while(!q.isEmpty()) {
			Node currentNode=q.poll();
			for(int i=0;i<4;i++) {
				int nx=currentNode.x+di[i];
				int ny=currentNode.y+dj[i];
				if(nx>-1&&ny>-1&&nx<n&&ny<n) {
					if(Math.abs(a[currentNode.x][currentNode.y]-a[nx][ny])>=l
							&&Math.abs(a[currentNode.x][currentNode.y]-a[nx][ny])<=r
							&&!visited[nx][ny]) {
						q.offer(new Node(nx,ny));
						list.add(new Node(nx,ny));
						sum+=a[nx][ny];
						visited[nx][ny]=true;
						
					}
				}
			}
			
		}
		return sum;
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		n=Integer.parseInt(st.nextToken());
		l=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		list=new ArrayList<>();
		a=new int[n][n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<n;j++) {
				a[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(move());
	}

}
