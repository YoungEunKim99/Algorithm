package test;
import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer> list;
    static int N;
    static int max=Integer.MIN_VALUE;
    static boolean[] visited;
    
    public static void dfs(int sum) {
    	if(list.size()<=2) {
    		max=Math.max(max,sum+list.get(0)*list.get(1));
    	}
    	else{
    		for(int i=1;i<list.size()-1;i++) {
    			int num=list.get(i-1)*list.get(i+1);
    			int tmp=list.get(i);
    			sum+=num;
    			
    			list.remove(i);
    			
    			dfs(sum);
    			
    			sum-=num;
    			list.add(i,tmp);
    			
    		}
    	}
    }
    
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());

    	list = new ArrayList<>();
    	visited=new boolean[N];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	for(int i=0;i<N;i++) {
    		list.add(Integer.parseInt(st.nextToken()));
    	}
    	
    	dfs(0);
    }
}    