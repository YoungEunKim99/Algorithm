package test;
import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int T=Integer.parseInt(br.readLine());

		while(T-->0) {
			int N=Integer.parseInt(br.readLine());
			int[] arr=new int[N+1];
			int[] dp=new int[N+1];
			
			dp[1]=1;
			if(N>=2) {
				dp[2]=2;                                                                                        
			}
			if(N>=3) {
				dp[3]=4;
			}
			for(int i=4;i<=N;i++) {
				dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
			}
			
			sb.append(dp[N]).append("\n");
		}
		
		System.out.println(sb);
	}
}