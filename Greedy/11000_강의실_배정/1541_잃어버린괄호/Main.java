package test;
import java.io.*;
import java.util.*;


class Node{
	int node;
	int cost;
}

public class Main {

	public static int add(String tmp) {
		int sum=0;
		
		String[] plus=tmp.split("\\+");
		for(int j=0;j<plus.length;j++) {
			sum+=Integer.parseInt(plus[j]);
		}
		return sum;	
	}
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String str=br.readLine();
		String[] tmp=str.split("\\-");
		
		int sum=add(tmp[0]);
		
		for(int i=1;i<tmp.length;i++) {
			sum-=add(tmp[i]);
		}
	
		System.out.println(sum);
	}

}