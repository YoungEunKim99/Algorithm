package test;
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String str=br.readLine();
		Stack<Double> stack=new Stack<Double>();
		double[] value=new double[n];
		for(int i=0;i<n;i++) {
			value[i]=Integer.parseInt(br.readLine());
		}
		
		for(int i=0;i<str.length();i++) {
			
			if(str.charAt(i)>='A'&&str.charAt(i)<='Z') {
				stack.push(value[str.charAt(i)-'A']);
			}
			else {
				if(str.charAt(i)=='-') {
					double a=stack.pop();
					double b=stack.pop();
					stack.push(b-a);
				}
				else if(str.charAt(i)=='+') {
					stack.push(stack.pop()+stack.pop());
				}
				else if(str.charAt(i)=='/') {
					double a=stack.pop();
					double b=stack.pop();
					stack.push(b/a);
				}
				else if(str.charAt(i)=='*') {
					stack.push(stack.pop()*stack.pop());
				}
			}
		}
		System.out.printf("%.02f",stack.pop());
	}
}