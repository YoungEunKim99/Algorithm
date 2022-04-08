package test;
import java.util.*;
import java.io.*;

public class Main {
  
    
    public static void main(String[] args) throws NumberFormatException, IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int T=Integer.parseInt(br.readLine());
       StringBuilder sb=new StringBuilder();
       
       while(T-->0) {
    	   int K=Integer.parseInt(br.readLine());
    	   PriorityQueue<Integer> file=new PriorityQueue<>();
    	   
    	   StringTokenizer st=new StringTokenizer(br.readLine()," ");
    	   for(int i=0;i<K;i++) {
    		   file.add(Integer.parseInt(st.nextToken()));
    	   }
    	   int sum=0;
    	   while(file.size()!=1) {
    		  
    		   int a=file.poll();
    		   int b=file.poll();
    		   sum+=a+b;
    		   file.add(a+b);
    	   }
    	   sb.append(sum+"\n");
       }
       System.out.println(sb);
    }
 
}