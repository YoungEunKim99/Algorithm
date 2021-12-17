package sort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    static int X;
    static int Y;
   
    static void setData() throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine()," ");
        X = Integer.parseInt(st.nextToken());
        Y= Integer.parseInt(st.nextToken());
        
    }
    public static void main(String[] args) throws IOException {
       
        setData();
        int start=0;
        int Z=(Y*100)/X;
        int end=X;
        int mid;
        if(Z>=99) {
        	System.out.println(-1);
        }
        else {
        	while(start<end) {
        		mid=(end+start)/2;
            	if((Y+mid)*100/(X+mid)>Z) {
            		end=mid;
            	}
            	else {
            		start=mid+1;
            	}
            }
            System.out.println(end);
        }
        
    }   
}