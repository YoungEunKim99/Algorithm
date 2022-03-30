package test;
import java.util.*;
import java.io.*;
 

public class Main {
	
	static int N;
	static int M;
	static int[] num;
	static boolean[] visited;
	static int[] arr;
	static StringBuilder sb;
	
	public static void dfs(int depth) {
		if(M==depth) {
			for(int i=0;i<arr.length;i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
		}
		else {
			for(int i=0;i<num.length;i++) {
				if(visited[i]) {
					continue;
				}
				visited[i]=true;
				arr[depth]=num[i];
				
				dfs(depth+1);
				
				visited[i]=false;
			}
		}
	}
	public static void main(String args[]) throws IOException{
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	sb=new StringBuilder();
    	StringTokenizer st=new StringTokenizer(br.readLine()," ");
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	
    	arr=new int[M];
    	visited=new boolean[N];
    	num=new int[N];
    	st=new StringTokenizer(br.readLine()," ");
    	for(int i=0;i<N;i++) {
    		num[i]=Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(num);
    	
    	dfs(0);
    	System.out.println(sb);
    }
}