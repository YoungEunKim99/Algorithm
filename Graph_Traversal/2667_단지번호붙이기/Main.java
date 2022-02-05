package test;
import java.util.*;
import java.io.*;
class Node{
	int y;
	int x;
	public Node(int y,int x) {
		this.y=y;
		this.x=x;
	}
}
public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int N;
	
	public static int bfs(int y,int x) {
		Queue<Node> q=new LinkedList<>();
		int cnt=0;
		int[] dx= {0,1,0,-1};
		int[] dy= {1,0,-1,0};//아래 오른쪽 위 왼
		
		q.offer(new Node(y,x));
		visited[y][x]=true;
		
	
		while(!q.isEmpty()) {
			Node node=q.poll();
			cnt++;
			
			for(int k=0;k<4;k++) {
				int nx=node.x+dx[k];
				int ny=node.y+dy[k];
				
				if(nx>=0&&nx<N&&ny>=0&&ny<N) {
					if(!visited[ny][nx]) {
						q.offer(new Node(ny,nx)); visited[ny][nx]=true;
					}
				}
			}
		}
		return cnt;
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		visited=new boolean[N][N];
		ArrayList list=new ArrayList<>();
		for(int i=0;i<N;i++) {
			String tmp=br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(String.valueOf(tmp.charAt(j)));
				if(map[i][j]==0) visited[i][j]=true;
			}
			
			
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1&&!visited[i][j]) {
					list.add(bfs(i,j));
				}
			}
		}
		
		Collections.sort(list);
		
		sb.append(list.size()).append('\n');
		for(int i=0;i<list.size();i++) {
			sb.append(list.get(i)).append('\n');
		}
		System.out.println(sb);
	} 
}
