package test;
import java.util.*;
import java.io.*;
 
public class Main {
  
	static int[][] numbers= {
			{1,1,1,0,1,1,1},
			{0,0,1,0,0,1,0},
			{1,0,1,1,1,0,1},
			{1,0,1,1,0,1,1},
			{0,1,1,1,0,1,0},
			{1,1,0,1,0,1,1},
			{1,1,0,1,1,1,1},
			{1,0,1,0,0,1,0},
			{1,1,1,1,1,1,1},
			{1,1,1,1,0,1,1}
	};
	static int N;
	static int K;
	static int P;
	static int X;
	static int[][] diff;
	
	public static int cntDiff(int x,int y) {
	
		int res=0;
		for(int rep=1;rep<=K;rep++) {
	    	res+=diff[x%10][y%10];
	    	x/=10;
	    	y/=10;
	    }
	    return res;
	
	}
	
    public static void main(String args[]) throws IOException{
    
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine()," ");
    	N=Integer.parseInt(st.nextToken());
    	K=Integer.parseInt(st.nextToken());
    	P=Integer.parseInt(st.nextToken());
    	X=Integer.parseInt(st.nextToken());
    	
    	diff=new int[10][10];
    	
    	for(int i=0;i<=9;i++) {
    		for(int j=0;j<=9;j++) {
    			for(int k=0;k<7;k++) {
    				diff[i][j]+=numbers[i][k]^numbers[j][k];
    			}
    		}
    	}
    	
    	int ans=0;
    	   
    	for(int i=1;i<=N;i++) {
    		if(cntDiff(i,X)<=P) {
    			ans++;
    		}
    	}
    	System.out.println(ans-1);
    }
   
}