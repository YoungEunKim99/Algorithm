package test;
import java.io.*;
import java.util.*;

class Advertise{
	int cost;
	int client;
	public Advertise(int cost,int client) {
		this.cost=cost;
		this.client=client;
	}
}
public class Main {
	
	static int C;
	static int N;
	static Advertise[] advertise;
	static int[] dp;//고객 i명을 데려오기 위한 최소 비용
	
	public static void solve() {
		for(int i=1;i<=C;i++) {
			for(int k=0;k<i;k++) {
				for(int j=0;j<N;j++) {
					if(k+advertise[j].client>=i) {
						dp[i]=Math.min(advertise[j].cost+dp[k],dp[i]);
					}
				}
				
				
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		C=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		advertise=new Advertise[N];
		dp=new int[C+1];
		for(int i=1;i<=C;i++) {
			dp[i]=Integer.MAX_VALUE;
		}
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			Advertise tmp=new Advertise(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			advertise[i]=tmp;
		}
		solve();
		System.out.println(dp[C]);
	}
	
}