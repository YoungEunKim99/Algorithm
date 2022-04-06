package test;
import java.util.*;
import java.io.*;

public class Main {
  
    static int N,K;
    static int cnt=0;
    static boolean answered = false;
    static ArrayList<Integer> arr = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    
    
    public static void dfs(int depth,int sum) {
    	if(sum==N) {
    		cnt++;
    		if(cnt==K) {
    			answered = true;
    			for(int i=0;i<arr.size();i++) {
    				if(i==arr.size()-1) {
    					sb.append(arr.get(i));
    					continue;
    				}
    				
    				sb.append(arr.get(i)+"+");
    			}
    		}
    	}
    	else {
    		for(int i=1;i<=3;i++) {
    			if(sum+i>N || answered) {
    				return;
    			}
    	
    			sum+=i;
    			arr.add(i);
    			
    			dfs(depth+1,sum);
    			
    			arr.remove(depth);
    			sum-=i;
    		}
    		
    	}
    }
    
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	
    	dfs(0,0);
    	if(!answered) {
    		System.out.println(-1);
    	}
    	else {
    		System.out.println(sb);
    	}
    	
    }
}    