package test;
import java.util.*;
import java.io.*;

public class Main {
	static int[][] arr;
	static int blue;
	static int white;
	
	public static boolean checkColor(int size,int startX,int startY) {
		int color=arr[startY][startX];
		
		for(int i=startY;i<startY+size;i++) {
			for(int j=startX;j<startX+size;j++) {
				if(color!=arr[i][j]) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static void divide(int size,int startX, int startY) {
		boolean different=checkColor(size,startX,startY);
	
		if(different) {
			divide(size/2,startX,startY);
			divide(size/2,startX+(size/2),startY);
			divide(size/2,startX,startY+(size/2));
			divide(size/2,startX+(size/2),startY+(size/2));
		}
		else {
			if(arr[startY][startX]==1) blue++;
			else white++;
		}
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int N=Integer.parseInt(br.readLine());
		arr=new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		divide(N,0,0);
		sb.append(white).append("\n").append(blue).append("\n");
		System.out.println(sb);
		
	}
	 
}
