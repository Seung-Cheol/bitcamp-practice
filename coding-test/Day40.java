import java.util.*;
public class Day40 {
class Solution {
    public String solution(String s) {
        String answer = "";
        ArrayList<String> arr = new ArrayList<>(Arrays.asList(s.split(" ")));
        int max = Integer.parseInt(arr.get(0));
        int min = Integer.parseInt(arr.get(0));
        for(int i = 1; arr.size() > i; i++) {
            int intValue = Integer.parseInt(arr.get(i));
            if(intValue >= max) {
                max = intValue;
            }
            
            if(intValue<=min) {
                min = intValue;
            }
        }
        answer = answer + min + " " + max;
        
        return answer;
    }
}
}
