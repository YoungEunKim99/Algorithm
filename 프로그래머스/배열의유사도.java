import java.util.*;
class Solution {
    public int solution(String[] s1, String[] s2) {
        int size = s1.length + s2.length;
        HashSet<String> set = new HashSet<String>();
        
        for(String s : s1){
            set.add(s);    
        }
        
        for(String s: s2){
            set.add(s);
        }
        
        return size-set.size();
    }
}