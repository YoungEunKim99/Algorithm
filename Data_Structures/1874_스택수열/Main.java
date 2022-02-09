package test;
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int n=Integer.parseInt(br.readLine());
		int lastPushed=0;
		Stack<Integer>stack=new Stack();
		
		for(int i=0;i<n;i++) {
			int number=Integer.parseInt(br.readLine());
			
			if(lastPushed<number) {
				for(int k=lastPushed+1;k<=number;k++) {
					stack.push(k);
					sb.append("+\n");
				}
					
				lastPushed=number;
			}
			else {
				if(stack.peek()!=number) {
					sb=new StringBuilder();
					sb.append("NO");
					break;
				}
			}
			int num= stack.pop();
			sb.append("-\n");
		}

		System.out.println(sb);
		
	}
}