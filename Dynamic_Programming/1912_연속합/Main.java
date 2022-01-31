package test;
import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N;
		N=Integer.parseInt(br.readLine());
		
		int[] arr=new int[N+1];
		int[] dp=new int[N+1];
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			dp[i]=Integer.MIN_VALUE;
		}
		int max=Integer.MIN_VALUE;
		
		for(int i=1;i<=N;i++) {
			dp[i]=Math.max(arr[i],dp[i-1]+arr[i]);
			max=Math.max(dp[i],max);
		}
		System.out.println(max);
	}
}