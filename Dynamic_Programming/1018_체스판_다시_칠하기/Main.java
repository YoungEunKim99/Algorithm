package Test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	public static void main(String[]args) throws IOException{

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		StringTokenizer st=new StringTokenizer(str," ");
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		boolean[][] chess= new boolean[N][M];
		int min=64;
		int find_min=0;

		for(int i=0;i<N;i++) {
			str=br.readLine();
			for(int j=0;j<M;j++) {
				if(str.charAt(j)=='W') {
					chess[i][j]=true;
				}
				else {
					chess[i][j]=false;
				}
			}
		}
		
		int N_row=N-7;
		int M_col=M-7;
		
		for(int i=0;i<N_row;i++) {
			for(int j=0;j<M_col;j++) {
				find_min=find(i,j,chess);
				if(find_min<min) {
					min=find_min;
				}
			}
		}
		System.out.println(min);
		
	}
	
	public static int find(int x, int y, boolean[][] chess) {
		int cnt=0;
		boolean TF=chess[x][y];
		
		for(int i=x;i<x+8;i++) {
			for(int j=y;j<y+8;j++) {
				if(TF!=chess[i][j]) {
					cnt++;
				}
				TF=!TF;
			}
			TF=!TF;
		}
		
		cnt=Math.min(cnt, 64-cnt);
		return cnt;
	}
}
