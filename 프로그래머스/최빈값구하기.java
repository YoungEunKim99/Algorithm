import java.util.*;
class Solution {
    public int solution(int[] array) {
        int[] cnt = new int[1001];
        int max = 0, maxIdx = 0, temp = 0;   
    	
        Arrays.stream(array)
    		  .forEach(a -> cnt[a]++);
         
        for(int i = 0 ; i < cnt.length ; i++){
            if(cnt[i] > max){
                max = cnt[i];
                maxIdx = i;
            }
        }
        
        for(int c: cnt){
            if(c == max) temp++;
            if(temp > 1) return -1;
        }
     
        return maxIdx;
    }
}
 