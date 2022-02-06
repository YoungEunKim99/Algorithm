package test;
import java.io.*;
import java.util.*;

public class Main {
	static int R;
	static int C;
	static int T;
	static int[][] A;
	static int[] ac;
	static int[] di= {0,1,0,-1};
	static int[] dj= {-1,0,1,0};
	
	public static void spread() {
		int[][] newA=new int[R][C];
		newA[ac[0]][0]=-1;
		newA[ac[1]][0]=-1;
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(A[i][j]==-1) continue;
				
				newA[i][j]+=A[i][j];
				
				if(A[i][j]<5) continue;
				
				int dust=A[i][j]/5;
					
				for(int k=0;k<4;k++) {
					int ni=i+di[k];
					int nj=j+dj[k];
					
					if(ni>=0&&ni<R&&nj>=0&&nj<C&&A[ni][nj]!=-1) {
						newA[ni][nj]+=dust;
						newA[i][j]-=dust;
					}
				}	
			}
		}
		A=newA;
	}
	
	public static void counterClockWise(int i) {
		for(int k=i-1;k>0;k--) {//밑으로
			A[k][0]=A[k-1][0];
		}
		for(int j=0;j<C-1;j++) {//왼쪽으로
			A[0][j]=A[0][j+1];
		}
		for(int k=0;k<i;k++) {//위로
			A[k][C-1]=A[k+1][C-1];
		}
		for(int j=C-1;j>1;j--) {//오른쪽으로
			A[i][j]=A[i][j-1];
		}
		A[i][1]=0;
	}
	
	public static void clockWise(int i) {
		for(int k=i+1;k<R-1;k++) {//위로
			A[k][0]=A[k+1][0];
		}
		for(int j=0;j<C-1;j++) {//왼쪽으로
			A[R-1][j]=A[R-1][j+1];
		}
		for(int k=R-1;k>i;k--) {//밑으로
			A[k][C-1]=A[k-1][C-1];
		}
		for(int j=C-1;j>1;j--) {//오른쪽으로
			A[i][j]=A[i][j-1];
		}
		A[i][1]=0;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		A=new int[R][C];
		ac=new int[2];
		
		for(int i=0;i<R;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<C;j++) {
				int tmp=Integer.parseInt(st.nextToken());
				A[i][j]=tmp;
				if(tmp==-1) {
					if(ac[0]>0) ac[1]=i;
					else ac[0]=i;
				}
				
			}
		}
		
		while(T-->0) {
			spread();
			counterClockWise(ac[0]);
			clockWise(ac[1]);
		}
		
		int sum=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				sum+=A[i][j];
			}
		}
		System.out.println(sum+2);
	}
}