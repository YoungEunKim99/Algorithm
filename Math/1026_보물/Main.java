import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	
	static Integer[] arrA;
	static Integer[] arrB;
	static int N;
	
	static public void setData() throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		arrA=new Integer[N];
		arrB=new Integer[N];
		for(int i=0;i<N;i++) {
			arrA[i]=Integer.parseInt(st.nextToken());
		}
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			arrB[i]=Integer.parseInt(st.nextToken());
		}
			
	}
	
	static public void main(String[] arg) throws IOException {
		
		setData();
		Arrays.sort(arrA, Collections.reverseOrder());
		Arrays.sort(arrB);
		int sum=0;
		for(int i=0;i<N;i++) {
			sum+=arrA[i]*arrB[i];
		}
		System.out.println(sum);
		
	}
		
}
