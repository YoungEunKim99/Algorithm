package test;
import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int blue=0;
		int red=0;
		int N=Integer.parseInt(br.readLine());
		String str=br.readLine();
		
		StringTokenizer st=new StringTokenizer(str, "R");
		while(st.hasMoreTokens()) {
			st.nextToken();
			blue++;
		}
		
		st=new StringTokenizer(str, "B");
		while(st.hasMoreTokens()) {
			st.nextToken();
			red++;
		}
		
		if(blue<red) {
			System.out.println(blue+1);
		}
		else {
			System.out.println(red+1);
		}
		
	}
}