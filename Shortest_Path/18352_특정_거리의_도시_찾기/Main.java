package test;
import java.io.*;
import java.util.*;
//1~N까지의 도시 M개의 단방향 도로: 거리 1
//최단 거리 K로 갈 수 있는모든 길 출려ㅕㄱ

public class Main {
	static int k;
	static int x;
	static int[] cnt;
    static ArrayList<Integer>[] map;
	public static void bfs() {
		Queue<Integer> q=new LinkedList<>();
		q.offer(x);
		while(!q.isEmpty()) {
			int currentNode=q.poll();
			
			for(int i=0;i<map[currentNode].size();i++) {
				int nextNode=map[currentNode].get(i);
				if(cnt[nextNode]==0) {
					q.offer(nextNode);
					cnt[nextNode]=cnt[currentNode]+1;
				}
			}
		}
	}
	public static void main(String[] args)throws IOException {
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 StringTokenizer st=new StringTokenizer(br.readLine()," ");
	 StringBuilder sb=new StringBuilder();
	 int n=Integer.parseInt(st.nextToken());
	 int m=Integer.parseInt(st.nextToken());
	 k=Integer.parseInt(st.nextToken());
	 x=Integer.parseInt(st.nextToken());
	 
	 cnt=new int[n+1];
	 map=new ArrayList[n+1];
	 for(int i=0;i<=n;i++) {
		 map[i]=new ArrayList<Integer>();
	 }
	 
	 while(m-->0) {
		st=new StringTokenizer(br.readLine()," ");
		int nodeU=Integer.parseInt(st.nextToken());
		int nodeV=Integer.parseInt(st.nextToken());
		map[nodeU].add(nodeV);
	 }
	 bfs();
	 boolean pathExist=false;
	 for(int i=1;i<=n;i++) {
		 if(i!=x&&cnt[i]==k) {
			 pathExist=true;
			 sb.append(i+"\n");
		 }
	 }
	 if(pathExist) {
		 System.out.println(sb);
	 }
	 else {
		 System.out.println("-1");
	 }
 }
}