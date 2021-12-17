import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
public static void main(String[]args) throws IOException {
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	int T=Integer.parseInt(br.readLine());
	int[][] coordinate=new int[T][6]; //x1, y1, r1,x2,y2,r2
	StringBuilder sb=new StringBuilder();
	
	for(int i=0;i<T;i++) {
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		coordinate[i][0]=Integer.parseInt(st.nextToken());
		coordinate[i][1]=Integer.parseInt(st.nextToken());
		coordinate[i][2]=Integer.parseInt(st.nextToken());
		coordinate[i][3]=Integer.parseInt(st.nextToken());
		coordinate[i][4]=Integer.parseInt(st.nextToken());
		coordinate[i][5]=Integer.parseInt(st.nextToken());
		sb.append(find_marin(coordinate[i])).append('\n');
	}
	System.out.println(sb);

}

public static int find_marin(int[] c) {
	double distance= Math.sqrt((Math.pow((c[0]-c[3]),2)+Math.pow((c[1]-c[4]),2)));
	if(c[0]==c[3]&&c[1]==c[4]&&c[2]==c[5]) {//������ ��ġ�� �ְ� �������� ������ ������ ���� ���Ѱ�
		return -1;
	}
	
	else if(distance==c[2]+c[5]||distance==Math.abs(c[5]-c[2])) {//�����ϰų� �����ϸ� ������ ���� �Ѱ�
		return 1;
	}
	else if(distance>c[5]+c[2]||distance<Math.abs(c[5]-c[2])) {//�� �������� �Ÿ��� �� ���� ������ �պ��� ũ�ų� �������� ���� �� ���� �����Ÿ����� ũ�� ������ �ʴ´�
		return 0;
	}
	else {// �� �̿ܿ��� �������� ������.
		return 2;
	}
}
}
