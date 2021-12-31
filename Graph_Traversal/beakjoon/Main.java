package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	
	static int cumputer;
	static boolean[][] graph;
	static boolean[] visited;
	static void setData() throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		cumputer=Integer.parseInt(br.readLine());
		int n=Integer.parseInt(br.readLine());
		visited=new boolean[cumputer+1];
		graph=new boolean[cumputer+1][cumputer+1];
		
		while(n-->0) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int node1=Integer.parseInt(st.nextToken());
			int node2=Integer.parseInt(st.nextToken());
			graph[node1][node2]=true;
			graph[node2][node1]=true;
		}
	}
	
	static void bfs() {
		Queue<Integer> queue=new LinkedList<>();
		queue.add(1);
		int cnt=0;
		visited[1]=true;
		
		while(!queue.isEmpty()) {
			int currentNode=queue.poll();
			for(int i=0;i<cumputer;i++) {
				if(graph[currentNode][i+1]==true) {
					int temp=i+1;
					if(!visited[temp]) {
						visited[temp]=true;
						queue.offer(temp);
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}
	public static void main(String[] args) throws IOException{
		setData();
		bfs();
	}

}
