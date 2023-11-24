import java.util.Map;
import java.util.HashMap;

public class Day4 {
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<String,Integer> hashmap = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
          //객체의 키값은 원시값이 아니어야해서 char가 그대로 들어갈 수 없으며 레퍼런스 타입만 들어갈 수 있다
            String literal = Character.toString(s.charAt(i));
            boolean check = hashmap.containsKey(literal);
            if(!check) {
                answer[i] = -1;
            }
            
            if(check) {
                answer[i] = i - hashmap.get(literal);
                //키값이 중복이면 이후의 값이 덮어쓴다는 부분 확인
                hashmap.remove(literal);
                    
            }
            hashmap.put(literal,i);
            
        }
        
            
        return answer;
    }
  }
}
