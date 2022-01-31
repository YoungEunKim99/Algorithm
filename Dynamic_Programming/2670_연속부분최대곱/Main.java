package test;
import java.util.*;
import java.io.*;

public class Main {
	
	public  static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		double[] dp=new double[N+1];
		double[] number=new double[N+1];
		
		
		for(int i=1;i<=N;i++) {
			number[i]=Double.parseDouble(br.readLine());
		}
		
		dp[1]=number[1];
		Double max=dp[1];
		for(int i=2;i<=N;i++) {
			dp[i]=Math.max(dp[i-1]*number[i],number[i]);
			max=Math.max(max,dp[i]);
		}
		
		System.out.printf("%.3f",max);
	}
}