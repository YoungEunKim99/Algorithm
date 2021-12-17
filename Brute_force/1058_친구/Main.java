import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Main {
    static int N;
    static char[][] arr;
    static boolean[][] friend;
    
    static void setData() throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr=new char[N][N];
        friend=new boolean[N][N];
        
        for(int i=0;i<N;i++) {
        	String str=br.readLine();
        	for(int j=0;j<N;j++) {
        		arr[i][j]=str.charAt(j);
        	}
        }
    }
    public static void main(String[] args) throws IOException {
       
        setData();
        for(int i=0;i<N;i++) {
        	for(int j=0;j<N;j++) {
        		if(arr[i][j]=='Y') {
        			friend[i][j]=true;
        			for(int k=0;k<N;k++) {
        				if(arr[j][k]=='Y'&&k!=i&&arr[i][k]=='N') {
        					friend[i][k]=true;
        				}
        			}
        			
        		}
        	}
        }
        int cnt[]=new int[N];
        for(int i=0;i<N;i++) {
        	for(int j=0;j<N;j++) {
        		if(friend[i][j]==true) {
            		cnt[i]++;
            	}
        	}
        }
       Arrays.sort(cnt);
       System.out.println(cnt[N-1]);
       
    }
    
}