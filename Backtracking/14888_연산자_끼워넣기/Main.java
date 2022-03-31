package test;
import java.util.*;
import java.io.*;
 


public class Main {

	static int N;
	static int[] numbers;
	static char[] operators;
	static boolean[] visited;
	static int max=Integer.MIN_VALUE;
	static int min=Integer.MAX_VALUE;
	
	public static void solve(int depth,int sum) {
		if(depth==N-1) {
			max=Math.max(max, sum);
			min=Math.min(min, sum);
		}
		else {
			for(int i=0;i<N-1;i++) {
				
				if(visited[i]) {
					continue;
				}
				
				visited[i]=true;
				
				if(operators[i]=='+') {
					solve(depth+1,sum+numbers[depth+1]);
				}
				else if(operators[i]=='-') {
					solve(depth+1,sum-numbers[depth+1]);
				}
				else if(operators[i]=='*') {
					solve(depth+1,sum*numbers[depth+1]);
				}
				else {
					solve(depth+1,sum/numbers[depth+1]);	
				}
				
				visited[i]=false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		numbers=new int[N];
		operators=new char[N-1];
		visited=new boolean[N-1];
		
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			numbers[i]=Integer.parseInt(st.nextToken());
		}
		
		int idx=0;
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<4;i++) {
			int cnt=Integer.parseInt(st.nextToken());
			for(int j=0;j<cnt;j++) {
				if(i==0) {
					operators[idx++]='+';
				}
				else if(i==1) {
					operators[idx++]='-';
				}
				else if(i==2) {
					operators[idx++]='*';
				}
				else {
					operators[idx++]='/';
				}
			}
		}
		
		solve(0,numbers[0]);
		System.out.println(max);
		System.out.println(min);
	}
}