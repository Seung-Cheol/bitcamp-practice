import java.util.*;
public class Day37 {
class Solution {
  //https://school.programmers.co.kr/learn/courses/20847/lessons/255900?language=java
    public String solution(String input_string) {
        String answer = "";
        
        //맵으로 쌍 갯수 묶고
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i<input_string.length(); i++) {
            char temp = input_string.charAt(i);
            map.put((int)temp, map.getOrDefault((int)temp,0) + 1);
        }
        
        //인풋스트링에 있는 문자열 중에 갯수 repeat해서 포함되어있는지 확인하기
        for(int i = 0; i<input_string.length(); i++) {
            char cstring = input_string.charAt(i);
            int temp = (int)cstring;
            String later = Character.toString(cstring).repeat(map.get(temp));
            if(!input_string.contains(later)) {
                answer = cstring + answer;
                map.put(temp,0);
            }
        }
        char[] answer2 = answer.toCharArray();
        Arrays.sort(answer2);
        answer = new String(answer2);
        
        if(answer.equals("")) {
            answer = "N";
        }
        
        return answer;
    }
}
}
