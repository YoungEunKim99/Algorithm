package test;
import java.io.*;
import java.util.*;

class Node{
	int x;
	int y;
	public Node(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

public class Main {
	static int h;
	static int w;
	static int[][] map;

	public static int calcuateVolume() {
		int cntWater=0;
		for(int i=h-1;i>=0;i--) {
			for(int j=0;j<w;j++) {
				if(map[i][j]==0) {
					boolean right=false;
					boolean left=false;
					boolean bottom=false;
					for(int k=1;k<w;k++) {
						if(j-k>=0&&map[i][j-k]==1) {//왼쪽
							left=true;
						}
						if(j+k<w&&map[i][j+k]==1) {//오른쪽
							right=true;
						}
							
						if(left&&right) break;
					}
					if(i==h-1||map[i+1][j]==1) {
						bottom=true;
					}
					if(left==true&&right==true&&bottom==true) {
						map[i][j]=1;
						cntWater++;
					}
				}
			}
		}
		return cntWater;
	}
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		h=Integer.parseInt(st.nextToken());
		w=Integer.parseInt(st.nextToken());
		map=new int[h][w];
		
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<w;i++) {
			int n=Integer.parseInt(st.nextToken());
			for(int j=h-n;j<h;j++) {
				map[j][i]=1;
			}
		}
		
		System.out.println(calcuateVolume());
		
	}

}
