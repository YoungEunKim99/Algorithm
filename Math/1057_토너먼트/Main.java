import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    static int N;
    static int numKim;
    static int numLim;
    
    static void setData() throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        numKim = Integer.parseInt(st.nextToken());
        numLim = Integer.parseInt(st.nextToken());
    }
    public static void main(String[] args) throws IOException {
        int round=0;
        setData();
       
        while(!(numKim==numLim)){
        	round++;
        	numKim=(numKim+1)/2;
        	numLim=(numLim+1)/2;
        	
        }
        System.out.println(round);
    }
    
}