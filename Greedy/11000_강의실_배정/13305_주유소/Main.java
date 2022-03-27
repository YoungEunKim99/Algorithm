package test;
import java.io.*;
import java.util.*;


class Node{
	int node;
	int cost;
}

public class Main {

	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] cost=new int[N-1];
		int[] price=new int[N];
		
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N-1;i++) {
			cost[i]=Integer.parseInt(st.nextToken());
		}
		
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			price[i]=Integer.parseInt(st.nextToken());
		}
		
		int prev=price[0];
		int sum=price[0]*cost[0];
		
		for(int i=1;i<N-1;i++) {
			
			if(prev>price[i]) {
				prev=price[i];
			}
			sum+=prev*cost[i];
		}
		
		System.out.println(sum);
		
	}

}