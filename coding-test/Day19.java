public class Day19 {
  //https://school.programmers.co.kr/learn/courses/30/lessons/12918
  class Solution {
    public boolean solution(String s) {
        if(s.length()!=4 && s.length()!=6) {
            return false;
        }
        
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i)>=65) {
                return false;
            }
        }
        return true;
    }
}
}
