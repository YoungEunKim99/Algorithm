package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	
	static int nodes;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int[] parents;
	
	static void setData() throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		nodes=Integer.parseInt(br.readLine());
		list=new ArrayList[nodes+1];
		visited=new boolean[nodes+1];
		parents=new int[nodes+1];
		
		for(int i=1;i<=nodes;i++) {
			list[i]=new ArrayList<Integer>();
		}
		
		while(nodes-->1) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int node1=Integer.parseInt(st.nextToken());
			int node2=Integer.parseInt(st.nextToken());
			list[node1].add(node2);
			list[node2].add(node1);
		}
	}
	
	static void dfs() {
		Stack<Integer> stack=new Stack<>();
		stack.push(1);
		while(!stack.isEmpty()) {
			
			int currentNode=stack.pop();
			
			if(!visited[currentNode]) {
				visited[currentNode]=true;
			
				for(int node:list[currentNode]) {
					if(!visited[node]) {
						parents[node]=currentNode;
						stack.push(node);
					}
					
				}
			}
			
		}
	}
	public static void main(String[] args) throws IOException{
		setData();
		dfs();
		for(int i=2;i<parents.length;i++) {
			System.out.println(parents[i]);
		}
		
	}

}
