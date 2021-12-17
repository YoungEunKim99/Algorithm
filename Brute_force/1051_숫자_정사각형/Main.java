package sort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	
	static int N;
	static int M;
	static int[][] arr;
	
	static public void setData() throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[N][M];
		
		for(int i=0;i<N;i++) {
			String str=br.readLine();
			for(int j=0;j<M;j++) {
				arr[i][j]=str.charAt(j)-'0';
			}
		}	
	}
	static public void area() {
		int maxLength=M>=N?N:M;
		int maxArea=1;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				for(int k=1;k<maxLength;k++) {
					if((i+k)<N&&(j+k)<M) {
						if(arr[i][j]==arr[i+k][j+k]&&arr[i][j]==arr[i][j+k]&&arr[i][j]==arr[i+k][j]) {
							if(maxArea<(k+1)*(k+1)) {
								maxArea=(k+1)*(k+1);
							}
							
						}
					}
					
				}
				
			}
			
		}
		System.out.println(maxArea);
	}
	static public void main(String[] arg) throws IOException {
		
		setData();
		area();
	}
		
}
