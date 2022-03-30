import java.util.*;
import java.io.*;
 
public class Main {
	
	static int N;
	static int M;
	static StringBuilder sb;
	static int[] arr;

	public static void dfs(int depth) {
		if(depth==M) {
			for(int i=0;i<arr.length;i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
		}
		else {
			for(int i=0;i<N;i++) {
				arr[depth]=i+1;
				
				dfs(depth+1);
			}
		}
	}
	
	public static void main(String args[]) throws IOException{
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine()," ");
    	
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	
    	sb=new StringBuilder();
    	arr=new int[M];
    	
    	
    	dfs(0);
    	
    	System.out.println(sb);
    }
}