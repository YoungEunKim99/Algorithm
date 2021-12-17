package sort;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;



public class Main {

	static public void main(String[] arg)throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());	
		int M = Integer.parseInt(st.nextToken());	
		int cnt=0;
		LinkedList<Integer> deque = new LinkedList<Integer>();
		
		for(int i = 1; i <= N; i++) {
			deque.offer(i);
		}

		st = new StringTokenizer(br.readLine(), " ");
		while(M-->0) {
			int num=Integer.parseInt(st.nextToken());
			if(deque.size()/2-deque.indexOf(num)+1>0) {
				while(true) {
					int x=deque.poll();
					if(num==x) {
						break;
					}
					else {
						deque.addLast(x);
						cnt++;
					}
				}
			}
			else {
				while(true) {
					if(num==deque.peekFirst()) {
						deque.pollFirst();
						break;
					}
					else {
						deque.addFirst(deque.pollLast());
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
		
	
	}
	

}
