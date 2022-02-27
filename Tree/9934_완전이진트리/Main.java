package test;
import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb=new StringBuilder();
	static int k;
	static int[] map;
	static  int totalCity;
	static ArrayList<Integer>[] level;
	
	public static void inorder(int citys,int middle,int cnt) {
		if(cnt>=k) return;
		
		int tmp=Math.abs(middle-citys)/2;
		level[cnt++].add(map[citys]);
		
		inorder(citys-tmp,citys,cnt);
		inorder(citys+tmp,citys,cnt);
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		k=Integer.parseInt(br.readLine());
	    totalCity=(int) Math.pow(2,k);
	    map=new int[totalCity];
	    level=new ArrayList[k];
		for(int i=0;i<k;i++) {
			level[i]=new ArrayList<>();
		}
		 
		StringTokenizer st=new StringTokenizer(br.readLine()," ");	
		for(int i=1;i<totalCity;i++) {
			map[i]=Integer.parseInt(st.nextToken());
	    }
		
		inorder(totalCity/2,totalCity,0);
		
		for(int i=0;i<k;i++) {
			for(int j=0;j<level[i].size();j++) {
				sb.append(level[i].get(j) + " "); 
		    }
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
}