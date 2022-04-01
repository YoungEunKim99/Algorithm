package test;
import java.util.*;
import java.io.*;
 

public class Main {
	
	static int sensor;
	static int office;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sensor=Integer.parseInt(br.readLine());
		office=Integer.parseInt(br.readLine());
		int[] diff=new int[sensor-1];
		int[] location=new int[sensor];
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<sensor;i++) {
			location[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(location); //nlogn
		for(int i=1;i<sensor;i++) { //n-1
			diff[i-1]=(Math.abs(location[i-1]-location[i]));
		}
		Arrays.sort(diff); //nlogn
		
		int sum=0;
		for(int i=0;i<diff.length-(office-1);i++) {//n-1
			sum+=diff[i];
		}
		System.out.println(sum);
	}
}