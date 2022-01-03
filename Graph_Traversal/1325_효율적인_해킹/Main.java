package beakjoon;
import java.io.*;
import java.util.*;
public class Main {
	static int n;
	static List<Integer>[] arraylist; 
	static int[] hackable;
	
	public static void bfs(int node) {
		boolean[] visited=new boolean[n+1];
		Queue<Integer>queue=new LinkedList<>();
		queue.add(node);
		visited[node]=true;
		while(!queue.isEmpty()){
			int currentNode=queue.poll();	
			for(int next:arraylist[currentNode]) {
				if(!visited[next]) {
					visited[next]=true;
					queue.add(next);
					hackable[node]++;
				}
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int max=Integer.MIN_VALUE;
		
		n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		arraylist=new ArrayList[n+1];
		hackable=new int[n+1];
		
		for(int i=0;i<=n;i++) {
			arraylist[i]=new ArrayList<Integer>();
		}
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine()," ");
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			arraylist[b].add(a);
		}
	
		for(int node=1;node<=n;node++) {
			
			bfs(node);
		}
		
		for(int i=1;i<=n;i++) {
			max=Math.max(max, hackable[i]);
		}
		for(int i=1;i<=n;i++) {
			if(max==hackable[i]) {
				bw.write(i+" ");
			}
		}
		bw.flush();
		bw.close();
	}
}