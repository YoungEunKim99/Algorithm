package test;
import java.util.*;
import java.io.*;

class Node{
	int priority;
	int nodeNum;
	public Node(int priority,int nodeNum) {
		this.priority=priority;
		this.nodeNum=nodeNum;
	}
}
public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int T=Integer.parseInt(br.readLine());

		while(T-->0) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			Queue<Node> q=new LinkedList<>();
			
			st=new StringTokenizer(br.readLine()," ");
			for(int nodeNumber=0;nodeNumber<N;nodeNumber++) {
				int priority=Integer.parseInt(st.nextToken());
				q.offer(new Node(priority,nodeNumber));
			}
			
			int order=1;
			while(!q.isEmpty()) {
				Node currentNode=q.poll();
				boolean isMax=true;
				
				Iterator<Node> iterator=q.iterator();
				while(iterator.hasNext()) {//나머지 문서 확인
					Node nextNode=iterator.next();
					if(currentNode.priority<nextNode.priority) {
						isMax=false;break;
					}
				}
				
				if(!isMax) {
					q.offer(currentNode);
				}
				else {
					if(currentNode.nodeNum==M) {
						sb.append(order).append("\n");
					}
					else {
						order++;
					}
				}
			}
			
			
		}
		System.out.println(sb);
	}
	 
}
