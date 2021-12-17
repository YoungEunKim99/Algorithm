package sort;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;


public class Main {
	static public void main(String[] arg)throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		while(T-->0) {
			int planetX;
			int planetY;
			int planetR;
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int startX=Integer.parseInt(st.nextToken());
			int startY=Integer.parseInt(st.nextToken());
			int endX=Integer.parseInt(st.nextToken());
			int endY=Integer.parseInt(st.nextToken());
			int n=Integer.parseInt(br.readLine());
			boolean checkStart=false;//행성 안일 시 true
			boolean checkEnd=false;
			int cnt=0;
			for(int i=0;i<n;i++) {
				
				 st=new StringTokenizer(br.readLine()," ");
				 planetX=Integer.parseInt(st.nextToken());
				 planetY=Integer.parseInt(st.nextToken());
				 planetR=Integer.parseInt(st.nextToken());
				 if((Math.pow(startX-planetX, 2)+Math.pow(startY-planetY, 2))<Math.pow(planetR, 2)) {
					 checkStart=true;
				 }
				 if((Math.pow(endX-planetX, 2)+Math.pow(endY-planetY, 2))<Math.pow(planetR, 2)) {
					 checkEnd=true;
				 }
				 
				 if(checkStart^checkEnd) {
					 cnt++;
				 }
				 checkStart=false;
					checkEnd=false;
			}
			
			sb.append(cnt).append('\n');
		}
		System.out.println(sb);
	
	}

}
