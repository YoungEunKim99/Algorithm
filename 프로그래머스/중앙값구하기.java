import java.util.*;
class Solution {
    public int solution(int[] array) {
       array = Arrays
                            .stream(array)
                            .sorted()
                            .toArray();
    	return array[array.length/2];
    }
}