package test;
import java.io.*;
import java.util.*;


public class Main {
	static StringBuilder sb=new StringBuilder();
	
	public static boolean makePoly(int cnt) {
		if(cnt%2!=0) {
			return false;
		}
		
		while(cnt!=0) {
			if(cnt>=4) {
				sb.append("AAAA");
				cnt-=4;
			}
			else if(cnt%2==0) {
				sb.append("BB");
				cnt-=2;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		
		int cnt=0;
		
		for(int i=0;i<str.length();i++) {
			
			if(str.charAt(i)=='X') {
				cnt++;
			}
			else {
				if(!makePoly(cnt)) {
					System.out.println(-1);return;
				}
				cnt=0;
				sb.append(".");
			}
		}
		
		if(cnt>0) {
			if(!makePoly(cnt)) {
				System.out.println(-1);return;
			}
		}
		
		System.out.println(sb);
	}
}