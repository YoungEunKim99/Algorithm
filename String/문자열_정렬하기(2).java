import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String myStr) {
        myStr = myStr.toLowerCase();
        
    	return myStr
    			.chars()
    			.mapToObj(c -> (char) c)
    			.sorted()
    			.map(String::valueOf)
    			.collect(Collectors.joining());
    }
}