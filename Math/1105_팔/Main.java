import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    static String L;
    static String R;
    
  
    
    static void setData() throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine()," ");
        L = st.nextToken();
        R= st.nextToken();
        
    }
    public static void main(String[] args) throws IOException {
        setData();
        int numOf8=0;
        
        if(L.length()==R.length()) {
        	for(int i=0;i<R.length();i++) {
        		if(L.charAt(i)==R.charAt(i)&&R.charAt(i)=='8') {
        			numOf8++;
        		}
        		else if(L.charAt(i)!=R.charAt(i)){
        			break;
        		}
        	}
        }
        
        System.out.println(numOf8);
        
        
    }   
}