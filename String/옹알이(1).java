import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int cnt = 0;
    	
    	babbling = Arrays
    	                    .stream(babbling)
    	                    .map(str -> str.replaceFirst("aya", "1")
    			                            .replaceFirst("ye", "1")
    			                            .replaceFirst("woo","1")
    			                            .replaceFirst("ma", "1")
                                            .replace("1",""))
    	                    .toArray(String[]::new);
    
    	
    	for(String b: babbling) {
    		if("".equals(b)) {
    			cnt++;
    		}
    	}
    	
        return cnt;
    }
}