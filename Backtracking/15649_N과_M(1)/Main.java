package test;
import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb;
	
	static void dfs(int depth) {
		if(depth==m) {
			for(int i=0;i<arr.length;i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				visited[i]=true;
				arr[depth]=i+1;
				
				dfs(depth+1);
				
				visited[i]=false;
			}
		}
	}

    public static void main(String[] args) throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine()," ");
    	sb=new StringBuilder();
    	
    	n=Integer.parseInt(st.nextToken());
    	m=Integer.parseInt(st.nextToken());
    	
    	visited=new boolean[n];
    	arr=new int[m];
    	
    	
    	dfs(0);
    	System.out.println(sb);
    }

}