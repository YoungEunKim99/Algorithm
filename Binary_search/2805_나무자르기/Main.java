package test;
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[] trees;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		int max=0;
		int min=0;
		trees=new int[N];
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			trees[i]=Integer.parseInt(st.nextToken());
			max=Math.max(trees[i],max);
		}
		while(min<max) {
			int mid=(min+max)/2;
			long sum=0;
			for(int tree:trees) {
				if(tree-mid>0) sum+=tree-mid;
			}
			if(sum>=M) min=mid+1;
			else max=mid;
		}
		
		System.out.println(min-1);
	}
}