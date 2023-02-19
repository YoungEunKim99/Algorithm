class Solution {
   
    public int gcd(int a, int b) {
		if(a % b == 0) return b;
		
		return gcd(b, a%b);
	}
    
    public int solution(int a, int b) {
        int answer = 1;
        
        a = b/gcd(b,a);
        
    	if(a % 2 == 0){
            while(a %2 == 0) a /= 2;
        }
    		
    	if(a % 5 == 0){
            while(a % 5 == 0) a /= 5;
        }	
    		
    	if(a != 1) answer = 2;

        return answer;
    }
}