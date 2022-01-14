package beakjoon;
import java.io.*;
import java.util.*;


public class Main {
	static int r;
	static int c;
	static char[][] map;
	static char[][] future;
	
	public static void setData()throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		
		map=new char[r][c];
		future=new char[r][c];
		for(int i=0;i<r;i++) {
			Arrays.fill(future[i], 'X');
			map[i]=br.readLine().toCharArray();
		}
	}
	
	public static void calculateFutureMap() {
		StringBuilder sb=new StringBuilder();
		int startX=r;
		int endX=0;
		int startY=c;
		int endY=0;
		int[] di= {0,1,0,-1};
		int[] dj= {1,0,-1,0};
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				int cnt=0;
				
				if(map[i][j]=='X') {
					for(int k=0;k<4;k++){
						int x=i+di[k];
						int y=j+dj[k];
						if(x==-1||y==-1||x==r||y==c||map[x][y]=='.') {
							cnt++;
						}
					}	
				}
				
				if(cnt>=3) {
					future[i][j]='.';
				}
				
				if(map[i][j]=='X'&&future[i][j]=='X') {
					startX=Math.min(startX, i);
					endX=Math.max(endX, i);
					startY=Math.min(startY, j);
					endY=Math.max(endY, j);
				}
				else {
					future[i][j]='.';
				}
			}
		}
		
		for(int i=startX;i<=endX;i++) {
			for(int j=startY;j<=endY;j++) {
				sb.append(future[i][j]);
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws IOException{
		setData();
		calculateFutureMap();
	}
}
