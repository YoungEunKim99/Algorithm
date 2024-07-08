import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Deque<String> q = new ArrayDeque<>();
        int answer = 0;

        for(String city: cities){
            city = city.toUpperCase();

            if(q.contains(city)){
                answer += 1;
                q.remove(city);
                q.addFirst(city);
            }
            else{
                answer += 5;
                q.addFirst(city);
            }

            if(q.size() > cacheSize){
                q.removeLast();
            }
        }

        return answer;
    }
}