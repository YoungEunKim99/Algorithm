import java.util.*;
class Solution {
    public String[] solution(String[] quiz) { 
        for(int i = 0; i< quiz.length;i++){
            String[] tmp = quiz[i].split(" ");

            int result = Integer.parseInt(tmp[0]) 
                + Integer.parseInt(tmp[2]) * ("+".equals(tmp[1]) ? 1:-1);
        
           quiz[i] = (result == Integer.parseInt(tmp[4])) ? "O": "X";
        }
        return quiz;
    }
}