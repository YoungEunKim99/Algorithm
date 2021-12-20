package sort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int N;
    static int M;
    static int[] T;
    static long maxTime;
    
     public static void setData() throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine()," ");
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
        T=new int[N];
        for (int i = 0; i <N; i++) {
			T[i] = Integer.parseInt(br.readLine());
			maxTime=Math.max(maxTime,T[i]);
		}
    }
     
    public static long calcMinTime() {
    	long judged;
    	long start=0;
        long end=maxTime*M;
        long mid;
        
        while(start!=end) {
        	judged=0;
        	mid=(start+end)/2;
        	for(long time:T) {
        		judged+=mid/time;
        	}
        	if(judged>=M) {
        		end=mid;
        		
        	}
        	else {
        		start=mid+1;
        	}
        }
        return end;
    }
    
    public static void main(String[] args) throws IOException {
        setData();
        System.out.println(calcMinTime());
     
    }   
}