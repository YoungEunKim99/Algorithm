package test;
import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int A=Integer.parseInt(st.nextToken());
		int B=Integer.parseInt(st.nextToken());
		
		int cnt=0;
		while(A<B) {
		
			if(B%10==1) {
				B/=10;
			}
			else {
				B/=2;
			}
			cnt++;
		}
		
		if(A==B) {
			System.out.println(cnt+1);
		}
		else {
			System.out.println(-1);
		}
	}
}