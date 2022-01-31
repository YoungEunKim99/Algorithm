import java.util.*;
import java.io.*;


class Node{
	private char name;
	private char left;
	private char right;
	
	public Node(char name,char left, char right) {
		this.name=name;
		this.left=left;
		this.right=right;
	}
	public char getName() {
		return name;
	}
	public char getLeft() {
		return left;
	}
	public char getRight() {
		return right;
	}
}

public class Main {
	static int N;
	static Node[] tree;
	static StringBuilder sb;
	//전위
	public static void preorder(char name) {
		if(name=='.')return;
		
		sb.append(name);
		
		for(int j=0;j<N;j++) {//left
			if(tree[j].getName()==name) {
				preorder(tree[j].getLeft());break;
			}
		}
		for(int j=0;j<N;j++) {//right
			if(tree[j].getName()==name) {
				preorder(tree[j].getRight());break;
			}
		}
	}
	//중위
	public static void inorder(char name) {
		if(name=='.')return;
		for(int j=0;j<N;j++) {//left
			if(tree[j].getName()==name) {
				inorder(tree[j].getLeft());break;
			}
		}
		sb.append(name);
		
		for(int j=0;j<N;j++) {//right
			if(tree[j].getName()==name) {
				inorder(tree[j].getRight());break;
			}
		}
	}
	
	//후위
	public static void postorder(char name) {
		if(name=='.')return;
		for(int j=0;j<N;j++) {//left
			if(tree[j].getName()==name) {
				postorder(tree[j].getLeft());break;
			}
		}
		
		for(int j=0;j<N;j++) {//right
			if(tree[j].getName()==name) {
				postorder(tree[j].getRight());break;
			}
		}
		
		sb.append(name);
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		sb=new StringBuilder();
		N=Integer.parseInt(br.readLine());
		tree=new Node[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			char name=st.nextToken().charAt(0);
			char left=st.nextToken().charAt(0);
			char right=st.nextToken().charAt(0);
			tree[i]=new Node(name,left,right);
		}
		
		preorder('A');
		sb.append('\n');
		inorder('A');
		sb.append('\n');
		postorder('A');
		System.out.println(sb);
		
	}
	 
}
