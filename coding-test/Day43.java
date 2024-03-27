
import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/12973
public class Day43 {
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        
        List<Character> list = new ArrayList<>();
        list.add(s.charAt(0));
        for(int i = 1; i<s.length(); i++) {
            if((list.size() > 0) && (list.get(list.size()-1) == s.charAt(i))) {
                list.remove(list.size()-1);
            } else {
                list.add(s.charAt(i));
            }
        }
        if(list.size()==0) {
            answer = 1;
        } else {
            answer = 0;
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}
  
}
