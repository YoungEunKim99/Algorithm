import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

	static public void main(String[] arg) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int N=Integer.parseInt(st.nextToken());
		int L=Integer.parseInt(st.nextToken());
		StringBuilder sb=new StringBuilder();
		int x=-2;

		for(int i=L;i<=100;i++) {
			double temp=(double)N/i-(double)(i+1)/2;
			
			if(Math.round(temp)==temp&&temp>=-1) {
				L=i;
				x=N/i-(i+1)/2;
				break;
			}
		}

		if(x==-2) {
			System.out.println(-1);
		}
		else {
			for(int i=1;i<=L;i++) {
				sb.append(x+i).append(" ");
			}
			System.out.println(sb);
		}
		
	}
}
