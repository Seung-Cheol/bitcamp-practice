import java.util.*;
public class Day50 {
//https://school.programmers.co.kr/learn/courses/30/lessons/12909
class Solution {
    boolean solution(String s) {
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");
        List<String> arr = new ArrayList<>();
        for(int i = 0; i<s.length(); i++) {
            if(s.substring(i,i+1).equals("(")) {
                arr.add("stack");
                continue;
            }
            if(arr.size()==0) {
                return false;
            }
            if(s.substring(i,i+1).equals(")")) {
                arr.remove(arr.size()-1);
            }
        }
        if(arr.size()==0) {
            return true;
        } else {
            return false;
        }
    }
}
  
}
